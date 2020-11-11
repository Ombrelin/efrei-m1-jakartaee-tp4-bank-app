<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 09/11/2020
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Account</title>
</head>
<body>

Account Number : <j:out value="${account.accountNumber}">Account Number</j:out><br>
Account Type: <j:out value="${account.type}">Account Type</j:out><br>
Account Balance: <j:out value="${account.balance}">Account Balance</j:out><br>
<br><br>
Operations :
<br>
<table>
    <thead>
    <tr>
        <th>Operation Number</th>
        <th>Operation Type</th>
        <th>Operation Amount</th>
        <th>Operation Date</th>
    </tr>
    </thead>
    <tbody>
    <j:forEach items="${account.operations}" var="operation">
        <tr>
            <td><j:out value="${operation.numero}">Operation Number</j:out></td>
            <td><j:out value="${operation.type}">Operation Type</j:out></td>
            <td><j:out value="${operation.amount}">Operation Amount</j:out></td>
            <td><j:out value="${operation.date}">Operation Date</j:out></td>
        </tr>
    </j:forEach>
    </tbody>
</table>


</body>
</html>
