<%-- 
    Document   : viewresult
    Created on : Aug 28, 2020, 11:03:03 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}

            .navbar {
                width: 100%;
                background-color: burlywood;
                overflow: auto;

            }

            .navbar a {
                float: left;
                padding: 25px;
                text-decoration: revert;
            }

            .navbar a:hover {
                background-color: #000;
            }

            .active {
                background-color: #4CAF50;
            }

            @media screen and (max-width: 200px) {
                .navbar a {

                    float: none;
                    display: block;
                }

            }
            h1{

                font-style: oblique;
                text-align: center;

            }
            .navbar a4{

            }

            button{
                font-size: 20px;
                background-color: black;
                border-color: activeborder;
                text-align: center;
                margin: 0px 0 0 140px;}

            .col-md-12{
                width:100%;
            }
            table, th, td {
                border: 1px solid black;

            }
            .resultview{
                background-color: burlywood;

            }

        </style> 
    </head>
    <body>
        <div class="navbar">
            <h1> Welcome Admin ${username}</h1>


            <a href="/user/addvoter" style="color: darkblue; font-size: 20px;"> Add Voter</a> 
            <a href="/user/addparty" style="color: darkblue; font-size: 20px;"> Add Party</a> 
            <a href="/user/addcandidate" style="color: darkblue; font-size: 20px;"> Add Candidate</a>
            <!--            <a href="/user/voteview" style="color: darkblue; font-size: 20px;">Vote View</a>-->
            <a href="/user/viewresult" style="color: darkblue; font-size: 20px;">View Result[Click After voting Completion]</a>
            <a href="/user/adminlogin" style="color: darkblue; font-size: 20px;">Logout</a>
        </div>
        <div class="resultview">
            <h1>Final Vote Result</h1>
            <div class="row">
                <div class="col-md-12">

                    <table class="table table-hover">
                        <thead>

                            <tr>
                                <th>Candidate Serial no.</th> 
                                <th>Candidate Name</th> 
                                <th>Party Name</th>
                                <th>Total Achieve Vote</th>           
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Eng. Israque Hossain</td>
                                <td>Bangladesh National Party</td>
                                <td>${map.resultByNameIsraque}</td>                            
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Sheikh Fazle Noor Tapos</td>
                                <td>Awami League</td>
                                <td>${map.resultByNameTapos}</td>                            
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Hazi Saifuddin milton</td>
                                <td>National Party</td>
                                <td>${map.resultByNameMilton}</td>                            
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Mufti Rezaul Karim</td>
                                <td>Islami Andolon BAngladesh</td>
                                <td>${map.resultByNameRezaul}</td>                            
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
