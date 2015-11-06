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
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/animal.css"/>"/>
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
            <div class="conteiner-fluid col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <h1><c:out value="${descricao}"/></h1>
                    </div>
                </div>
                <form action="<c:url value="${action}"/>" method="POST"  accept-charset="utf-8">
                    <div class="row">				
                        <div class="col-md-5 Animal-Label-bottom-30">
                            <label ><h4 >Cliente:</h4></label>
                        </div>
                        <div class="col-md-4 Animal-Label-bottom-30">
                            <label><h4>Nome do Animal:</h4></label>
                        </div>
                        <div class="col-md-3 Animal-Label-bottom-30">
                            <label><h4>Idade:</h4></label>
                        </div>
                    </div>                            	
                    <div class="row top-buffer-mais">								
                        <div class="col-md-5 form-group">
                            <select name="id_cliente" value="" class="form-control" id="Cliente">
                                <c:forEach items="${clientes}" var="cliente">
                                    <option value="<c:out value="${cliente.id_cliente}"/>"><c:out value="${cliente.nome}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4 style-input">
                            <input type="select" name="Nome" value="" class="form-control " placeholder="Nome do Animal...">
                        </div>
                        <div class="col-md-3 style-input">
                            <input type="text" name="Idade" value="" class="form-control inputAnimal-float-right" placeholder="Idade...">
                        </div>
                    </div>
                    <div class="row">				
                        <div class="col-md-3 Animal-Label-bottom">
                            <label ><h4 >Tipo Animal:</h4></label>
                        </div>
                        <div class="col-md-3 Animal-Label-bottom">
                            <label><h4>Raça:</h4></label>
                        </div>
                        <div class="col-md-3 Animal-Label-bottom">
                            <label><h4>Idade:</h4></label>
                        </div>
                        <div class="col-md-3 Animal-Label-bottom">
                            <label><h4>Porte:</h4></label>
                        </div>
                    </div>   
                    <div class="row">
                        <div class="col-md-3 form-group">
                            <select name="Idade" value="" class="form-control" id="Tipo Animal">
                                <c:forEach items="${tiposAnimais}" var="tiposAnimais">
                                    <option value="<c:out value="${tiposAnimais.id}"/>"><c:out value="${tiposAnimais.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>	
                        <div class="col-md-3 form-group">
                            <select name="id_raca" value="" class="form-control" id="Raca">
                                <c:forEach items="${racas}" var="racas">
                                    <option value="<c:out value="${racas.id}"/>"><c:out value="${racas.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>		
                        <div class="col-md-3 form-group">
                            <input type="text" name="cor" value="" class="form-control inputAnimal-float-right" placeholder="Cor...">
                        </div>
                        <div class="col-md-3 form-group">
                            <select name="id_porte" value="" class="form-control inputAnimal-float-right" id="Porte">
                                <c:forEach items="${portes}" var="portes">
                                    <option value="<c:out value="${portes.id}"/>"><c:out value="${portes.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                    </div>						
                    <div class="row">
                        <div class="col-md-12 text-right Animal-top-buffer-4  ">
                            <button type="button" name="cadastrar" value="cadastrar" class="btn btn-success">Cadastrar</button>
                            <button type="button" name="limpar" value="limpar" class="btn btn-warning">Limpar</button>
                            <button type="button" name="cancelar" value="cancelar" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>

</jsp:body>

</t:defaultTemplate>

