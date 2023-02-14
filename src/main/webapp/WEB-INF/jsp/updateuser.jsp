
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="/users/read-users">Back to users</a>
<br/>
<h1>Update User</h1>
<%--@elvariable id="user" type="com.javamaster.application.dto.UsersDto"--%>
<form:form method="post" modelAttribute="user" action="/users/update/${id}">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Login: </td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>