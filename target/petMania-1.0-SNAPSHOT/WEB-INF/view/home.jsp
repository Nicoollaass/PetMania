<%-- 
    Document   : home.jsp
    Created on : 02/11/2015, 15:47:55
    Author     : Nicolas
--%>

<%@page import="br.com.petmania.cadastros.model.Usuario"%>
<%-- 
    Document   : home
    Created on : 27/10/2015, 21:41:35
    Author     : nicolas.ssantos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true" %>

<t:defaultTemplate>
    
    <jsp:attribute name="paginaTitulo">
        Home
    </jsp:attribute>
        
    <jsp:body>
        <t:defaultNavSearching>
            <jsp:attribute name="contentSearching">
            </jsp:attribute>
        </t:defaultNavSearching>
        <div class="content-main col-md-10">
            <div class="conteiner-fluid col-md-10 space-top">
                <h1>Bem vindo ao sistema Sr(a) <c:out value="${usuarioLogado.getNome()}" /></h1>
            </div>
        </div>
    </jsp:body>

</t:defaultTemplate>
