<%-- 
    Document   : defalutNavSearching
    Created on : 02/11/2015, 16:03:35
    Author     : Nicolas
--%>
<%@attribute name="contentSearching" fragment="true" %>
<!-- barra de pesquisa -->
<div class="control-consulta col-md-2">
    <h1 class="title-filter">Filtros de pesquisa:<span class="config glyphicon glyphicon-wrench" aria-hidden="true"></span></h1>
    <div class="input-group custom-search-form">
        <jsp:invoke fragment="contentSearching"/>
    </div>
</div>
<!-- /barra de pesquisa -->