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
        Relatorios
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="assets/css/relatorio.css"/>"/>

        <!--Load the AJAX API-->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script src="<c:url value="/assets/js/relatorio.js"/>" type="text/javascript" charset="utf-8" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:defaultNavSearching>
            <jsp:attribute name="contentSearching">

                <select name="" class="form-control filter input-sm " >
                    <option>Selecione um Filtro</option>
                    <option value="/petMania/sistema?param=relatorio&acao=Relatorio&chart=filial">Filial</option>
                    <option value="/petMania/sistema?param=relatorio&acao=Relatorio&chart=produto">Produto</option>
                    <option value="vendedor">Vendedor</option>
                </select>

                <select name="" class="form-control filter-filial input-sm " >
                    <option>Selecione uma filial</option>
                    <c:forEach items="${filiais}" var="filiais">
                        <c:if test="${filiais.ID != 1}">
                            <option value="/petMania/sistema?param=relatorio&acao=Relatorio&chart=vendedor&id_vendedor=<c:out value="${filiais.ID}"/>">
                                <c:out value="${filiais.DESCRICAO}"/>
                            </option>  
                        </c:if>

                    </c:forEach>

                </select>

            </jsp:attribute>

            <jsp:attribute name="novoregistrobtn">

            </jsp:attribute>
        </t:defaultNavSearching>
        <div class="content-main  container-grafico col-md-10">
            <div id="chart" style="width: 900px; height: 500px;">             



            </div>
        </jsp:body>

    </t:defaultTemplate>

