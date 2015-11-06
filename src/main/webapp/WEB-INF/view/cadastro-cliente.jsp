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
        <c:out value="${titulo}"/>
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
        </t:defaultNavSearching>
            <div class="content-main col-md-10">
                
                <c:if test="${erroMsg != null}">
                    <div class="alert alert-danger" role="alert">
                        <c:out value="${erroMsg}"/>
                    </div> 
                </c:if>
                
                <div class="conteiner-fluid">
                    <form action="<c:url value="${action}"/>" method="POST" accept-charset="utf-8">
                        <div class="row">
                            
                            <div class="col-md-12">
                                <h1><c:out value="${descricao}"/></h1>		
                            </div>
                        </div>	
                        <div class="row">				
                            <div class="col-md-6 Cliente-Label-bottom">
                                <label><h4>Nome:</h4></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 style-input">
                                <input type="text" value="<c:out value="${cliente.nome}"/>" class="form-control " name="cliente_nome" placeholder="nome...">
                            </div>
                        </div>
                        <div class="row">				
                            <div class="col-md-3 Cliente-Label-bottom">
                                <label><h4>Data Nasc.:</h4></label>
                            </div>
                            <div class="col-md-3 Cliente-Label-bottom">
                                <label><h4>CPF:</h4></label>
                            </div>
                            <div class="col-md-3 Cliente-Label-bottom">
                                <label><h4>Telefone:</h4></label>
                            </div>
                        </div>
                        <div class="row">	
                            <div class="col-md-3 style-input">
                                <input type="Date" class="form-control " value="<c:out value="${cliente.data_nascimento}"/>" name="cliente_data_nascimento" placeholder="data nascimento">
                            </div>

                            <div class="col-md-3 style-input">
                                <input type="CPF" class="form-control " value="<c:out value="${cliente.cpf}"/>" name="cliente_cpf" placeholder="cpf">
                            </div>

                            <div class="col-md-3 style-input">
                                <input type="Telefone" class="form-control " value="<c:out value="${cliente.telefone}"/>" name="cliente_telefone" placeholder="telefone">
                            </div>
                        </div>
                        <div class="row">	
                            <div class="col-md-3 Cliente-Label-bottom">
                                <label><h4>E-mail:</h4></label>
                            </div>
                        </div>
                        <div class="row">	
                            <div class="col-md-5 style-input">
                                <input type="email" class="form-control " value="<c:out value="${cliente.email}"/>" name="cliente_email" placeholder="email">
                            </div>
                            <div class="col-md-5 style-input">
                                <label for="sex">Sexo:</label>
                                <input type="radio" name="cliente_sexo" value="M" <c:out default="None" value="${ (cliente.sexo == 'M')?'checked':''}"/>> Homem
                                <input type="radio" name="cliente_sexo" value="F" <c:out default="None" value="${ (cliente.sexo == 'F')?'checked':''}"/>> Mulher
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <button type="submit" name="salvar" class="btn btn-success">Salvar</button>
                                <button type="button" name="limpar" class="btn btn-warning">Limpar</button>
                                <button type="button" name="cancelar" class="btn btn-danger">Cancelar</button>
                                <input type="hidden" name="id_cliente" value="<c:out value="${cliente.id_cliente}"/>">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </jsp:body>

</t:defaultTemplate>

