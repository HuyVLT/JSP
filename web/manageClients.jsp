<%-- 
    Document   : manageClients
    Created on : Jul 4, 2024, 2:09:11 PM
    Author     : ninza
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Clients</title>
</head>
<body>
<h2>Manage Clients</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.clientID}</td>
            <td>${client.username}</td>
            <td>${client.email}</td>
            <td>${client.address}</td>
            <td>
                <form action="../clients" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="clientID" value="${client.clientID}">
                    <input type="submit" value="Delete">
                </form>
                <form action="clientForm.jsp" method="get">
                    <input type="hidden" name="clientID" value="${client.clientID}">
                    <input type="hidden" name="username" value="${client.username}">
                    <input type="hidden" name="email" value="${client.email}">
                    <input type="hidden" name="address" value="${client.address}">
                    <input type="submit" value="Edit">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="clientForm.jsp" method="get">
    <input type="submit" value="Add Client">
</form>
</body>
</html>
