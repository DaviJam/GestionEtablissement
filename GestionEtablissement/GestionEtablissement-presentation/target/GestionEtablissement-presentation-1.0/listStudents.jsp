<%@ page pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestionetablissement.service.PersonService" %>
<%@ page import="eu.ensup.gestionetablissement.dto.PersonDTO" %>
<%@ page import="eu.ensup.gestionetablissement.dto.StudentDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Etudiant - Bootstrap</title>

    <style>
        html, body, input, select{font-family: 'Montserrat', sans-serif;}
        .br-round{border-radius: 50px!important;}
    </style>
</head>
<body class="container bg-light">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <img class="navbar-brand" src="img/logo.png" width="150">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="createStudent.jsp" id="p_student">Créer un étudiant</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="manageCourses.jsp" id="p_courses">Gérer les cours</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-primary" href="listStudents.jsp" id="p_list">Liste des étudiants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="statistiques.jsp" id="p_list">Statistiques</a>
                </li>
            </ul>
            </div>
        </div>
    </nav>

    <%
        if (request.getAttribute("error") != null) {
    %>
        <div class="alert alert-danger" role="alert">
          <%=request.getAttribute("error")%>
        </div>
    <%
        }
    %>
    <%
        if (request.getAttribute("success") != null) {
    %>
        <div class="alert alert-success" role="alert">
          <%=request.getAttribute("success")%>
        </div>
    <%
        }
    %>

    <div class="page">
        <div class="row">
            <div class="col bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
                <h1>Liste des étudiants</h1>
                <table class="table table-hover">
                    <tr>
                        <td>Prénom</td>
                        <td>Nom</td>
                        <td>Email</td>
                        <td>Adresse</td>
                        <td>Téléphone</td>
                        <td>Date de naissance</td>
                        <td>Moyenne</td>
                        <td>#</td>
                        <td>#</td>
                    </tr>
                    <%
                       PersonService ps = new PersonService();
                       int i = 0;
                       for(PersonDTO p : ps.getAll()){
                            if(p instanceof StudentDTO) {
                            i += 1;
                    %>
                        <tr>
                                <td style="display: none;"><form id="modifyStudent<%=i%>" method="POST" action="ManageUserController"></form></td>
                                <td style="display: none;"><input form="modifyStudent<%=i%>" type="hidden" name="action" value="update"/></td>
                                <td style="display: none;"><input form="modifyStudent<%=i%>" type="hidden" name="id" value="<%=p.getId()%>"/></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="name" value="<%=p.getLastname()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="firstname" value="<%=p.getFirstname()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="mail" value="<%=p.getMailAddress()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="address" value="<%=p.getAddress()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="phone" value="<%=p.getPhoneNumber()%>" class="form-control"></td>
                                <td style="display: none;"><input form="modifyStudent<%=i%>" type="hidden" name="password" value="<%=p.getPassword()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="date" name="birthday" value="<%=((StudentDTO) p).getDateOfBirth().toString()%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="text" name="average" value="<%=Double.toString(((StudentDTO) p).getAverage())%>" class="form-control"></td>
                                <td><input form="modifyStudent<%=i%>" type="submit" class="btn btn-warning br-round" value="Modifier"/></td>
                            <td>
                                <form method="POST" action="ManageUserController">
                                    <input type="hidden" name="action" value="delete"/>
                                    <input type="hidden" name="id" value="<%=p.getId()%>"/>
                                    <input type="submit" class="btn btn-danger br-round" value="Supprimer"/>
                                </form>
                            </td>
                        </tr>
                    <%
                            }
                        }
                    %>

                </table>
            </div>
        </div>
    </div>

</body>
</html>