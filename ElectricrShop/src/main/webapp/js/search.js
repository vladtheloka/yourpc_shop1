/**
 * Created by admin on 08.07.2017.
 */
/*function search() {
    $.ajax({
        url: '/searchCommodity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res) {
            var items = '';
            for (var i in res) {
                items += '<tr><td>' + res[i].maker.name + '</td><td><img src="' + res[i].image + '"></td><td>' + res[i].categories.name + '</td><td>' + res[i].model + '</td><td>' + res[i].price + '</td></tr>'
                console.log(items);
            }
            document.getElementById('searchResult').innerHTML = items;

        }
    })
}*/
function search() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("searchIn");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
