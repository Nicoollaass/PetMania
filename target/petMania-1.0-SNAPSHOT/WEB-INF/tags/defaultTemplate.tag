<%-- 
    Document   : defaultTemplate
    Created on : 02/11/2015, 13:42:41
    Author     : Nicolas
--%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="paginaTitulo" fragment="true" %>
<%@attribute name="paginaHead" fragment="true" %>
<%@attribute name="paginaBottom" fragment="true" %>
<!DOCTYPE html>
<html>
  <head>
    
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <meta name="author" content="Nicolas Silva, Herick Melo, Caio Stalberg, Felipe Magalhães" />
    
    <title>
      <jsp:invoke fragment="paginaTitulo"/>
      - PetMania | PetShop
    </title>

    <!-- CSS Base -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-theme.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>"/>
    
    <!-- JS Base  -->
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-1.11.3.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/main.js"/>"></script>

    
    <jsp:invoke fragment="paginaHead"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>
    
    <c:if test="${usuarioLogado != null}">
         <t:defaultNavbar/>
    </c:if>
    
    <section id="main-content">
      <section class="wrapper">

        <jsp:doBody/>

      </section>
      
    </section>
        
    <jsp:invoke fragment="paginaBottom"/>
    
  </body>
</html>