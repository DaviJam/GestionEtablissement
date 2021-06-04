<%@ page pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestionetablissement.service.PersonService" %>
<%@ page import="eu.ensup.gestionetablissement.dto.PersonDTO" %>
<%@ page import="eu.ensup.gestionetablissement.dto.StudentDTO" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.1.1/chart.min.js" integrity="sha512-BqNYFBAzGfZDnIWSAEGZSD/QFKeVxms2dIBPfw11gZubWwKUjEgmFUtUls8vZ6xTRZN/jaXGHD/ZaxD9+fDo0A==" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Etudiant - Bootstrap</title>

    <style>
        html, body, input, select{font-family: 'Montserrat', sans-serif;}
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
                    <a class="nav-link" href="listStudents.jsp" id="p_list">Liste des étudiants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-primary" href="statistiques.jsp" id="p_list">Statistiques</a>
                </li>
            </ul>
            </div>
        </div>
    </nav>

    <div class="page">
        <div class="row bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">  
            <div class="col-6">
                <%
                    int badStudent = 0;
                    int averageStudent = 0;
                    int goodStudent = 0;
                    int excellentStudent = 0;
                    //Add item in combobox student
                    PersonService ps = new PersonService();
                    try {
                        for(PersonDTO p : ps.getAll()){
                            if(p instanceof StudentDTO) {
                                if(((StudentDTO) p).getAverage() < 8){
                                    badStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 8 && ((StudentDTO) p).getAverage() < 12){
                                    averageStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 12 && ((StudentDTO) p).getAverage() < 17){
                                    goodStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 17){
                                    excellentStudent++;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }

                    int total = badStudent + averageStudent + goodStudent + excellentStudent;

                    badStudent = badStudent * 100 / total;
                    averageStudent = averageStudent * 100 / total;
                    goodStudent = goodStudent * 100 / total;
                    excellentStudent = excellentStudent * 100 / total;
                %>
                <canvas id="pieChart" style="width: 50%;"></canvas>
                <script>
                var ctx = document.getElementById('pieChart');
                var myChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                      labels: [
                        'Insuffisant (%)',
                        'Bon (%)',
                        'Très bon (%)',
                        'Excellent (%)'
                      ],
                      datasets: [{
                        label: 'Pourcentage du niveau de la moyenne de tous les éléves',
                        data: [<%= badStudent%>, <%= averageStudent%>, <%= goodStudent%>, <%= excellentStudent%>],
                        backgroundColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 205, 86)',
                          'rgb(115, 219, 136)',
                          'rgb(56, 145, 74)'
                        ],
                        hoverOffset: 4
                      }]
                    }
                });
                </script>
            </div>
            <div class="col-6">
                <%
                    badStudent = 0;
                    averageStudent = 0;
                    goodStudent = 0;
                    excellentStudent = 0;
                    //Add item in combobox student
                    try {
                        for(PersonDTO p : ps.getAll()){
                            if(p instanceof StudentDTO) {
                                if(((StudentDTO) p).getAverage() < 8){
                                    badStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 8 && ((StudentDTO) p).getAverage() < 12){
                                    averageStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 12 && ((StudentDTO) p).getAverage() < 17){
                                    goodStudent++;
                                }else if(((StudentDTO) p).getAverage() >= 17){
                                    excellentStudent++;
                                }
                            }
                        }
                    } catch (Exception e){

                    }
                %>
                <canvas id="barChart" height="300"></canvas>
                <script>
                var ctx = document.getElementById('barChart');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                      labels: ["Insuffisant", "Bon", "Très bon", "Excellent"],
                      datasets: [{
                        label: 'Nombre d\'élèves par niveau de moyenne',
                        data: [<%= badStudent%>, <%= averageStudent%>, <%= goodStudent%>, <%= excellentStudent%>],
                        backgroundColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 205, 86)',
                          'rgb(115, 219, 136)',
                          'rgb(56, 145, 74)'
                        ],
                        borderColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 205, 86)',
                          'rgb(115, 219, 136)',
                          'rgb(56, 145, 74)'
                        ],
                        borderWidth: 1
                      }]
                    }
                });
                </script>
            </div>
        </div>
    </div>

</body>
</html>