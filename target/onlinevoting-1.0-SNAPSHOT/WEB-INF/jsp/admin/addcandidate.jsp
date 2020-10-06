<%-- 
    Document   : addcandidate
    Created on : Aug 26, 2020, 12:54:26 PM
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
                width: 170%;
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
            h1{
                
                font-style: oblique;

            }
            .navbar a4{

            }
            .candidatebody{
                background-color: burlywood;
                
            }
            .candidateform{
                background-color: burlywood;
                
            }
            .candidateviewform{
                background-color: burlywood;
                width: 150%;
            }
            .fullbody{
                background-color: burlywood;
                width:150%;
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

        <div class="fullbody">
            <div class="row">
                <div class="col-md-12">

                    <div class="col-md-4" style="width: auto">
                        <h6>${obj}</h6>
                        <div class="candidatebody">
                            <h1><u>Add Candidate:</u> </h1>
                            <div class="candidateform">
                                <h3 style="color: deeppink">${createTitle}</h3>

                                <form class="regform"action="/candidates/save" method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="fullname">Full Name : </label>
                                        <input type="text" class="form-control" id="fullname" placeholder="Enter fullname" name="fullname" value="${candidates.fullname}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="fathername">Father Name : </label>
                                        <input type="text" class="form-control" id="fathername" placeholder="Enter father name" name="fathername" value="${candidates.fathername}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="mothername">Mother Name : </label>
                                        <input type="text" class="form-control" id="mothername" placeholder="Enter mother name" name="mothername" value="${candidates.mothername}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="nid">NID : </label>
                                        <input type="text" class="form-control" id="nid" placeholder="Enter nid" name="nid" value="${candidates.nid}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="dob">Date of Birth : </label>
                                        <input type="date" class="form-control" id="dob" placeholder="Enter nid" name="dob" value="${candidates.dob}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="email">Email : </label>
                                        <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${candidates.email}">
                                    </div><br>

                                    <div class="form-group">
                                        <label for="religion">Religion : </label>
                                        <input type="text" class="form-control" id="religion" placeholder="Enter religion" name="religion" value="${candidates.religion}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="blood">Blood : </label>
                                        <input type="text" class="form-control" id="blood" placeholder="Enter blood" name="blood" value="${candidates.blood}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="sex">Sex : </label>
                                        <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex" value="${candidates.sex}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="partytype">Party Type : </label>
                                        <input type="text" class="form-control" id="partyname" placeholder="Enter partytype" name="partytype" value="${candidates.partytype}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="candidateimage">Upload Candidate Photo : </label>
                                        <input class="input--style-5" type="file" name="fileUpload1" size="50" />
                                    </div><br>
                                    <div class="form-group">
                                        <label for="logoimage">Upload Candidate's LOGO : </label>
                                        <input class="input--style-5" type="file" name="fileUpload2" size="50" />
                                     </div><br>
                                    <div class="form-group">
                                        <label for="area">Area : </label>
                                        <input type="text" class="form-control" id="area" placeholder="Enter area group" name="area" value="${candidates.area}">
                                    </div><br>      
                                    <div class="form-group">
                                        <label for="wordno">Word No : </label>
                                        <input type="text" class="form-control" id="wordno" placeholder="Enter wordno" name="wordno" value="${candidates.wordno}">
                                    </div><br>
                                    <div class="form-group">
                                        <label for="citycorporation">City Corporation : </label>
                                        <input type="text" class="form-control" id="citycorporation" placeholder="Enter citycorporation" name="citycorporation" value="${candidates.citycorporation}">
                                    </div><br>


                                    <button type="submit" class="btn btn-primary" >save</button>                                     

                                </form>

                            </div>
                        </div>
                    </div>
                    <span></span><br>
                    <div class="viewbody">

                    <div class="col-md-8">
                        <div class="candidateviewform">
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
                                        <th>Blood</th>
                                        <th>Sex</th>
                                        <th>Party Type</th>
                                        <th>Candidate Photo</th>
                                        <th>Candidate's LOGO</th>
                                        <th>Area</th>
                                        <th>Word No.</th>
                                        <th>City Corporation</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${map.candidatesList}" var="c">
                                    <!--//id, fullname, fathername, mothername, nid, dob, email, religion, blood, sex, partyname, logoname, area, wordno, citycorporation-->
                                    <tr>
                                        <td>${c.id}</td>
                                        <td>${c.fullname}</td>
                                        <td>${c.fathername}</td>
                                        <td>${c.mothername}</td>
                                        <td>${c.nid}</td>
                                        <td>${c.dob}</td>
                                        <td>${c.email}</td>
                                        <td>${c.religion}</td>
                                        <td>${c.blood}</td> 
                                        <td>${c.sex}</td>
                                        <td>${c.partytype}</td>
                                        <td><img src="/candidates/imageDisplayCandidate?id=${c.id}"></td>
                                        <td><img src="/candidates/imageDisplayLogo?id=${c.id}"></td>
                                        <td>${c.area}</td>
                                        <td>${c.wordno}</td>
                                        <td>${c.citycorporation}</td>

                                        <td>
                                            <a href="/candidates/edit/${c.id}" style="color: #000">Edit</a>
                                            <a href="/candidates/delete/${c.id}" style="color: red">Delete</a>
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
        </div>

        <!--        <div class="addcandidatebody">
                    <h1>Add Candidate Here</h1>
        
                    <div class="addcandidateform" style="width: auto">
                        <h6>${obj}</h6>
                        <h3 style="color: deeppink">${createTitle}</h3>
                        <form action="/candidates/addpcandidatesave" method="post">
        
        
                            <div class="form-group">
                                <label for="fullname">Full Name : </label>
        
                                <input type="text" class="form-control" id="fullname" placeholder="Enter fullname" name="fullname">
                            </div>
                            <div class="form-group">
                                <label for="fathername">Father Name : </label>
                                <input type="text" class="form-control" id="fathername" placeholder="Enter fathername" name="fathername">
                            </div>
                            <div class="form-group">
                                <label for="mothername">Mother Name : </label>
                                <input type="text" class="form-control" id="mothername" placeholder="Enter mothername" name="mothername">
                            </div>
        //id, fullname, fathername, mothername, nid, dob, email, religion, blood, sex, partyname, logoname, area, wordno, citycorporation
                            <div class="form-group">
                                <label for="nid">NID : </label>
                                <input type="text" class="form-control" id="nid" placeholder="Enter nid" name="nid">
                            </div>
                            <div class="form-group">
                                <label for="dob">Date of Birth : </label>
                                <input type="date" class="form-control" id="dob" placeholder="Enter dob" name="dob">
                            </div>
                            
                            <div class="form-group">
                                <label for="email">Email : </label>
                                <input type="text" class="form-control" id="nid" placeholder="Enter email" name="nid">
                            </div>
                            <div class="form-group">
                                <label for="sex">Sex : </label>
                                <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex">
                            </div>
                            <div class="form-group">
                                <label for="partyname">Party Name : </label>
                                <input type="text" class="form-control" id="partyname" placeholder="Enter partyname" name="partyname">
                            </div>
                            <div class="form-group">
                                <label for="logoname">LOGO Name : </label>
                                <input type="text" class="form-control" id="logoname" placeholder="Enter logoname" name="logoname">
                            </div>
                            <div class="form-group">
                                <label for="area">Area : </label>
                                <input type="text" class="form-control" id="area" placeholder="Enter area" name="area">
                            </div>
        
                            //id, fullname, fathername, mothername, nid, dob, email, religion, blood, sex, partyname, logoname, area, wordno, citycorporation
                            <div class="form-group">
                                <label for="wordno">Word No : </label>
                                <input type="text" class="form-control" id="wordno" placeholder="Enter wordno" name="wordno">
                            </div>
        
                            <div class="form-group">
                                <label for="citycorporation">City Corporation : </label>
                                <input type="text" class="form-control" id="citycorporation" placeholder="Enter citycorporation" name="citycorporation">
                            </div>
        
        
                            <br>
                            <button type="submit" class="btn btn-primary">save</button>
                            <a href="/user/voterlog">Admin Panel</a>
                                                            <button type="submit" class="btn btn-primary">Update</button>
                                                            <button type="submit" class="btn btn-primary">Delete</button>
        
                                                            <a href="/user/login" style="color: forestgreen">Login User</a>
        
                        </form>
        
                    </div>
                </div>-->
    </body>
</html>
