<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vendor</title>
    </head>
    <body>
        <h1>List vendor</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                    <th>Produk</th>
                </tr>
            </thead>
            <tbody>
                   <c:forEach items="${daftarVendor}" var="x">
                <tr>
                 
                    <td>${x.id}</td>
                    <td>${x.nama}</td>
                    <td>${x.alamat}</td>
                    <td>${x.produk}</td>
                </tr>
                   </c:forEach>
            </tbody>
        </table>

    </body>
</html>
