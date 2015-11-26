$(function(){

    /*Select para os filtros*/
    $(".filter").change(function(event) {
        if($(this).val() == "vendedor") {
            $("select.filter-filial.form-control").slideDown('slow');
        }else {
            window.location.href = $(this).val();
        }
    });

    /*Filtro por filial*/
    $(".filter-filial").change(function(event) {
        window.location.href = $(this).val();
    });

    
})


/*Importando a api do google*/
google.load('visualization', '1.0', {'packages':['corechart']});

// Seta a função quando a api do google estiver carregada.
google.setOnLoadCallback(drawChart);

/*
*Função para formar o grafico
*/ 
function drawChart() {
        
        var url = window.location.href;
        var titulo;
        
        
        /*se o parametro da url estiver com estes parametros monstra o grafico que segue dento do if*/
        if(url.indexOf("filial") > -1){
            
            /*Titulo do grafico*/
            titulo = "Relatório por Filial";

            /*Requisição para o servidor*/
            var jsonData = $.ajax({
                  url: "sistema?param=relatorio&acao=RelatorioFilial",
                  dataType: "json",
                  async: false
            }).responseText;


            var jsonData = JSON.parse(jsonData)
            var title = jsonData.map(function(obj){return obj.FILIAL});
            title.unshift("Filial");
            var content = jsonData.map(function(obj){return obj.QUANTIDADE});
            content.unshift("Filiais");
            

        } else if (url.indexOf("produto") > -1){

            /*titulo do grafico*/
            titulo = "Produtos mais vendidos por filial";

            /*requisição para o servidor*/
            var jsonData = $.ajax({
                  url: "sistema?param=relatorio&acao=RelatorioProduto",
                  dataType: "json",
                  async: false
            }).responseText;

            var jsonData = JSON.parse(jsonData)
            var title = jsonData.map(function(obj){return obj.DESCRICAO});
            title.unshift("Produtos");
            var content = jsonData.map(function(obj){return obj.QUANTIDADE});
            content.unshift("Produtos");
        
        } else if (url.indexOf("id_vendedor") > -1 ){
            
            /*titulo do grafico*/
            titulo = "Vendedor que mais se destacou nas vendas";
            var param = url.split("id_vendedor=");
            
            /*requisição para o servidor*/
            var jsonData = $.ajax({
                  url: "sistema?param=relatorio&acao=RelatorioVendedor&id_vendedor="+param[1],
                  dataType: "json",
                  type: 'POST',
                  async: false,
                  data: {id_vendedor: param[1]}
            }).responseText;


            /*passando para json*/
            var jsonData = JSON.parse(jsonData)
            var title = jsonData.map(function(obj){return obj.NOME});
            title.unshift("Nome");
            var content = jsonData.map(function(obj){return obj.QUANTIDADE});
            content.unshift("Nomes");
        }

        /*Seta as informações para desenhar o grafico*/
        var data = google.visualization.arrayToDataTable([
            title,
            content
        ]);
    

        /*Setando o titulo no grafico*/
        var view = {
            "title": titulo
        }  
        
        

        // Instanciando o chart e passando as options
        var chart = new google.visualization.ColumnChart(document.getElementById('chart'));
        chart.draw(data, view);
    
  }

















