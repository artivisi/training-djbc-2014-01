<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hasil Import Data Barang</title>
    </head>
    <body>
        <h1>Hasil Import Data Barang</h1>
        
        <h2>${hasil.suksesImport.size()} data berhasil diimport</h2>
        <h2>${hasil.gagalImport.size()} data gagal diimport</h2>
        
        <c:if test="${hasil.gagalImport.size() > 0}">
            <h3>Detail error</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>Baris</th>
                        <th>Keterangan</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${hasil.gagalImport}" var="x">
                    <tr>
                        <td>${x.baris}</td>
                        <td>${x.keterangan}</td>
                        <td>${x.data}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        
    </body>
</html>
