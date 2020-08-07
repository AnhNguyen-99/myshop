var category = {};

$(document).ready(function(){

    /** OnClick **/
    $("#addCategory").submit(function (e) {
        e.preventDefault();
        category.addCategory();
    });

    /** Functions **/
    // API URL: http://localhost:7070/api/v1/role
    category.addCategory = function(){

        var jsonData = {
            "categoryName": $("categoryName").val()
        };
        console.log("jsonData" , jsonData);
        $.ajax({
            url : "http://localhost:8080/MyShop/api/category",
            type: "POST",
            data: JSON.stringify(jsonData),
            beforeSend: function(xhr){
                xhr.setRequestHeader("Accept" , "application/json");
                xhr.setRequestHeader("Content-Type" , "application/json");
            },
            success: function(data){
                console.log(data);
                alert(data.message);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Error: " + textStatus + " - " + errorThrown);
            }
        })
    }

});
