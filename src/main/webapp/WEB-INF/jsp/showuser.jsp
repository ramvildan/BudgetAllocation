<jsp:useBean id="user" scope="request" type="com.javamaster.application.dto.UsersDto"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
<h2>User Data:</h2>
<table style="width: 100%">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Username</td>
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
        <td>Name</td>
        <td>Amount</td>
    </tr>
    <c:forEach var="wallet" items="${wallets}">
        <tr>
            <td>${wallet.name}</td>
            <td>${wallet.amount}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/transactions/create-transaction/${user.id}">Create transaction</a>
<br/>
<a href="/users/read-users">Back to users</a>
</body>

<style>
    table, th, td{
        border: 1px solid black;
    }
</style>