<%-- 
    Document   : listar-clientes
    Created on : 20/11/2015, 18:05:44
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true" %>
 



<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Listagem de produtos
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="assets/css/produtos.css"/>"/>
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
                    <button type="button" class="btn btn-success"><a href="<c:url value="/sistema?param=funcionario&acao=CadastroFuncionario"/>">Novo Funcionario</a></button>
                </div>
            </jsp:attribute>
        </t:defaultNavSearching>
        <!-- tabela -->
        <div class="content-main tabela-main col-md-10">
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
                        <th>Cargo</th>
                        <th>Data de nascimento</th>
                        <th>Email</th>
                        <th>CPF</th>
                        <th>Localidade</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${funcionario}" var="funcionario">
                        <tr>
                            <td><c:out value="${funcionario.id_funcionario}"/></td>
                            <td><c:out value="${funcionario.nome}"/></td>
                            <td><c:out value="${funcionario.id_tipo_funcionario}"/></td>
                            <td><c:out value="${funcionario.data_nascimento}"/></td>
                            <td><c:out value="${funcionario.email}"/></td>
                            <td><c:out value="${funcionario.cpf}"/></td>
                            <td><c:out value="${funcionario.id_locacao}"/></td>
                           
                            <td>
                                <button type="button" class="btn btn-info"><a href="">+Info</a></button>
                                <button type="button" class="btn btn btn-primary"><a href="<c:url value="/sistema?param=produto&acao=EditarFuncionario&id=${produto.id_produto}"/>">Editar</a></button>
                                <button type="button" class="btn btn-danger"><a href="<c:url value="/sistema?param=funcionario&acao=ExcluirFuncionario&id=${produto.id_produto}"/>">Excluir</a></button>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
        <!-- /tabela -->
    </jsp:body>

</t:defaultTemplate>
