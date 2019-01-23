<!DOCTYPE html>
<html>
<head>
    <title>Welcome our new Finance Manager</title>
<#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><a href="home">Finance Manager</a></h3>
            <strong>FM</strong>
        </div>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-home"></i>
                    Account
                </a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="home">Admin</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="add-expense">
                    <i class="fas fa-briefcase"></i>
                    Expenses
                </a>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Categories
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="add-category">Add</a>
                    </li>
                    <li>
                        <a href="edit-category">Edit</a>
                    </li>
                    <li>
                        <a href="delete-category">Delete</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="about">
                    <i class="fas fa-question"></i>
                    About Us
                </a>
            </li>
            <li>
                <a href="">
                    <i class="fas fa-paper-plane"></i>
                    Contact
                </a>
            </li>
        </ul>
    </nav>
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
                                <button type="button" class="btn btn-primary btn-sm">Edit</button>&nbsp;
                                <button type="button" class="btn btn-danger btn-sm">Delete</button>
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