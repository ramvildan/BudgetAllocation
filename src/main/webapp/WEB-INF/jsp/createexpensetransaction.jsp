
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="/users/show/${userId}">Back to user</a>
<br/>
<h1>Create Expense Transaction</h1>

<%--@elvariable id="transaction" type="com.javamaster.application.dto.TransactionsDto"--%>
<form:form method="post" modelAttribute="transaction" action="/transactions/create-expense-transaction/${userId}">
    <table>
        <tr>
            <td>Transaction:</td>
            <td><form:input path="amount"/></td>
        </tr>

        <tr>
            <td>Select wallet: </td>
            <td>
                <form:select path="walletId" multiple="true" id="walletSelector" class="form-control">
                    <form:options items="${walletsList}" itemLabel="name" itemValue="id"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>