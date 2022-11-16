<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/16/2022
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container mt-3">
    <a type="button" class="btn btn-info" href="create.jsp">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Img</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="pr">
            <tr class="table-warning">
                <td>${pr.getId()}</td>
                <td>${pr.name}</td>
                <td><img src="${pr.img}" width="200px" height="200px"></td>
                <td>${pr.price}</td>
                <td><a type="button" class="btn btn-warning" href="/edit?id=${pr.id}">Edit</a></td>
                <td><a type="button" class="btn btn-danger" href="/delete?id=${pr.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body></html>
