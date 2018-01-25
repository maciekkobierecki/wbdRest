

var doOrderButton=$("#doOrder")[0];
doOrderButton.addEventListener("click", function(){ addToTrolley(); });

function addToTrolley(name, price)
{
    console.log('addtotrolley');
    var toAdd=$("<div class='product'>")
    .append("<div class='image'><img src='image.jpg'></div>")
    .append("<div class='name'>"+name+"</div>")
    .append("<div class='price>"+price+"</div>")
    .append("<div class='delete'><img src='delete.png'></div>")
    $("#content").append(toAdd);
}