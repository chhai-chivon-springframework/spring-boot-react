<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/js.js"></script>
</head>
<body>
<div class="container">
    <div id="login-box">
        <div class="logo">
            <img src="http://lorempixel.com/output/people-q-c-100-100-1.jpg" class="img img-responsive img-circle center-block"/>
            <h1 class="logo-caption"><span class="tweak">L</span>ogin</h1>
        </div>
        <div class="controls">
            <input type="text" name="username" placeholder="Username" class="form-control" />
            <input type="text" name="username" placeholder="Password" class="form-control" />
            <button type="button" class="btn btn-default btn-block btn-custom">Login</button>
        </div>
    </div>
</div>
<div id="particles-js"></div>
<!--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/particles.js/2.0.0/particles.min.js"></script>-->

<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
    /*$(function() {
        $("#frmLogin").submit(function(e){
            e.preventDefault();
            $.ajax({
                url: "${pageContext.request.contextPath}/login",
                type: "POST",
                data: $("#frmLogin").serialize(),
   	            beforeSend: function (xhr) {
   	                xhr.setRequestHeader("X-Ajax-call", "true");
   	            },
                success: function(data) {
                    if(data == "User account is locked"){
                        alert(data);
                    }else if(data == "User is disabled"){
                        alert(data);
                    }else if(data == "Bad credentials"){
                        alert(data);
                    }else{
                        alert("Logined success." + data);
                        location.href = "${pageContext.request.contextPath}/"+data;

                    }

                },
                error: function(data){
                    console.log(data);
                }
            });

        });
        $.ajax({
            url: "http://localhost:8080/api/user",
            type: 'GET',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader("Authorization" , "Basic a3NsOmtzbGFwaQ==");
            },
            success: function(data) {
                console.log(data);

            },
            error:function(data,status,er) {
                console.log("error: "+data+" status: "+status+" er:"+er);
            }
        });
    });*/
</script>
</body>
</html>