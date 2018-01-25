var categories=$("#sidebar")[0];
var content=$("#content")[0];

var serverIP="192.168.1.7";

document.addEventListener("DOMContentLoaded", function(){
    fetchProducts("any");
    fetchCategories();
    $("#content").resize();
});

$(window).on('load', function () {
    resizeDivs();
  });

function fetchCategories()
{
    $(document).ready(function() {
        $.ajax({
            url: "http://"+serverIP+":8081/wbd/api/getCategories",
            dataType: "json"
        }).then(function(data) {
           $.each(data, function(key, value){
               var category=createCategory(value.category_name, value.category_count);
               category.click(function(){
                   fetchProducts($(this).category_name);
               });
        	   categories.append(category[0]);
           });
           
        });
    }); 
}

function createCategory(name, count)
{
    console.log("creating category");
    var $newDiv = $("<div/>")   // creates a div element
                 .attr("id", "someID")  // adds the id
                 .addClass("optionL")   // add a class
                 .html("<div class='category_name'>name</div><div class='category_count'>("+count +")</div>");
    return $newDiv;
}

function fetchProducts(category)
{
    console.log("fetchProducts:"+category)
    $(document).ready(function() {
        $.ajax({
            url: "http://"+serverIP+":8081/wbd/api/getProducts?category="+category,
            dataType: "json"
        }).then(function(data) {
           $.each(data, function(key, value){
        	   var product=createProduct(value.product_name, value.product_price, value.product_description);
        	   appendProduct(product[0]);
           });
           
        });
    }); 
}

function resizeDivs() {
    var content = $('#content').height();
    console.log(content);
    var sidebar = $('#sidebar').height();
    console.log(sidebar);

    if(content>sidebar)
    {
        $("#sidebar").height(content);
    }
    else
    {
        $("#content").height(sidebar);
    }
   
}

function createProduct(name, price, description)
{
    //image
    var $image=$("<div />")
    .addClass("image")
    .html("<img src='image.jpg'>");
    //name
    var $name=$("<div />")
    .addClass("name")
    .html(name);
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
    var $delete=$("<div />")
    .addClass("delete");
    var $newProduct= $("<div />")
    .addClass("product")
    .append($image)
    .append($name)
    .append($description)
    .append($delete)
    .append($trolley)
    .append($price);
    
    return $newProduct;
    
}

function appendProduct(product)
{
    content.append(product);
}



//metody testowe

//testowa
function addCategory(name, count)
{
    categories.append(createCategory(name, count));
}

function addProduct(name, price, description)
{
    var newProduct=createProduct(name, price,description);
    appendProduct(newProduct[0]);
}