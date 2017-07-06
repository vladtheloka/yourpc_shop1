function search() {

    $.ajax({
        url: '/searchItem?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res) {
            var items = '';
            for (var i in res) {
                items += '<tr><td>' + res[i].id + '</td><td>' + res[i].name + '</td><td>' + res[i].price + '</td><td>' + res[i].content + '</td><td>' + res[i].category.name + '<td><img src="' + res[i].pathImage + '">' + '</td></tr>'
            }
            document.getElementById('searchResult').innerHTML = items;
        }
    })
}

function searchItems() {
    var names = [];
    $.ajax({
        url: '/itemSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                names.push(res[i].name);
            }
            console.log(names);
            var input, filter, div, div_2, range_min, range_max;
            input = document.getElementById("searchIn");
            range_min = document.getElementById("price-min");
            range_max = document.getElementById("price-max");
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
        },
        error: function (err) {
            console.log(err)
        }
    })


}

function searchPrices() {
    var prices = [];
    $.ajax({
        url: '/itemSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                prices.push(res[i].price);
            }
            var div, div_2, range_min, range_max;
            range_min = document.getElementById("price-min").value;
            range_max = document.getElementById("price-max").value;
            div = document.getElementById("searchDiv");
            div_2 = div.getElementsByTagName("div");

            for (i = 0; i < div_2.length; i++) {
                for (var j = 0; j < prices.length; j++) {
                    if (prices[j] >= range_min && prices[j] <= range_max) {
                        div_2[j].style.display = "";
                    } else {
                        div_2[j].style.display = "none";
                    }
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })


}


function searchCategories() {
    var categories = [];
    $.ajax({
        url: '/itemSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                categories.push(res[i].category.name);
            }
            var div, div_2, spanText;

            $("span.mySpan").click(function () {
                spanText = $(this).text();
                div = document.getElementById("searchDiv");
                div_2 = div.getElementsByTagName("div");

                for (i = 0; i < div_2.length; i++) {
                    for (var j = 0; j < categories.length; j++) {
                        if (categories[j] == spanText || spanText == "All") {
                            div_2[j].style.display = "";
                        } else {
                            div_2[j].style.display = "none";
                        }
                    }
                }
            });
        },
        error: function (err) {
            console.log(err)
        }
    })


}

function changeLabel() {
    $("#amount").val("$" + document.getElementById("price-min").value + " - $" + document.getElementById("price-max").value);

}