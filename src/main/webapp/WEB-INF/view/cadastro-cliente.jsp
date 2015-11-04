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
                    <button type="button" class="btn btn-success">Novo registro</button>
                </div>
            </jsp:attribute>
                
        </t:defaultNavSearching>
            <div class="content-main col-md-10">
                <div class="conteiner-fluid">
                    <form action="" method="POST" accept-charset="utf-8">
                        <div class="row">
                            <div class="col-md-12">
                                <h1>Novo Cliente</h1>		
                            </div>
                        </div>	
                        <div class="row">				
                            <div class="col-md-6 Cliente-Label-bottom">
                                <label><h4>Nome:</h4></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 style-input">
                                <input type="text" class="form-control " placeholder="nome...">
                            </div>
                        </div>
                        <div class="row">				
                            <div class="col-md-2 Cliente-Label-bottom">
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
                            <div class="col-md-2 style-input">
                                <input type="Date" class="form-control " placeholder="data nascimento">
                            </div>

                            <div class="col-md-3 style-input">
                                <input type="CPF" class="form-control " placeholder="cpf">
                            </div>

                            <div class="col-md-3 style-input">
                                <input type="Telefone" class="form-control " placeholder="telefone">
                            </div>
                        </div>
                        <div class="row">	
                            <div class="col-md-3 Cliente-Label-bottom">
                                <label><h4>E-mail:</h4></label>
                            </div>
                        </div>
                        <div class="row">	
                            <div class="col-md-5 style-input">
                                <input type="email" class="form-control " placeholder="email">
                            </div>
                            <div class="col-md-5 style-input">

                                <label for="sex">Sexo:</label>
                                <input type="radio" name="sex" value="Homem" checked=""> Homem
                                <input type="radio" name="sex" value="Mulher"> Mulher
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <button type="button" class="btn btn-success">Salvar</button>
                                <button type="button" class="btn btn-warning">Limpar</button>
                                <button type="button" class="btn btn-danger">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </jsp:body>

</t:defaultTemplate>

