<%-- 
    Document   : productForm
    Created on : Jul 4, 2024, 2:12:44 PM
    Author     : ninza
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
<h2>${param.productID != null ? 'Edit' : 'Add'} Product</h2>

    <input type="hidden" name="productID" value="${param.productID}">
    <input type="hidden" name="action" value="${param.productID != null ? 'update' : 'add'}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${param.name}" required>
    <br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" value="${param.price}" required>
    <br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required>${param.description}</textarea>
    <br>
    <input type="submit" value="Submit">

</body>
</html>
