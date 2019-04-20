(function () {
    var categoryContainer1 = document.getElementById("categoryContainer1");
    var categoryContainer2 = document.getElementById("categoryContainer2");
    var categoryContainer3 = document.getElementById("categoryContainer3");
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/resources/categories');
    ourRequest.onload = function() {
        var ourData = JSON.parse(ourRequest.responseText);
        var htmlString1 = "";
        var htmlString2 = "";
        var htmlString3 = "";
        var counter1 = 0;
        var counter2 = 1;
        var counter3 = 2;
        for(var i = 0; i < ourData.length; i++) {
            var stringHelper = "<label class='containerCategory'>" + ourData[i].name +
                                "<input type='checkbox' name='categories' value=" + ourData[i].name + ">" +
                                "<span class='checkmark'></span>" +
                                "</label>";
            if(counter1 === i) {
                htmlString1 += stringHelper;
            } else if (counter2 === i) {
                htmlString2 += stringHelper;
            } else if (counter3 === i) {
                htmlString3 += stringHelper;
            }
            if((i+1)%3 === 0) {
                counter1 += 3;
                counter2 += 3;
                counter3 += 3;
            }
        }

        categoryContainer1.insertAdjacentHTML('beforeend', htmlString1);
        categoryContainer2.insertAdjacentHTML('beforeend', htmlString2);
        categoryContainer3.insertAdjacentHTML('beforeend', htmlString3);
    };
    ourRequest.send();
})();