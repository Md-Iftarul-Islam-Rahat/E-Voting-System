<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Admin Page</title>
        <style>
            .regform{
                margin:90px 568px 23px 399px;

            }
            form h1 {
                font-size: 30px;
                color: blue;
            }
            html{
                background-color: cadetblue;
            }
            .logbody{
                background-color: cadetblue;
            }
            linktag{

            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body class="logbody">


        <form class="regform" action="/user/save" method="post">
            <h1>Admin User Create</h1><br>
            <div class="form-group">
                <label for="username">Username Name : </label>
                <input type="text" class="form-control" id="username" placeholder="Enter your usernamee" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password : </label>
                <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">
            </div>

            <br>
            <button type="submit" class="btn btn-primary">save</button>
            <a class="linktag" href="/user/adminlogin" style="color: indigo; font-size: 20px;">Admin panel</a>

        </form>

        

    </body>
</html>
