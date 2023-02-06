
<jsp:useBean id="user" scope="request" type="com.javamaster.application.dto.UsersDto"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
<a href="/users/read-users">Back to users</a>
<br/>
<h2>User Data:</h2>
<table style="width: 100%">
    <tr>
        <td><b>Name</b></td>
        <td><b>Email</b></td>
        <td><b>Username</b></td>
    </tr>
    <tr>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.login}</td>
    </tr>
</table>

<h2>User wallets:</h2>
<table style="width: 100%">
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>Amount</b></td>
    </tr>
    <c:forEach var="wallet" items="${wallets}">
        <tr>
            <td>${wallet.id}</td>
            <td>${wallet.name} (<a href="/wallets/update/${wallet.id}?userId=${user.id}">edit</a>)</td>
            <td>${wallet.amount}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/transactions/create-income-transaction/${user.id}">Create Income Transaction</a>
<br/>
<a href="/transactions/create-expense-transaction/${user.id}">Create Expense Transaction</a>
</body>