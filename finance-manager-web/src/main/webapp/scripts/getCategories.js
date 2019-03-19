(function () {
    var categoryContainer = document.getElementById("categoryContainer");
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/resources/categories');
    ourRequest.onload = function() {
        var ourData = JSON.parse(ourRequest.responseText);
        var htmlString = "";
        for(var i = 0; i< ourData.length; i++) {
            htmlString +=
                "<label class='containerCategory'>" + ourData[i].name +
                    "<input type='checkbox'>" +
                    "<span class='checkmark'></span>" +
                "</label>";
        }

        categoryContainer.insertAdjacentHTML('beforeend', htmlString);
    };
    ourRequest.send();
})();