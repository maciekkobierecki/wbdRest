var content=$("#content")[0];
var serverIP="192.168.1.7";

var doOrderButton=$("#doOrder")[0];
doOrderButton.addEventListener("click", function(){ doOrder(); });

document.addEventListener("DOMContentLoaded", function(){
    fetchProductsInTrolley();
});

function addToTrolley(id, price)
{
    console.log('addtotrolley');
    var toAdd=$("<div class='product'>")
    .append("<div class='image'><img src='image.jpg'></div>")
    .append("<div class='id'>"+id+"</div>")
    .append("<div class='price>"+price+"</div>")
    .append("<div class='delete'><img src='delete.png'></div>")
    $("#content").append(toAdd);
}

function fetchProductsInTrolley(){
    console.log("fetchProductsInTrolley")
    $(document).ready(function() {
        $.ajax({
            url: "http://"+serverIP+":8081/wbd/api/getTrolley",
            dataType: "json"
        }).then(function(data) {
           $.each(data, function(key, value){
               var product=createProduct(value.product_id, value.product_price, value.product_description);
        	   appendProduct(product[0]);
           });
           
        });
    }); 
}

function appendProduct(product)
{
    content.append(product);
}


function createProduct(id, price, description)
{
    //image
    var $image=$("<div />")
    .addClass("image")
    .html("<img src='image.jpg'>");
    //id
    var $id=$("<div />")
    .addClass("id")
    .html(id);
    //price
    var $price=$("<div />")
    .addClass("price")
    .html(price);
    var $trolley=$("<div />")
    .addClass("addToTrolley")
    .html("<img src='add.png'>");
    var $description=$("<div />")
    .addClass("product_description")
    .html(description);
    var $newProduct= $("<div />")
    .addClass("product")
    .append($image)
    .append($id)
    .append($description)
    .append($price);
    
    return $newProduct;
    
}


function doOrder(){
    console.log("doOrder")
    $(document).ready(function() {
        $.ajax({
            url: "http://"+serverIP+":8081/wbd/api/doOrder"
        }).then(function(data) {
            console.log(data);   
            $("#content").empty();       
        });
    }); 
}