<%-- 
    Document   : listar-clientes
    Created on : 03/11/2015, 20:33:21
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true" %>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Listagem de clientes
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="assets/css/cliente.css"/>"/>
        <script src="<c:url value="/assets/js/filter-animal.js"/>" type="text/javascript" charset="utf-8" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:defaultNavSearching>
            <jsp:attribute name="contentSearching">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Nome...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        </button>
                    </span>
                </div>
                <div class="form-group">
                    <select class="form-control" id="sel1">
                        <c:forEach items="${donos}" var="donos">
                            <option value="<c:out value="${donos.id_cliente}"/>">
                                <c:out value="${donos.nome}"/>
                            </option> 
                        </c:forEach>
                    </select>
                </div>
                <form action="action" id="filter-dinamic">
                    <ul class="style-menu">
                         <li class="category">
                            Tipo animal
                            <span class="glyphicon glyphicon-chevron-right icon-arrow" aria-hidden="true"></span>
                            <ul class="sub-category">
                                <c:forEach items="${tipos}" var="tipos">
                                    <li><input class="check-filter" type="checkbox" name="tipos" value="<c:out value="${tipos.id}"/>">
                                        <c:out value="${tipos.descricao}"/>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="category">
                            Raça
                            <span class="glyphicon glyphicon-chevron-right icon-arrow" aria-hidden="true"></span>
                            <ul class="sub-category">
                                <!--
                                    <li><input class="check-filter" type="checkbox" name="racas" value="">
                                    </li>
                                -->
                            </ul>
                        </li>
                       
                    </ul>
                </form>

            </jsp:attribute>

            <jsp:attribute name="novoregistrobtn">
                <div class="novo-registro">
                    <button type="button" class="btn btn-success"><a href="<c:url value="/sistema?acao=CadastrarAnimal"/>">Novo Animal</a></button>
                </div>
            </jsp:attribute>
        </t:defaultNavSearching>
        <!-- tabela -->
        <div class="tabela-main col-md-10">
            <c:if test="${erroMsg != null}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${erroMsg}"/>
                </div> 
            </c:if>
            <c:if test="${sucessMsg != null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sucessMsg}"/>
                </div> 
            </c:if>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Raça</th>
                        <th>Cor</th>
                        <th>Idade</th>
                        <th>Dono</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody class="line-filter">
                    
                </tbody>
            </table>
        </div>
        <!-- /tabela -->
    </jsp:body>

</t:defaultTemplate>

