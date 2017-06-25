// function search() {
//     var input, filter, table, tr, td, i;
//     input = document.getElementById("search");
//     filter = input.value.toUpperCase();
//     table = document.getElementById("myTable");
//     tr = table.getElementsByTagName("tr");
//
//     for (i = 0; i < tr.length; i++) {
//         td = tr[i].getElementsByTagName("td")[1];
//         if (td) {
//             if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
//                 tr[i].style.display = "";
//             } else {
//                 tr[i].style.display = "none";
//             }
//         }
//     }
// }

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

function searchInDiv() {

    $.ajax({
        url: '/searchItem?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchInList').val(),
        success: function (res)
        {
            var but = document.createElement("button");
            but.innerHTML = "Add to cart";
            but.class = "add-to-cart";
            but.style = "margin: auto; display: block;";
            var divItems= '';
            var add = 'Add to cart';
            for(var i in res)
            {
                divItems += '<div class="items"><div class="item"><img src="' + res[i].pathImage + '"><h2>' + res[i].name +
                    '<p style="float: right">' + '$' + '<em>' + res[i].price + '</em></p></h2>' + '</div></div>'
            }
            document.getElementById('searchDiv').innerHTML = divItems;
            console.log(res);
        }
    })
}