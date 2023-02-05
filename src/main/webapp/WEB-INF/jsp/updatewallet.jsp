
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="/users/show/${userId}">Back to user</a>
<br/>
<h1>Update Wallet Name</h1>
<%--@elvariable id="wallet" type="com.javamaster.application.dto.WalletDto"--%>
<form:form method="post" modelAttribute="wallet" action="/wallets/update/${wallet.id}">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
        </tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>