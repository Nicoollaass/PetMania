google.load("visualization", "1.1", {packages:["bar"]});



var obj = {

    "filial": function() {

        google.setOnLoadCallback(drawChart);
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
        var data = google.visualization.arrayToDataTable([
            title,
            content
        ]);

        var options = {
          chart: {
            title: 'Company PetMania',
            subtitle: '4Build IT',
          }
        }

        var chart = new google.charts.Bar(document.getElementById('chart_div'));

        chart.draw(data, options);
    }  
}

obj.filial









function filial() {

       
}



