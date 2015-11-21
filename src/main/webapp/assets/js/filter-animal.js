$(function(){
    //ao carregar a página realiza a busca dos animais
    searchAnimals();
	
	/*chenge filters ======================================================*/
	$(".check-filter").change(function() {
        searchAnimals();		
    });

    function searchAnimals(){
        var filtros = $('#filter-dinamic').serialize();
        $.ajax({
            url: 'http://localhost:8080/petMania/sistema?acao=FilterAnimais',
            type: 'POST',
            dataType: 'json',
            data: filtros,
            success: function(data){
                var table = null;
                $.each(data, function(i, item) {
                    table += "<tr>"+
                    "<td>"+item.id_animal+"</td> "+
                    "<td>"+item.nome+"</td> "+
                    "<td>"+item.id_raca+"</td> "+ 
                    "<td>"+item.cor+"</td> "+
                    "<td>"+item.idade+"</td> "+
                    "<td>"+item.id_cliente+"</td> "+
                    "<td> "+
                        "<button type='button' class='btn btn-info'><a href=''>+Info</a></button> "+
                        "<button type='button' class='btn btn btn-primary'><a href='/sistema?acao=EditarAnimal&id="+item.id_animal+"'>Editar</a></button> "+
                        "<button type='button' class='btn btn-danger'><a href='/sistema?acao=ExcluirAnimal&id="+item.id_animal+"'>Exluir</a></button> "+
                    "</td> "+
                    "</tr> "
                });

                $(".line-filter").html(table);
            
            }
        })

    }

})