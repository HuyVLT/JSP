<%-- 
    Document   : manageProducts
    Created on : Jul 4, 2024, 2:12:00 PM
    Author     : ninza
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Products</title>
</head>
<body>
<h2>Manage Products</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <form action="../products" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="productID" value="${product.productID}">
                    <input type="submit" value="Delete">
                </form>
                <form action="productForm.jsp" method="get">
                    <input type="hidden" name="productID" value="${product.productID}">
                    <input type="hidden" name="name" value="${product.name}">
                    <input type="hidden" name="price" value="${product.price}">
                    <input type="hidden" name="description" value="${product.description}">
                    <input type="submit" value="Edit">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="productForm.jsp" method="get">
    <input type="submit" value="Add Product">
</form>
</body>
</html>
