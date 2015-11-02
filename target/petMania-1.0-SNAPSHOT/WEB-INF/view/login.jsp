<%-- 
    Document   : home
    Created on : 27/10/2015, 21:41:35
    Author     : nicolas.ssantos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-theme.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/login.css"/>"/>
    </head>
    <body>
        <section class="container-fluid">
            <div class="content-login">
                <form class="form-horizontal" action="<c:url value="/sistema?acao=Login"/>" method="POST">
                    <h1 class="title"><img src="assets/img/icon/cadeado.png" alt="">Login</h1>
                    <div class="form-group">
                        <div>
                            <input type="text" name="loginUsuario" class="form-control" id="inputEmail3" placeholder="Usuário">
                        </div>
                    </div>
                    <div class="form-group">					
                        <div>
                            <input type="password" name="loginSenha" class="form-control" id="inputPassword3" placeholder="Senha">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-default logar ">Sign in</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <label>
                                <a href="" class="esqueci">Esqueci a senha</a>
                            </label>
                            <p class="erroMsg">
                                <c:out value="${erroMsg}" />
                            </p>
                        </div>
                    </div>
                </form>
            </div>
            <img src="assets/img/icon/dog.png" alt="" class="icon-animal">
        </section>
    </body>
</html>
