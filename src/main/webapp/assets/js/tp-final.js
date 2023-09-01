const colorList = ["silver","gray","white",
    "maroon","red","purple",
    "fuchsia","green","lime",
    "olive","yellow","navy",
    "blue","teal","aqua"];

document.addEventListener("DOMContentLoaded", function(){

    colorList.forEach((color) => {
        document.getElementById("menu").innerHTML +=
            "<div id='"+ color +"' onclick='changeColor(\"" + color + "\")' style='background-color: "+ color +"' class=\"list-button fw-bold text-black d-flex justify-content-center align-items-center w-100 rounded-3 p-1\">\n" +
            color +
            "</div>";
    })

});

const changeColor = (color) => {
    const divs = document.getElementById("body").children;

    for (let div of divs) {
        div.style.backgroundColor = color;
    }
}
