(function () {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/resources/categories');
    ourRequest.onload = function() {
        var ourData = JSON.parse(ourRequest.responseText);
        console.log(ourData[0]);
    };
    ourRequest.send();
})();