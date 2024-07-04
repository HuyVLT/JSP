<%-- 
    Document   : clientForm
    Created on : Jul 4, 2024, 2:09:42 PM
    Author     : ninza
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Form</title>
</head>
<body>
<h2>${param.clientID != null ? 'Edit' : 'Add'} Client</h2>
<form action="../clients" method="post">
    <input type="hidden" name="clientID" value="${param.clientID}">
    <input type="hidden" name="action" value="${param.clientID != null ? 'update' : 'add'}">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${param.username}" required>
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${param.email}" required>
    <br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${param.address}" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

