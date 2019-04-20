'use strict';

let globalCategories;

$(function () {
    let categoryContainer1 = document.getElementById("categoryContainer1");
    let categoryContainer2 = document.getElementById("categoryContainer2");
    let categoryContainer3 = document.getElementById("categoryContainer3");
    let ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/resources/categories');
    ourRequest.onload = function() {

        let ourData = JSON.parse(ourRequest.responseText);
        globalCategories = ourData;
        let htmlString1 = "";
        let htmlString2 = "";
        let htmlString3 = "";
        let counter1 = 0;
        let counter2 = 1;
        let counter3 = 2;

        for(let i = 0; i < ourData.length; i++) {
            let stringHelper = `<label class="containerCategory" id="cat${ourData[i].id}">${ourData[i].name}` +
                                `<input type="checkbox" name="categories" value="${ourData[i].name}">` +
                                `<span class="checkmark"></span>` +
                                `</label>`;
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
});

$('#inputAmount').on('input', function () {

    let amount = parseInt($('#inputAmount').val());
    let total;
    let limit;
    for(let i = 0; i<globalCategories.length; i++) {
        total = globalCategories[i].total;
        limit = globalCategories[i].limit;
        if (total + amount > limit) {
            $(`#cat${globalCategories[i].id}`)
                .children('input').prop('disabled', true).prop('checked', false).end()
                .children('span').addClass('checkmarkDisabled');
        } else {
            $(`#cat${globalCategories[i].id}`)
                .children('input').prop('disabled', false).end()
                .children('span').removeClass('checkmarkDisabled');
        }
    }
});

function f() {
    let amount = parseInt($('#inputAmount').val());
    let total;
    let limit;
    for (let i = 0; i < globalCategories.length; i++) {
        total = globalCategories[i].total;
        limit = globalCategories[i].limit;
        if (total + amount > limit) {
            $(`#cat${globalCategories[i].id}`)
                .children('input').prop('disabled', true).prop('checked', false).end()
                .children('span').addClass('checkmarkDisabled');
        } else {
            $(`#cat${globalCategories[i].id}`)
                .children('input').prop('disabled', false).end()
                .children('span').removeClass('checkmarkDisabled');
        }
    }
}

setTimeout(f, 1000);