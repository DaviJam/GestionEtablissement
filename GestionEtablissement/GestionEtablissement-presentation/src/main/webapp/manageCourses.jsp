<%@ page pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestionetablissement.service.PersonService" %>
<%@ page import="eu.ensup.gestionetablissement.service.CourseService" %>
<%@ page import="eu.ensup.gestionetablissement.dto.PersonDTO" %>
<%@ page import="eu.ensup.gestionetablissement.dto.StudentDTO" %>
<%@ page import="eu.ensup.gestionetablissement.dto.CourseDTO" %>
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
                    <a class="nav-link active text-primary" href="manageCourses.jsp" id="p_courses">Gérer les cours</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listStudents.jsp" id="p_list">Liste des étudiants</a>
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
        <div class="row bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">  
            <div class="col">
                <h3>Créer un cours</h3>
                <form method="POST" action="ManageCourseController">
                    <input type="hidden" name="action" value="add">
                    <label for="course">Thème du cours</label><br>
                    <input type="text" placeholder="Thème du cours" id="course" name="course" class="form-control"><br>
    
                    <label for="hour">Nombre d'heures</label><br>
                    <input type="text" placeholder="Nombre d'heure" id="hour" name="hour" class="form-control"><br>
    
                    <div class="row px-5">
                        <input type="submit" value="Créer" class="btn btn-success br-round">
                    </div>
                </form>
            </div>
            
            
            <div class="col">
                <h3>Associer un étudiant à un cours</h3>
    
                <form method="POST" action="ManageCourseController">
                    <input type="hidden" name="action" value="associate">
                    <label for="course">Choisir un étudiant</label><br>
                    <select name="id_course" class="form-control">
                        <%
                            PersonService ps = new PersonService();
                            try {
                                for(PersonDTO p : ps.getAll()){
                                    if(p instanceof StudentDTO) {
                        %>
                                        <option value="<%=p.getId()%>"><%=p.getFirstname() + " " + p.getLastname()%></option>
                        <%
                                    }
                                }
                            } catch (Exception e) {

                            }
                        %>
                    </select><br>
    
                    <label for="hour">Choisir un cours</label><br>
                    <select name="id_student" class="form-control">
                        <%
                            CourseService cs = new CourseService();
                            try {
                                for(CourseDTO c : cs.getAll()){
                        %>
                                    <option value="<%=c.getId()%>"><%=c.getCourseSubject()%></option>
                        <%
                                }
                            } catch (Exception e) {

                            }
                        %>
                    </select><br>
                    <div class="row px-5">
                        <input type="submit" value="Associer" class="btn btn-warning br-round">
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>