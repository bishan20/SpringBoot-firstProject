<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
    <div class="container-fluid">
        <div class="row">

                <a href="/home">Home</a>|
                <a href="/login">LogIn</a>|


        </div>

    </div>

</nav>
<h1 class="text text-primary">Welcome to home page</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <table class="table table-striped table-light table-bordered table-hover">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Roll</th>
                </tr>
                <c:forEach items="${DATA}" var="obj">
                    <tr>
                        <td>${obj.name}</td>
                        <td>${obj.email}</td>
                        <td>${obj.roll}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>