$(function(){

	var id_cliente = 0;
	
	//filtrando clientes dinamicamente
	ajaxClientes();

	/*populando carrinho*/
	addProdoCart("");

	/*logica para adicionar produtos no carrinho ================*/
	$('body').on('click','.plus', function() {

		var idForm = $(this).data('produto');
		var form = $("#"+idForm);
		var valueInputQuant = form.find('input[type="number"]').val();

		if(valueInputQuant > 0 && valueInputQuant != ""){
			addProdoCart(form);
			$(".item-cart").slideDown('slow').delay(1500).slideUp('slow');	
		}else {
			alert("Quantidade inválida");
		}
		
	});

	$('body').on('click','.remove', function() {
		var form = $(this).parent();
		removeProdCart(form);
		listaItensPagamento();
	});

	$('body').on('click','.cart > span', function() {
		$(".item-cart").slideToggle('slow');		
	});	
	
	$('body').on('click','.vincular', function() {
		id_cliente = $(this).next().val();
	    var step = $(".step-2");
		step.addClass('step-on');
		$('html,body').delay(100).animate({scrollTop: step.position().top}, "slow");
		ajaxProdutos();
	});

	$('body').on('click','#finalizar-compra', function() {
		
		produto = isProduto();
		if(produto == null){
			var step = $(".step-3");
			step.addClass('step-on');
			$('html,body').delay(100).animate({scrollTop: step.position().top}, "slow");
			listaItensPagamento();	
		}else {
			alert("O produto "+produto+" está com uma quantidade inválida");
		}


	    
	});

	$("#efetuar-pagamento").click(function(event) {
		if(id_cliente > 0){
			efetuarPagamento(id_cliente);
		}
	});
	
	

})

/*
*Função responsavel por resgatar clientes para montar a tabela de produto
*@param = null
*@return = null
*/
function ajaxClientes(){
	$.ajax({
		url: 'sistema?param=clientes&acao=FilterClientes',
		type: 'POST',
		dataType: 'json',
		data: {},
		beforeSend: function() {
			$(".container-load").fadeIn();   
		}
	})
	.done(function(data) {
		$(".container-load").delay(1000).fadeOut();
		var html = "";

	    $.each(data, function(i, item) {
	        html +="<tr>"+
				        "<th scope='row'>"+item.id_cliente+"</th>"+
				        "<td>"+item.nome+"</td>"+
				        "<td>"+item.idade+"</td>"+
				        "<td>"+item.email+"</td>"+
				        "<td>"+
				            "<span class='glyphicon glyphicon-ok-sign vincular icon-acoes' aria-hidden='true'></span>"+
				            "<input type='hidden' value='"+item.id_cliente+"'>"+
				        "</td>"+
				    "</tr>";
	    });
	    
	    $(".inserir-cliente").html(html);

	});
}

/*
*Função responsavel por resgatar produtos em estoque e montar a tabela de produtos
*para que o mesmo seja adicionado no carrinho dinamicante pelo usuário
*@param = null
*@return = null
*/
function ajaxProdutos(){

	$.ajax({
		url: 'sistema?param=produto&acao=FilterProduto',
		type: 'POST',
		dataType: 'json',
		data: {}
	})
	.done(function(data) {
		var html = "";
		$.each(data, function(i, item) {
			//montando a tabela de produto com com o json resgatado 
			html += "<tr>"+
	                    "<th>"+item.produto.id_produto+"</th>"+
	                    "<td>"+item.produto.descricao+"</td>"+
	                    "<td>R$ "+item.produto.preco+
	                    "<td>"+
	                    	"<form id='form-"+item.produto.id_produto+"' class='form-cart' accept-charset='utf-8'>"+
	                    		"<input type='hidden' name='id_produto' value='"+item.produto.id_produto+"'>"+
	                        	"<input type='number' class='form-control quant-input' name='quantidade' value='0'>"+
	                        "</form>"+
	                    "</td>"+
	                    "<td>"+
	                        item.quantidade+
	                    "</td>"+
	                    "<td class='opcoes'>"+
	                        "<span data-produto='form-"+item.produto.id_produto+"' class='glyphicon glyphicon-plus-sign plus icon-acoes' aria-hidden='true'></span>"+
	                    "</td>"+
	                "</tr>";			
		});


		//inseriondo html de produtos na tabela
		$('.inserir-produto').html(html);
		

	});
}

/*
*Função responsavel por adicionar produto no carrinho
*@param = formulário para que seja resgatdas as informações
*/
function addProdoCart(form){
	
	var values = {};

	if(form != "") {
		values = form.serialize();
	}

	$.ajax({
		url: 'sistema?param=carrinho&acao=AdicionarCarrinho',
		type: 'POST',
		dataType: 'json',
		data: values
	})
	.done(function(itens_cart) {
		var html = "";
		$.each(itens_cart.itens, function(i, item) {
			//montando a tabela de produto com com o json resgatado 
			html += "<tr>"+
                        "<td>"+item.produto.descricao+"</td>"+
                        "<td>"+item.quantidade+"</td>"+
                        "<td>"+
                            "<form>"+
                                "<input type='hidden' name='id_prod_cart' value='"+i+"'>"+
                                "<span class='glyphicon glyphicon-remove-sign minus remove' aria-hidden='true'></span>"+
                            "</form>"+
                        "</td>"+
                    "</tr>";		
		});

		$(".total-pedido > p > .money").html(itens_cart.total.toFixed(2));

		//inseriondo html de produtos na tabela
		$('.itens-cart').html(html);
	});
	
}

/*
*Função responsavel por remover produto no carrinho
*@param = formulário para que seja resgatdas as informações
*/
function removeProdCart(form){

	values = form.serialize();

	$.ajax({
		url: 'sistema?param=carrinho&acao=RemoverCarrinho',
		type: 'POST',
		dataType: 'json',
		data: values
	})
	.done(function(itens_cart) {
		var html = "";
		$.each(itens_cart.itens, function(i, item) {
			//montando a tabela de produto com com o json resgatado 
			html += "<tr>"+
                        "<td>"+item.produto.descricao+"</td>"+
                        "<td>"+item.quantidade+"</td>"+
                        "<td>"+
                            "<form>"+
                                "<input type='hidden' name='id_prod_cart' value='"+i+"'>"+
                                "<span class='glyphicon glyphicon-remove-sign minus remove' aria-hidden='true'></span>"+
                            "</form>"+
                        "</td>"+
                    "</tr>";		
		});

		$(".total-pedido > p > .money").html(itens_cart.total.toFixed(2));

		//inseriondo html de produtos na tabela
		$('.itens-cart').html(html);
	});
	
}

/*
*Função responsavel por listar os produtos no carrinho para efetuar compra
*@param = formulário para que seja resgatdas as informações
*/
function listaItensPagamento(){

	$.ajax({
		url: 'sistema?param=carrinho&acao=AdicionarCarrinho',
		type: 'POST',
		dataType: 'json'
	})
	.done(function(itens_cart) {
		var html = "";
		$.each(itens_cart.itens, function(i, item) {
			//montando a tabela de itens de produto com com o json resgatado 
			html += "<tr>"+
				        "<td>"+item.produto.descricao+"</td>"+
				        "<td>"+item.quantidade+"</td>"+
				        "<td>"+item.produto.preco+"</td>"+
				    "</tr>";		
		});

		

		$(".input-total > input").val(itens_cart.total.toFixed(2));

		//inseriondo html de produtos na tabela
		$('.itens-pagamento').html(html);
	});
	
}

/*
*Função responsavel por efetuar um pagamento
*@param = formulário para que seja resgatdas as informações
*/

function efetuarPagamento(id){
	$.ajax({
		url: 'sistema?param=venda&acao=Pagamento',
		type: 'POST',
		dataType: 'json',
		data: {id_cliente:id}
	})
	.done(function(jsonVendas) {
		if(jsonVendas.insert == "false"){
			alert("Erro ao efetuar a venda, por favor tente novamente mais tarde");
		}else if(jsonVendas.insert == "quant_invalid"){
			alert("Quantidade de produto inválida");
		}else {
			window.location.href = '/petMania/sistema?param=venda&acao=Pedido&id_venda='+jsonVendas.id_venda;	
		}
	});
	
}


/*
*Função responsavel por verificar se os produtos no carrinho estão disponiveis
*@param = null
*/

function isProduto(){
	var produto = $.ajax({
          url: "sistema?param=produto&acao=Estoque",
          dataType: "json",
          async: false
    }).responseText;
	
	var jsonData = JSON.parse(produto);
	console.log(jsonData);
	
	if(jsonData == null){
		return null;
	}
	return jsonData.descricao;
}

