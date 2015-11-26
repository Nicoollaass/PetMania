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
        Realizar venda
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="assets/css/venda-produto.css"/>"/>
        <script src="<c:url value="/assets/js/venda-produto.js"/>" type="text/javascript" charset="utf-8" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:defaultNavSearching>
            <jsp:attribute name="contentSearching">


            </jsp:attribute>

            <jsp:attribute name="novoregistrobtn">
                <div class="novo-registro">
                    <button type="button" class="btn btn-success"><a href="<c:url value="/sistema?param=clientes&acao=CadastrarCliente"/>">Novo Cliente</a></button>
                </div>
            </jsp:attribute>
        </t:defaultNavSearching>
        <!-- tabela -->
        <div class="content-main col-md-10">
            <div class="container-load">
                <button class="btn btn-lg btn-warning"><span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Carregando...</button>
            </div>
            <div class="step-1 step">
                <h1>Informe um cliente</h1>
                <table class="table table-hover">
                    <caption>Vincular um cliente.</caption>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Idade</th>
                            <th>E-mail</th>
                            <th>Vincular</th>
                        </tr>
                    </thead>
                    <tbody class="inserir-cliente">
                    </tbody>
                </table>
            </div>
            <div class="step-2 step">
                <div class="cart">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                    <div class="item-cart">
                        <table>
                            <thead>
                                <tr>
                                    <th>Descrição</th>
                                    <th>Quantidade</th>
                                    <th>Remover</th>
                                </tr>
                            </thead>
                            <tbody class="itens-cart">
                            </tbody>
                        </table>
                        <div class="total-pedido">
                            <p>Total: R$ <span class="money"></span></p>
                        </div>
                    </div>
                </div>
                <h1>Realizar pedido</h1>
                <div class="table-responsive">
                    <table class="table">	
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Descrição</th>
                                <th>Valor item</th>
                                <th>Quantidade</th>
                                <th>Quant Estoque</th>
                                <th>Adicionar no carrinho</th>
                            </tr>
                        </thead>
                        <tbody class="inserir-produto">
                        </tbody>
                    </table>
                </div>
                <div class="form-group finalizar-compra">
                    <button type="button" id="finalizar-compra" class="btn btn-success">Finalizar compra</button>
                </div>
            </div>

            <div class="step-3 step">
                <h1>Pagamento</h1>
                <div class="form-group style-pagamento">
                    <div>
                        <label>Tipo de pagamento:</label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            Á vista
                        </label>
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            Parcelado
                        </label>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-pedido-finalizado">	
                            <thead>
                                <tr>
                                    <th>Descrição</th>
                                    <th>Quantidade</th>
                                    <th>Preço por Item</th>
                                </tr>
                            </thead>
                            <tbody class="itens-pagamento">
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <label class="info-desconto">Á vista acima de R$ 300,00 em compras 5% de desconto</label>
                        <label class="info-desconto">Acima de 5 de compras 10% de desconto</label>
                    </div>
                </div>
                <div class="form-group container-total">
                    <label for"valor-total" class="label-total control-label">Total</label>
                    <div class="input-total ">
                        <input  type="text" id="disabledInput" disabled class="form-control"  value="0">
                    </div>
                </div>
                <div class="form-group finalizar-compra">
                    <button type="button" id="efetuar-pagamento" class="btn btn-success ">Efetuar pagamento</button>
                </div>
            </div>

        </div>
        <!-- /tabela -->
    </jsp:body>

</t:defaultTemplate>

