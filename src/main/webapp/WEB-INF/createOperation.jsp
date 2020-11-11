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

    <br>
    <label for="acountId">Account Id : </label><br>
    <input type="number" id="acountId" name="acountId">
    <br>

    <p>Please select an operation type : </p>
    <input type="radio" id="payment" name="operationType" value="payment">
    <label for="payment">Payment</label>
    <input type="radio" id="withdrawal" name="operationType" value="withdrawal">
    <label for="withdrawal">Withdrawal</label>

    <br>
    <label for="amount">Amount</label><br>
    <input type="number" id="amount" name="amount" value="0">
    <br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
