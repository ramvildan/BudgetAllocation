
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="/users/show/${userId}">Back to user</a>
<br/>
<h1>Create Income Transaction</h1>
<%--@elvariable id="transaction" type="com.javamaster.application.dto.TransactionsDto"--%>
<form:form method="post" modelAttribute="transaction" action="/transactions/create-income-transaction/${userId}">
    <table>
        <tr>
            <td>Transaction: </td>
            <td><form:input path="amount"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>