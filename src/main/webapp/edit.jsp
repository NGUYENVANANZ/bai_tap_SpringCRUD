<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div align="center">
    <form action="/editsp" method="post" >
        <h1>Edit Products</h1>
        <table>
            <tr>
                <td>Nhập id</td>
                <td><input name="id" placeholder="Nhập id" value="${product.id}" readonly></td>
            </tr>
            <tr>
                <td>Nhập tên</td>
                <td><input name="name" placeholder="Nhập tên" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Nhập đường dẫn ảnh</td>
                <td><input name="img" placeholder="Nhập đường dẫn ảnh" value="${product.img}"></td>
            </tr>
            <tr>
                <td>Nhập Giá</td>
                <td><input name="price" placeholder="Nhập Giá" value="${product.price}"></td>
            </tr>

        </table>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>