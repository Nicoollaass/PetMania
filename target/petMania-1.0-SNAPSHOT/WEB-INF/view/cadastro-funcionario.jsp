<%-- 
    Document   : cadastro-produtos
    Created on : 18/11/2015, 20:39:02
    Author     : Hp
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
                            <h1>Cadastro de Funcionarios</h1>
                        </div>	
                    </div>  	
                    

                    <div class="row">
                       
                        <div class="col-md-11 style-input">
                            <label><h4>Nome:</h4></label>
                            <!--<input type="select" name="nome" value="" class="form-control " placeholder="nome..." required> -->
                            <input type="text" value="<c:out value="${funcionario.nome}"/>" class="form-control " name="nome" placeholder="nome...">
                        </div>

                        <div class="col-md-6 style-input">
                            <label><h4>Email:</h4></label>
                            <!--<input type="select" name="descricao" value="" class="form-control " placeholder="Descrição..." required> -->
                            <input type="text" value="<c:out value="${funcionario.email}"/>" class="form-control " name="email" placeholder="Email...">
                        </div>
                        
                        <div class="col-md-3 style-input">
                            <label><h4>Data de nascimento:</h4></label>
                            <input type="Date" class="form-control " value="<c:out value="${funcionario.data_nascimento}"/>" name="data_nascimento" placeholder="data de nascimento">
                        </div>
                        
                        <div class="col-md-3 style-input">
                            <label><h4>CPF:</h4></label>
                            <input type="Text" class="form-control " value="<c:out value="${funcionario.cpf}"/>" name="cpf" placeholder="cpf...">
                        </div>


                        <div class="col-md-5 form-group">
                            <label><h4>Cargo</h4></label>                            
                            <select class="form-control" name="TipoFuncionario" value=""  id="Produto" required>
                                <!--<option>Marca...</option>-->
                                <c:forEach items="${TipoFuncionario}" var="TipoFuncionario">
                                    <option value="<c:out value="${TipoFuncionario.id_tipo_funcionario}"/>" <c:out value="${(TipoFuncionario.id_tipo_funcionario == funcionario.id_tipo_funcionario)?'selected':''}"/>><c:out value="${TipoFuncionario.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                       

                        <div class="col-md-5 form-group">
                            <label><h4>Localidade:</h4></label>
                            <select class="form-control" name="locacao" value="" id="Produto" required>
                                <!--<option>Marca...</option>-->
                                 <c:forEach items="${locacao}" var="locacao">
                                    <<option value="<c:out value="${locacao.id_locacao}"/>"<c:out value="${(locacao.id_locacao == funcionario.id_locacao)?'selected':''}"/>><c:out value="${locacao.descricao}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="row margin-right-buffer-8">
                            <div class="col-md-12 text-right ">
                                <button type="submit" name="salvar" value="salvar" class="btn btn-success">Salvar</button>
                                <button type="button" name="limpar" value="limpar" class="btn btn-warning">Limpar</button>
                                <button type="button" name="cancelar" value="cancelar" class="btn btn-danger">Cancelar</button>
                                <input type="hidden" name="id_funcionario" value="<c:out value="${funcionario.id_funcionario}"/>">
                            </div>
                        </div>



                    </div>
                </form>
            </div>

        </div>
    </jsp:body>

</t:defaultTemplate>

