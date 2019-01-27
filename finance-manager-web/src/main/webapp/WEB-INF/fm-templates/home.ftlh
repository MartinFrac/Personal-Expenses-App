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

        <#list expenses>
            <h2>Expenses</h2>
            <table class="table table-hover table-fixed">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Categories</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Comment</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#items as e>
                        <tr>
                            <td>${e.name}</td>
                            <td>${e.categories}</td>
                            <td>${e.date}</td>
                            <td>${e.amount}</td>
                            <td>${e.comment}</td>
                            <td>
                                <form method="post" action="/home">
                                    <button type="button" name="edit" value="edit" class="btn btn-primary btn-sm">Edit</button>&nbsp;
                                    <button type="button" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </#items>
                </tbody>
            </table>
            <#else>
            <h1>No expenses found</h1>
        </#list>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>