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
                <div class="form-group">
                    <select class="form-control" id="sel1">
                        <option>Dono</option>
                        <option>Nicolas</option>
                        <option>Luana</option>
                        <option>Herick</option>
                    </select>
                </div>
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Nome...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        </button>
                    </span>
                </div>
                <ul class="style-menu">
                    <li class="category">
                        Raça
                        <span class="glyphicon glyphicon-chevron-right icon-arrow" aria-hidden="true"></span>
                        <ul class="sub-category">
                            <li><input type="checkbox" name="" value="">São bernardo</li>
                            <li><input type="checkbox" name="" value="">Poodle</li>
                            <li><input type="checkbox" name="" value="">Bulldog</li>
                        </ul>
                    </li>
                </ul>
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
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${animais}" var="cliente">
                        <tr>
                            <td>animais.nome</td>  
                            <td>animais.id_raca</td>
                            <td>animais.cor</td>
                            <td>animais.idade</td>
                            <td>animais.id_cliente</td>
                            <td>
                                <button type="button" class="btn btn-info"><a href="">+Info</a></button>
                                <button type="button" class="btn btn btn-primary"><a href="<c:url value="/sistema?acao=EditarAnimal&id=${animais.id_cliente}"/>">Editar</a></button>
                                <button type="button" class="btn btn-danger"><a href="<c:url value="/sistema?acao=ExcluirAnimal&id=${animais.id_cliente}"/>">Exluir</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /tabela -->
    </jsp:body>

</t:defaultTemplate>

