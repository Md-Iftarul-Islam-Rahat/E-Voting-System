<%-- 
    Document   : voterlog
    Created on : Aug 27, 2020, 2:17:22 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            .logForm{
                width: 35%;
                background: chocolate;
                height: 290px;

            }
            form{

            }
            form h1{

            }
            .user{}
            body {background-color: antiquewhite;}
            .header{

            }
            .header h1{
                text-align: center;
                color: crimson;
                font-size: 50px;
            }
            input{
                padding: 5px;
                width: 50%;
                margin-bottom: 10px;

            }
            label{
                font-size: 20px;
                padding: 25px;
            }
            button{
                margin: 20px 0 0 110px;
                padding: 5px;
                font-size: 20px;
            }
            .myForm{             margin: 10px 450px  0px 465px;
                                 background-color: darkgreen;
                                 padding: 5px;}
            .myForm h1 {text-align: center;
                        color: cyan;}
            .input1{margin-left: -4px;}
            .input2{margin: 0px}
            .type3{
                margin-left: 44px;
            }
            body a{
                font-size: 25px;
                margin: 0 0 0 1180px;
            }
            .header{
                
            }
        </style>
    </head>
    <body>
        <img src="/resources/image/election_commission.jpg" width="1350px" height="250px"/>
        <div class="header">
            <a href="/user/adminlogin">Admin Panel</a>
            <h1>Online Voting System</h1>
        </div>

        <div class="votersection">

            <form action="/user/voterloginaction" class="myForm" method="post">
                <h1>VOTER LOGIN</h1>

                <div class="form-group">
                    <label for="nid">NID : </label>
                    <input type="text" class="form-control" id="nid" placeholder="Enter your nid" name="nid" required/>
                </div>

                <div class="form-group">
                    <label for="dob">DOB : </label>
                    <input type="date" class="form-control" id="dob" placeholder="Enter dob" name="dob" required/>
                </div>
                <button type="submit" class="btn btn-default">Enter</button>

            </form>

        </div>
    </body>
</html>
