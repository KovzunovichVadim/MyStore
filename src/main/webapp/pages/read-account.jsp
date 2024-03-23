<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="http://localhost:8080" class="navbar-brand"> Home </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>"
                   class="nav-link">Accounts</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">Account</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/create" class="btn btn-success">Create Account</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <td>ID</td>
                <td>First name</td>
                <td>Last name</td>
                <td>Email</td>
                <td>Created</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><c:out value="${account.id}"/></td>
                <td><c:out value="${account.firstname}"/></td>
                <td><c:out value="${account.lastname}"/></td>
                <td><c:out value="${account.email}"/></td>
                <td><c:out value="${account.created}"/></td>
                <td><a href="update?id=${account.id}">Update</a> &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=${account.id}">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

