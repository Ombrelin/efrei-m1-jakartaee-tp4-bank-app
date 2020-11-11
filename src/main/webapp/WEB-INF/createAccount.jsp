<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 08/11/2020
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body>

<form method="post">

    <p>Please select an account type : </p>
    <input type="radio" id="current" name="accountType" value="current">
    <label for="current">Current account</label>
    <input type="radio" id="savings" name="accountType" value="savings">
    <label for="savings">Savings account</label>

    <br>
    <label for="overdraftRate">Overdraft or Rate</label>
    <input type="number" id="overdraftRate" name="overdraftRate" value="0">
    <br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
