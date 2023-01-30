<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Read Users</h1>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
<table style="width:100%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td><a href="/users/update/${user.id}">Update</a> </td>
            <td><a href="/users/delete/${user.id}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/users/save-user">Create Users</a>
</body>