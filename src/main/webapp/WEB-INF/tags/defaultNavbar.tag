<%-- 
    Document   : defaultNavbar
    Created on : 02/11/2015, 14:30:39
    Author     : Nicolas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- navegation -->
<header class="header">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Icon pet</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav col-md-10">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Relatórios<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Vendas</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Listar<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Produto</a></li>
                            <li><a href="#">Serviços</a></li>
                            <li><a href="#">Funcionarios</a></li>
                            <li><a href="<c:url value="/sistema?acao=ListarClientes"/>">Clientes</a></li>
                            <li><a href="#">Animais</a></li>
                            <li><a href="#">Filiais</a></li>
                        </ul>
                    </li>						
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Vendas<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Produto</a></li>
                            <li><a href="#">Serviços</a></li>
                        </ul>
                    </li>
                    <li><a href="#agenda">Agendamento de serviços</a></li>
                    <li class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usuarioLogado.getUsuario()}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>	
</header>
<!-- /navegation -->
