<%-- 
    Document   : cadastro-produtos
    Created on : 20/11/2015, 20:33:21
    Author     : Felipe
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
        <link rel="stylesheet" type="text/css" href="assets/css/produtos.css">
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

           <!--copiar ate aqui --> 
            
            <div class="conteiner-fluid">
                <form action="<c:url value="${action}"/>" method="POST" accept-charset="utf-8">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>Cadastro de Produtos</h1>
                        </div>	
                    </div>  	
                    

                    <div class="row">
                       
                        <div class="col-md-11 style-input">
                            <label><h4>Nome:</h4></label>
                            <!--<input type="select" name="nome" value="" class="form-control " placeholder="nome..." required> -->
                            <input type="text" value="<c:out value="${produto.nome}"/>" class="form-control " name="nome" placeholder="nome...">
                        </div>

                        <div class="col-md-6 style-input">
                            <label><h4>Descrição:</h4></label>
                            <!--<input type="select" name="descricao" value="" class="form-control " placeholder="Descrição..." required> -->
                            <input type="text" value="<c:out value="${produto.descricao}"/>" class="form-control " name="descricao" placeholder="Preço...">
                        </div>
                        
                        <div class="col-md-3 style-input">
                            <label><h4>Data de entrada:</h4></label>
                            <input type="Date" class="form-control " value="<c:out value="${produto.data_entrada}"/>" name="data_entrada" placeholder="data de entrada">
                        </div>


                        <div class="col-md-5 form-group">
                            <label><h4>Marca</h4></label>                            
                            <select class="form-control" name="marca" value=""  id="Produto" required>
                                <!--<option>Marca...</option>-->
                                <c:forEach items="${marca}" var="marca">
                                    <option value="<c:out value="${marca.marca}"/>" <c:out value="${(marca.marca == produto.id_marca)?'selected':''}"/>><c:out value="${marca.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                       

                        <div class="col-md-5 form-group">
                            <label><h4>Categoria:</h4></label>
                            <select class="form-control" name="categoria" value="" id="Produto" required>
                                <!--<option>Marca...</option>-->
                                 <c:forEach items="${categoria}" var="categoria">
                                    <<option value="<c:out value="${categoria.id_categoria}"/>"<c:out value="${(categoria.id_categoria == produto.id_categoria)?'selected':''}"/>><c:out value="${categoria.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 style-input">
                             <label><h4>Preço:</h4></label>
                            <!--<input type="select" name="preco" value="" class="form-control " placeholder="Preço..." required>-->
                            <input type="text" value="<c:out value="${produto.preco}"/>" class="form-control " name="preco" placeholder="Preço...">
                        </div>
                        

                       

                        <div class="row margin-right-buffer-8">
                            <div class="col-md-12 text-right ">
                                <button type="submit" name="salvar" value="salvar" class="btn btn-success">Salvar</button>
                                <button type="button" name="limpar" value="limpar" class="btn btn-warning">Limpar</button>
                                <button type="button" name="cancelar" value="cancelar" class="btn btn-danger">Cancelar</button>
                                <input type="hidden" name="id_produto" value="<c:out value="${produto.id_produto}"/>">
                            </div>
                        </div>



                    </div>
                </form>
            </div>

        </div>
    </jsp:body>

</t:defaultTemplate>

