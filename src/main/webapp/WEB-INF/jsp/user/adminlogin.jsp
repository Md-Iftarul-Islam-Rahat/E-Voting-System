<%-- 
    Document   : adminpanel
    Created on : Aug 24, 2020, 11:05:57 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin panel Page</title>
        <style>
            .logForm{
                width: 35%;
                background: chocolate;
                height: 290px;
            }
            button{
                margin: 0 0 10px 120px;
                padding: 5px;
            }


            .header h1{
                margin: 0 620px 10px 415px;
                color: crimson;
                font-size: 40px;
            }
            input{
                padding: 6px;
                width: 50%;
                margin-bottom: 15px;

            }
            label{
                font-size: 22px;
                margin: 0 auto;
            }

            .myForm{        font-size: 50px;
                            margin: 15px 580px 120px 375px;
                            background-color: brown;
                            padding: 10px;}
            .myForm h1 {text-align: center;
                        color: cyan;}
            .input1{margin-left: -4px;}
            .input2{margin: 0px}
            .type3{
                margin-left: 44px;
            }
            a{
                font-size: 20px;
                padding: 33px; 
            }
            .header{
                
            }


        </style>
    </head>
    <body>
        <img src="/resources/image/election_commission.jpg" width="200px" height="150px"/>
        <img src="/resources/image/admin-logo.gif" width="1100px" height="150px"/>

        <div class="header">
            <a class="linktag" href="/user/voterlog" style="color: indigo; font-size: 20px;">Voter Section</a>
            <h1> ADMIN PANEL</h1>


            <form action="/user/adminloginaction" class="myForm" method="post" >


                <div class="form-group user" >
                    <label for="username">Username : </label>
                    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required/>

                </div>

                <div class="form-group">
                    <label for="password">Password : </label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required/>
                </div>



                <button type="submit" class="btn btn-default"> Login</button>
                <!--            <a href="/user/create">Register Here</a>-->
            </form>
        </div>
    </body>
</html>
