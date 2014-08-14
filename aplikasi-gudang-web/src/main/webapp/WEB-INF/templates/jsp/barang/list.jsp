<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Barang</title>
    </head>
    <body>
        <h1>Daftar Barang</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Keterangan</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="daftarBarang" var="x">
                <tr>
                    <td>${x.kode}</td>
                    <td>${x.nama}</td>
                    <td>${x.keterangan}</td>
                    <td>
                        <a href="form?id=${x.id}">edit</a> | 
                        <a href="hapus?id=${x.id}">hapus</a>  
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
