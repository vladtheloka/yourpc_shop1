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
            for(var i in res)
            {
                items += '<tr><td>' + res[i].id + '</td><td>' + res[i].name + '</td><td>' + res[i].price + '</td><td>' + res[i].content + '</td><td>' + res[i].category.name + '<td><img src="' + res[i].pathImage +'">' + '</td></tr>'
            }
            document.getElementById('searchResult').innerHTML = items;
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


function searchItems() {
    var names = [];
    var result = [];

    $.ajax({
        url: '/itemSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                names.push(res[i].name);
            }
            console.log(names);
            var input, filter, div, div_2;
            input = document.getElementById("searchIn");
            filter = input.value;
            div = document.getElementById("searchDiv");
            div_2 = div.getElementsByTagName("div");
            for (i = 0; i < div_2.length; i++) {
                for (var j = 0; j < names.length; j++) {
                    if (names[j].match(new RegExp(filter, 'gi'))) {
                        div_2[j].style.display = "";
                    } else {
                        div_2[j].style.display = "none";
                    }
                }
            }
            console.log(names);
        },
        error: function (err) {
            console.log(err)
        }
    })


}