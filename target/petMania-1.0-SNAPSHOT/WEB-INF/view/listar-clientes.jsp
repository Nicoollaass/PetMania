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
    </jsp:attribute>

    <jsp:body>
        <t:defaultNavSearching>
            <jsp:attribute name="contentSearching">
                <input type="text" class="form-control" placeholder="Nome...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </span>
            </jsp:attribute>

            <jsp:attribute name="novoregistrobtn">
                <div class="novo-registro">
                    <button type="button" class="btn btn-success"><a href="<c:url value="/sistema?param=clientes&acao=CadastrarCliente"/>">Novo Cliente</a></button>
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
                        <th>Idade</th>
                        <th>E-mail</th>
                        <th>Data inclusão</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientes}" var="cliente">
                        <tr>
                            <td><c:out value="${cliente.id_cliente}"/></td>
                            <td><c:out value="${cliente.nome}"/></td>
                            <td><c:out value="${cliente.idade}"/></td>
                            <td><c:out value="${cliente.email}"/></td>
                            <td><c:out value="${cliente.data_inclusao}"/></td>
                            <td>
                                <button type="button" class="btn btn-info"><a href="">+Info</a></button>
                                <button type="button" class="btn btn btn-primary"><a href="<c:url value="/sistema?param=clientes&acao=EditarCliente&id=${cliente.id_cliente}"/>">Editar</a></button>
                                <button type="button" class="btn btn-danger"><a href="<c:url value="/sistema?param=clientes&acao=ExcluirCliente&id=${cliente.id_cliente}"/>">Exluir</a></button>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
        <!-- /tabela -->
    </jsp:body>

</t:defaultTemplate>

