<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <tr>
                    <td>B-001</td>
                    <td>Barang 001</td>
                    <td>Barang No 001</td>
                    <td>
                        <a href="form?id=">edit</a> | 
                        <a href="hapus?id=">hapus</a>  
                    </td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
