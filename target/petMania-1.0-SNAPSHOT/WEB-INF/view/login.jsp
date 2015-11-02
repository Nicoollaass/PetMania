<%-- 
    Document   : home
    Created on : 27/10/2015, 21:41:35
    Author     : nicolas.ssantos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Login
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/login.css"/>"/>
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">

    </jsp:attribute>

    <jsp:body>
        <section class="container-fluid">
            <div class="content-login">
                <form class="form-horizontal" action="<c:url value="/sistema?acao=Login"/>" method="POST">
                    <h1 class="title"><img src="<c:url value="assets/img/icon/cadeado.png"/>" alt="">Login</h1>
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
            <img src="<c:url value="/assets/img/icon/dog.png"/>" alt="" class="icon-animal">
        </section>
    </jsp:body>

</t:defaultTemplate>
