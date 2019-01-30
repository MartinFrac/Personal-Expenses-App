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
                <div class="col-4">
                    <input type="text" class="form-control" id="inputDate" placeholder="Date" required>
                </div>
            </div>
        </form>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>