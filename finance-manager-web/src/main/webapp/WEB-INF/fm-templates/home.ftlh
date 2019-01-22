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
                    Konto
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
                    Wydatki
                </a>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Kategorie
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="add-category">Dodaj</a>
                    </li>
                    <li>
                        <a href="edit-category">Edytuj</a>
                    </li>
                    <li>
                        <a href="delete-category">Usuń</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="about">
                    <i class="fas fa-question"></i>
                    O nas
                </a>
            </li>
            <li>
                <a href="">
                    <i class="fas fa-paper-plane"></i>
                    Kontakt
                </a>
            </li>
        </ul>
    </nav>
    <div id="content">

        <#include "static/navbar.ftlh">

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
                <tr>
                    <th scope="row">4</th>
                    <td>Jerry</td>
                    <td>Horwitz</td>
                    <td>Italy</td>
                    <td>5</td>
                    <td>Editor-in-chief</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">Edytuj</button>&nbsp;
                        <button type="button" class="btn btn-danger btn-sm">Usuń</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>