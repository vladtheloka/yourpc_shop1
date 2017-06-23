$('#saveCategory').click(function () {

    var category = {
        name: $('#categoryName').val()
    };

    $('#categoryName').val('');

    $.ajax({

        url: '/category?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(category),
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })
});


loadCategories();

function deleteCategory(categoryId) {

    $.ajax({

        url: '/category?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(categoryId),
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })

}

function loadCategories() {
    $.ajax({

        url: '/category?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })

}


function updateCategory(categoryId) {

    $.ajax({

        url: '/category?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function saveCategoryUpdates(categoryId) {

    var newName = $('#categoryName').val();

    $.ajax({

        url: '/category?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'PUT',
        data: newName+'_'+categoryId,
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })

}

function parseResultFromDb(res) {
    var categoriesFromDb = '';

    for (var i in res) {
        categoriesFromDb += '<tr><td id=' + res[i].id + "category" + '>' + res[i].name + '</td><td><button class="btn btn-default updateCategory '+res[i].id+'" onclick="updateCategory(' + res[i].id + ')">Update</button></td><td><button class="btn btn-default" id="deleteCategory" onclick="deleteCategory(' + res[i].id + ')">Delete</button></td></tr>';
    }

    document.getElementById('result').innerHTML = categoriesFromDb;

}