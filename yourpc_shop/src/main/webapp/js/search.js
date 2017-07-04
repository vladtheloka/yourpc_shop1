function search() {

    $.ajax({
        url: '/searchItem?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res)
        {
            var items = '';
            var divItems= '';
            for(var i in res)
            {
                items += '<tr><td>' + res[i].id + '</td><td>' + res[i].name + '</td><td>' + res[i].price + '</td><td>' + res[i].content + '</td><td>' + res[i].category.name + '<td><img src="' + res[i].pathImage +'">' + '</td></tr>'
                divItems += '<div><img src="' + res[i].pathImage + '"></div>'
            }
            document.getElementById('searchResult').innerHTML = items;
            document.getElementById('searchDiv').innerHTML = divItems;
            console.log(res);
        }
    })
}

$(function () {
    $("#slider-range").slider({
        range: true,
        min: 0,
        max: 1000,
        values: [75, 300],
        slide: function (event, ui) {
            $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
        }
    });
    $("#amount").val("$" + $("#slider-range").slider("values", 0) +
        " - $" + $("#slider-range").slider("values", 1));
});