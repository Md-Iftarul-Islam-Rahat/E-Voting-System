<%-- 
    Document   : goforvote
    Created on : Aug 30, 2020, 3:44:42 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>voter Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <style>
            h1{
                margin: -22px 0 0 430px;
                color: blue;
            }
            p1{
                margin: 25px 0 0 472px;
                color: green;
                font-size: 20px;
            }
            p2{
                margin: 25px 0 0 472px;
                color: green;
                font-size: 20px;
            }
            a{
                font-style: italic;
                margin: 0 0 0 1200px;
            }
            body{
                background-color: burlywood;
            }
            table, th, td {
                border: 1px solid black;
            }
            body button{
                text-align: center;
                margin: 0px 0px 0px 35px;
                padding: 10px;
            }
            .header{
                background-color: chocolate;
                padding: 20px;
            }
            .footer{
                background-color: chocolate;
                padding: 20px;
            }
            .mayor{
                color: crimson;
                text-align: center;
            }
            .councillor{
                color: crimson;
                text-align: center;
            }
            body a{
                font-size: 20px;
                padding: 33px; 
            }
            .otpconcept{
                text-align: center;
                margin: 200px 0px 0px 0px;
            }
        </style>
    </head>
    <body>

        <div id="otpDiv" class="otpconcept">
            <h4>If You get a Code to Your Phone Number, Enter Your Code Number Here:</h4>
            <input type="text" />
            <br>
            <input type="button" id="btnOtp" value="Submit OTP"/>
        </div>

        <div class="fullbody" class="hidden" id="instructionDiv">
            <div class="headersec">
                <img src="/resources/image/voting_instruction.jpg" class="image" width="200px" height="200px"/>
                <h1>WELCOME ${voters.fullname}</h1>
            </div>


            <div class="voteinstructions">
                <p><strong><h2><u>To Submit a vote, you should follow some rules that are given below:</u></h2></strong></p>
                01. You only submit one vote for a section. That means, You are able to submit one vote for Mayor and another vote from Councillor section.<br>
                02. You get to cast two votes in one ballot paper. <br>
                03. You can give a vote only one person between candidates or participants.<br>
                04. If you give a vote to an individual, you won't be able to another candidate.<br>
                05. You can vote for a candidate from a different party.<br>
                06. If you give a vote once, you won't be able to another time(after logging out).<br>
                <div class="anchortag">   
                    <a href="#" id="instructionID"><h3>Click Here to Submit your vote</h3></a>
                </div>
            </div>
        </div>
        <div id="voterDiv">
            <div class="header">
                <h1>Please Submit your vote</h1>
            </div>
            <div class="mayor">
                <p><strong><u>Mayor Section</u></strong></p>
            </div>
            <div class="voteform">



                <table class="table table-hover" width="100%">
                    <thead>
                        <tr> 
                            <th>Sl. no.</th>
                            <th>Candidate Name</th>                       
                            <th>Candidate Photo</th>
                            <th>Candidate's LOGO</th>
                            <th>Submit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${candidates}" var="u">
                        <form action="/result/submit" method="post">
                            <input type="hidden" name="voter_name" value="${voters.fullname}"/>
                            <input type="hidden" name="voter_nid" value="${voters.nid}"/>
                            <input type="hidden" name="voter_email" value="${voters.email}"/>
                            <input type="hidden" name="voter_religion" value="${voters.religion}"/>
                            <input type="hidden" name="voter_sex" value="${voters.sex}"/>
                            <input type="hidden" name="voter_blood" value="${voters.blood}"/>
                            <input type="hidden" name="voter_area" value="${voters.area}"/>
                            <input type="hidden" name="voter_wordno" value="${voters.wordno}"/>
                            <input type="hidden" name="voter_citycorporation" value="${voters.citycorporation}"/>


                            <input type="hidden" name="candidate_fullname" value="${u.fullname}"/>
                            <input type="hidden" name="candidate_partytype" value="${u.partytype}"/>

                            <tr>                          
                                <td>${u.id}</td>
                                <td>${u.fullname}</td>                 
                                <td><img src="/candidates/imageDisplayCandidate?id=${u.id}"> </td>            
                                <td><img src="/candidates/imageDisplayLogo?id=${u.id}"> </td>
                                <td><button type="submit" class="btn btn-primary" >Submit</button></td>
                            </tr>
                        </form>

                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <p> Thank you for submit your vote.</p>
            <footer>
                <div class="footer">
                    <p><strong>All Rights Deserves : electioncommission.com.bd</strong> </p>
                </div>
            </footer>
        </div>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $("#voterDiv").hide();
            $("#instructionDiv").hide();
            $("#btnOtp").click(function () {

                $("#instructionDiv").show();
                $("#otpDiv").hide();
            })


            $("#instructionID").click(function () {
                $("#instructionDiv").hide();
                $("#voterDiv").show();
            })
        </script>

    </body>
</html>
