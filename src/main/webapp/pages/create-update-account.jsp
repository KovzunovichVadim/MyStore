<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account Management</title>
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

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${account != null}">
            <form action="save" method="post">
                </c:if>
                <c:if test="${account == null}">
                <form action="create" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${account != null}">
                                Update Account
                            </c:if>
                            <c:if test="${account == null}">
                                Create Account
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${account != null}">
                    <input type="hidden" name="id" value="<c:out value='${account.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>First Name</label> <input type="text"
                                                         value="<c:out value="${account.firstname}" />"
                                                         class="form-control" name="firstname" resource="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Last Name</label> <input type="text"
                                                         value="<c:out value="${account.lastname}" />"
                                                         class="form-control" name="lastname" resource="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label> <input type="text"
                                                         value="<c:out value="${account.email}" />"
                                                         class="form-control" name="email" resource="required">
                    </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
