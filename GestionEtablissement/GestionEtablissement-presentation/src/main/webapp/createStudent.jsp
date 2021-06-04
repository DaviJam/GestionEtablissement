<%@ page pageEncoding="UTF-8" %>
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
                    <a class="nav-link active text-primary" href="createStudent.jsp" id="p_student">Créer un étudiant</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="manageCourses.jsp" id="p_courses">Gérer les cours</a>
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

    <div class="page current">
        <div class="row">
            <div class="col mx-auto bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
                <h1>Créer un étudiant</h1>
                <div class="row">
                    <form method="POST" action="ManageUserController" class="form-group">
                        <div class="col">
                            <input type="hidden" name="action" value="add">
                            <label for="name">Nom</label><br>
                            <input type="text" name="name" placeholder="Nom" id="name" class="form-control"><br>
                            <label for="firstname">Prénom</label><br>
                            <input type="text" name="firstname" placeholder="Prénom" id="firstname" class="form-control"><br>
                            <label for="birthday">Date de naissance</label><br>
                            <input type="date" name="birthday" id="birthday" class="form-control"><br>
                            <label for="mail">Email</label><br>
                            <input type="text" name="mail" placeholder="Email" id="mail" class="form-control"><br>
                        </div>
                        <div class="col">
                            <label for="address">Adresse</label><br>
                            <input type="text" name="address" placeholder="Adresse" id="address" class="form-control"><br>
                            <label for="phone">Téléphone</label><br>
                            <input type="text" name="phone" placeholder="Téléphone" id="phone" class="form-control"><br>
                            <label for="password">Mot de passe</label><br>
                            <input type="text" name="password" placeholder="Mot de passe" id="password" class="form-control"><br>
                    
                            <div class="row text-center px-3">
                                <input type="submit" value="Créer l'étudiant" class="btn btn-success br-round">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>