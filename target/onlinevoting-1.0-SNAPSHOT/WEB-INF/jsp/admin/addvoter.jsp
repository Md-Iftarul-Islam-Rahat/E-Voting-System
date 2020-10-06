<%-- 
    Document   : addvoter
    Created on : Aug 23, 2020, 12:18:51 AM
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
                width: 115%;
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

            @media screen and (max-width: 500px) {
                .navbar a {
                    float: none;
                    display: block;
                }
            }
            .navbar a4{

            }
            h1{
                
                font-style: oblique;
                margin: 0px 55px 0 0;

            }
            .voterform{
                /*                margin: 0px 600px 0 350px;*/
                background-color: burlywood;

            }
            .voterbody{
                background-color: burlywood;

            }
            .voterviewform{
                background-color: burlywood;
                margin: 20px 0px 1px 0px;
                border-bottom-color: black;

            }
            button{
               
                background-color: black;
                border-color: activeborder;
                text-align: center;
                margin: 0px 0 0 140px;
            }
            .fullbody{
                background-color: burlywood;
                width: 120%;
            }
            table, th, td {
                border: 1px solid black;
                
            }
            .col-md-12{
                width: 100%;
            }
        </style>
    </head>
    <body class="logbody">
        <div class="navbar">
            <h1> Welcome Admin ${username}</h1>
            <!--                        <a class="active" href="#"><i class="fa fa-fw fa-home"></i> Home</a> -->
            <a href="/user/addvoter" style="color: darkblue; font-size: 20px;"> Add Voter</a> 
            <a href="/user/addparty" style="color: darkblue; font-size: 20px;"> Add Party</a> 
            <a href="/user/addcandidate" style="color: darkblue; font-size: 20px;"> Add Candidate</a>
<!--            <a href="/user/voteview" style="color: darkblue; font-size: 20px;">Vote View</a>-->
            <a href="/user/viewresult" style="color: darkblue; font-size: 20px;">View Result[Click After voting Completion]</a>
            <a href="/user/adminlogin" style="color: darkblue; font-size: 20px;">Logout</a>
        </div>
        <div class="fullbody">


            <div class="row">
                <div class="col-md-12">

                    <div class="col-md-4" style="width: auto">
                        <h6>${obj}</h6>
                        <div class="voterbody">
                            <h1><u>Add voter:</u> </h1>                       
                            <form class="regform" action="/voters/save" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="fullname">Full Name : </label>
                                    <input type="text" class="form-control" id="fullname" placeholder="Enter fullname" name="fullname" value="${voters.fullname}">
                                </div><br>
                                <div class="form-group">
                                    <label for="fathername">Father Name : </label>
                                    <input type="text" class="form-control" id="fathername" placeholder="Enter father name" name="fathername" value="${voters.fathername}">
                                </div><br>
                                <div class="form-group">
                                    <label for="mothername">Mother Name : </label>
                                    <input type="text" class="form-control" id="mothername" placeholder="Enter mother name" name="mothername" value="${voters.mothername}">
                                </div><br>
                                <div class="form-group">
                                    <label for="nid">NID : </label>
                                    <input type="text" class="form-control" id="nid" placeholder="Enter nid" name="nid" value="${voters.nid}">
                                </div><br>
                                <div class="form-group">
                                    <label for="dob">Date of Birth : </label>
                                    <input type="date" class="form-control" id="dob" placeholder="Enter nid" name="dob" value="${voters.dob}">
                                </div><br>
                                <div class="form-group">
                                    <label for="email">Email : </label>
                                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${voters.email}">
                                </div><br>
                                <div class="form-group">
                                    <label for="religion">Religion : </label>
                                    <input type="text" class="form-control" id="religion" placeholder="Enter religion" name="religion" value="${voters.religion}">
                                </div><br>
                                <div class="form-group">
                                    <label for="sex">Sex : </label>
                                    <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex" value="${voters.sex}">
                                </div><br>
                                <div class="form-group">
                                    <label for="blood">Blood : </label>
                                    <input type="text" class="form-control" id="blood" placeholder="Enter blood" name="blood" value="${voters.blood}">
                                </div><br>      
                                <div class="form-group">
                                    <label for="area">area : </label>
                                    <input type="text" class="form-control" id="area" placeholder="Enter area" name="area" value="${voters.area}">
                                </div><br>
                                <div class="form-group">
                                    <label for="wordno">Word No : </label>
                                    <input type="text" class="form-control" id="wordno" placeholder="Enter wordno" name="wordno" value="${voters.wordno}">
                                </div><br>
                                <div class="form-group">
                                    <label for="citycorporation">City Corporation : </label>
                                    <input type="text" class="form-control" id="citycorporation" placeholder="Enter citycorporation" name="citycorporation" value="${voters.citycorporation}">
                                </div><br>
                                <div class="form-group">
                                    <label for="voterimage">Upload Voter Photo : </label>
                                    <input class="input--style-5" type="file" name="fileUpload" size="50" />
                                </div>
                                <button type="submit" class="btn btn-primary" >save</button>
                            </form>

                        </div>
                    </div>



                    <div class="col-md-8">
                        <div class="voterviewform">
                            <h3 style="color: #000">${viewTitle}</h3>
                            <table class="table table-hover">
                                <thead>

                                    <tr> 
                                        <th>ID</th>
                                        <th>Full Name</th>
                                        <th>Father Name</th>
                                        <th>Mother Name</th>
                                        <th>NID</th>
                                        <th>Date of Birth</th>
                                        <th>Email</th>
                                        <th>Religion</th>
                                        <th>Sex</th>
                                        <th>Blood</th>  
                                        <th>Area</th>
                                        <th>Word No.</th>
                                        <th>City Corporation</th>
                                        <th>Voter Photo</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${map.voterList}" var="u">

                                        <tr>
                                            <td>${u.id}</td>
                                            <td>${u.fullname}</td>
                                            <td>${u.fathername}</td>
                                            <td>${u.mothername}</td>
                                            <td>${u.nid}</td>
                                            <td>${u.dob}</td>
                                            <td>${u.email}</td>
                                            <td>${u.religion}</td>
                                            <td>${u.sex}</td>
                                            <td>${u.blood}</td> 
                                            <td>${u.area}</td>
                                            <td>${u.wordno}</td>
                                            <td>${u.citycorporation}</td>
                                            <td><img src="/voters/imageDisplay?id=${u.id}" width="300%" height="60%"> </td>
                                            <td>
                                                <a href="/voters/edit/${u.id}" style="color: #000">Edit</a>
                                                <a href="/voters/delete/${u.id}" style="color: red">Delete</a>
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

</body>
</html>
