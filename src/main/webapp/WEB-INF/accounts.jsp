<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 08/11/2020
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>


<table>
    <thead>
        <tr>
            <th>Account Number</th>
            <th>Account Type</th>
            <th>Account Balance</th>
        </tr>
    </thead>
    <tbody>
        <j:forEach items="${accounts}" var="account">
            <tr>
                <td><j:out value="${account.accountNumber}">Account Number</j:out></td>
                <td><j:out value="${account.type}">Account Type</j:out></td>
                <td><j:out value="${account.balance}">Account Balance</j:out></td>
            </tr>
        </j:forEach>
    </tbody>
</table>


</body>
</html>
