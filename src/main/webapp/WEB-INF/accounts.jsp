<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 08/11/2020
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<html>
<head>
    <title>Accounts</title>
</head>
<body>

<j:forEach items="${accounts}" var="account">
    test
    <j:out value="${account.accountNumber}">Account Number</j:out>
    <j:out value="${account.balance}">Account Balance</j:out>
</j:forEach>
</body>
</html>
