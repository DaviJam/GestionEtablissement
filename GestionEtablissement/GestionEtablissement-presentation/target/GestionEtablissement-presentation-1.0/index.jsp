<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
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

    <div class="row bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
        <div class="col">
            <img src="img/logo.png" width="200" class="mb-4">
            <h1 class="mb-4 w-100 text-center">Connectez-vous</h1>
            <form method="POST" action="AuthController" class="form-group">
                <label for="login">Nom d'utilisateur</label><br>
                <input type="text" name="login" id="login" class="form-control" placeholder="Login">

                <label for="pwd">Mot de passe</label><br>
                <input type="text" name="pwd" id="pwd" class="form-control" placeholder="Mot de passe">

                <%
                    if (request.getAttribute("error") != null) {
                %>
                <p style="color: red;"><%=request.getAttribute("error")%></p>
                <%
                    }
                %>
                <div class="row px-5 mt-3">
                    <input type="submit" value="Se connecter" class="btn btn-primary br-round">
                </div>
            </form>
        </div>
        <div class="col">
            <img src="img/login.svg" class="img-fluid">
        </div>
    </div>
</body>
</html>