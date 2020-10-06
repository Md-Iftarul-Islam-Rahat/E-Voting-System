<%-- 
    Document   : addparty
    Created on : Aug 19, 2020, 11:23:02 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin panel Page</title>
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

            @media screen and (max-width: 600px) {
                .navbar a {
                    float: none;
                    display: block;
                }


            }

            h1{
                
                font-style: oblique;

            }
            
            button{
               
                background-color: black;
                border-color: activeborder;
                text-align: center;
                margin: 0px 0 0 140px;}
            .partybody{
                background-color: burlywood;
                margin: 20px 145px 0px 0px;
            }
            .partyform{
                background-color: burlywood;
            }
            .partyviewbody{
                background-color: burlywood;
            }
            .fullbody{
                background-color: burlywood;
            }
            table, th, td {
                border: 1px solid black;
               
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


        <!--                <div>
                            
                        </div>-->

        <div class="fullbody">
            <div class="row">
                <div class="col-md-12">

                    <div class="col-md-6" style="width: auto">
<!--                    <h6>${obj}</h6>
            <h3 style="color: #000">${createTitle}</h3>-->
                        <div class="partybody">
                            <h1><u>Add Party List:</u></h1>
                            <div clAdd Party List:ass="partyform">
                                <form action="/parties/save" method="post" enctype="multipart/form-data">

                                    <div class="form-group">
                                        <label for="partycode">Party Code : </label>

                                        <input type="text" class="form-control" id="partycode" placeholder="Enter partycode" name="partycode" value="${parties.partycode}">
                                    </div>
                                    <div class="form-group">
                                        <label for="partyname">Party Name : </label>
                                        <input type="text" class="form-control" id="partyname" placeholder="Enter partyname" name="partyname" value="${parties.partyname}">
                                    </div>
                                    <div class="form-group">
                                        <label for="logoname">Logo Name : </label>
                                        <input type="text" class="form-control" id="logoname" placeholder="Enter logoname" name="logoname" value="${parties.logoname}">
                                    </div>
                                    <div class="form-group">
                                        <label for="logo">LOGO : </label>
                                        <input class="input--style-5" type="file" name="fileUpload" size="50" />
                                    </div>
                                    <br>
                                    <button type="submit" class="btn btn-primary">save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="partyviewbody">
                            <h3 style="color: seagreen">${viewTitle}</h3>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Party Code</th>
                                        <th>Party Name</th>
                                        <th>Logo Name</th>
                                        <th>LOGO</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${map.partiesList}" var="p">
                                        <tr>
                                            <td>${p.id}</td>
                                            <td>${p.partycode}</td>
                                            <td>${p.partyname}</td>
                                            <td>${p.logoname}</td>
                                            <td> <img src="/parties/imageDisplay?id=${p.id}" width="60%" height="50%"> </td>
                                            <td>
                                                <a href="/parties/edit/${p.id}" style="color: #000">Edit</a><br>
                                                <a href="/parties/delete/${p.id}" style="color: red">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>



                </div>
            </div>

        </div>


    </body>
</html>
