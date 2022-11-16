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
<div align="center">
    <form action="/create">
        <table>
            <tr>
                <td>Nhập id</td>
                <td><input name="id" placeholder="Nhập id"></td>
            </tr>
            <tr>
                <td>Nhập tên</td>
                <td><input name="name" placeholder="Nhập tên"></td>
            </tr>
            <tr>
                <td>Nhập đường dẫn ảnh</td>
                <td><input name="img" placeholder="Nhập đường dẫn ảnh"></td>
            </tr>
            <tr>
                <td>Nhập Giá</td>
                <td><input name="price" placeholder="Nhập Giá"></td>
            </tr>

        </table>
        <button type="submit"  class="btn btn-success">Submit</button>
    </form>
</div>
</body>
</html>
