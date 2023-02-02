<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Users Wallets</h1>
    <c:forEach var="user" items="${users}">
<h2>User: ${user.name}</h2>
<h2>Wallets table:</h2>
    </c:forEach>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
<table style="width:100%">
    <tr>
        <th>General</th>
        <th>Investments</th>
        <th>Treatment</th>
        <th>Debts and gifts</th>
        <th>Entertainment</th>
        <th>Long term costs</th>
    </tr>
    <c:forEach var="wallet" items="${wallet}">
        <tr>
            <td>${wallet.name}</td>
            <td>${wallet.name}</td>
            <td>${wallet.name}</td>
            <td>${wallet.name}</td>
            <td>${wallet.name}</td>
            <td>${wallet.name}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/users/read-users">Back to users</a>
</body>