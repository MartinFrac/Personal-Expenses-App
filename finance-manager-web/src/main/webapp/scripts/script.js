'use strict';

$(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});
$(function () {
    let date = new Date();
    $('#datepicker').datepicker({
        format: "yyyy/mm/dd",
        todayHighlight: true,
        showOtherMonths: true,
        selectOtherMonths: true,
        autoclose: true,
        changeMonth: true,
        changeYear: true,
        orientation: "button"
    }).datepicker("setDate", date);
    document.getElementById('inputDate').value = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
});