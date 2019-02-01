<!DOCTYPE html>
<html lang="eng">
<head>
    <title>Welcome our new Finance Manager</title>
    <#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar  -->
    <#include "static/sidebar.ftlh">

    <div id="content">

        <#include "static/navbar.ftlh">

        <form>
            <div class="form-group row">
                <label for="inputName" class="col-sm-2 col-form-label">Name</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="inputName" placeholder="Name" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputComment" class="col-sm-2 col-form-label">Comment</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="inputComment" placeholder="Comment" aria-describedby="commentHelp">
                    <small id="commentHelp" class="form-text text-muted">Comment is optional</small>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputAmount" class="col-sm-2 col-form-label">Amount</label>
                <div class="input-group col-4">
                    <input type="number" class="form-control" id="inputAmount" placeholder="Amount" min="0.00" step="1.00" value="100.00" required>
                    <div class="input-group-append">
                        <span class="input-group-text">PLN</span>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputDate" class="col-sm-2 col-form-label">Date</label>
                <div class="input-group date col-4" id="datepicker">
                    <input type="text" id="inputDate" class="form-control"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <#list categories as c>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        ${c.name}
                    </label>
                </div>
            </#list>
            <!--
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" disabled>
                <label class="form-check-label" for="defaultCheck2">
                    Disabled checkbox
                </label>
            </div>
            -->
        </form>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>