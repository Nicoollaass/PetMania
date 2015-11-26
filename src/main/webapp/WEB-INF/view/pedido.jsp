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
        Pedido
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="assets/css/pedido.css"/>"/>
    </jsp:attribute>

    <jsp:body>
        
        <div class="container container-principal">
            <div class="row header-pedido">
                <div class="col-md-4">
                    <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>Vincular Cliente</span>
                </div>
                <div class="col-md-4">
                    <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>Pedido</span>
                </div>
                <div class="col-md-4">
                    <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>Pagamento</span>
                </div>
            </div>
            <div class="row descricao-venda">
                <div class="col-md-4">
                    <span class="title-cod">Código do pedido</span>
                    <span class="codigo">
                        <c:out value="${codigo}"/>
                    </span>
                </div>
                <div class="col-md-8">
                    <span><strong>Nome vendedor:</strong> <c:out value="${vendedor}"/></span>
                    <span><strong>Nome cliente:</strong> <c:out value="${cliente}"/></span>
                </div>
            </div>
            <div class="row tabela">
                <div class="col-md-12">
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                            <tr>
                              <th>Desricao do produto</th>
                              <th>Quantidade</th>
                              <th>Preço</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${vendas}" var="vendas">
                                <tr>
                                  <td><c:out value="${vendas.descricao}"/></td>
                                  <td><c:out value="${vendas.qtde}"/></td>
                                  <td><c:out value="${vendas.preco}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                      </table>
                    </div>
                </div>
            </div>
            <div class="row total">
                <div class="col-md-4 pull-right">
                    <strong>Total:    </strong><span class="text-total"><c:out value="${total}"/></span>
                </div>
            </div>
        </div>
        
    </jsp:body>

</t:defaultTemplate>

