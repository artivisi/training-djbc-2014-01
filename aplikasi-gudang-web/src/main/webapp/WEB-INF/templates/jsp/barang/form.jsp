<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Barang</title>
    </head>
    <body>
        <h1>Edit Barang</h1>
        
        <form method="post">
            <input type="hidden" name="id" value="${barang.id}">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input type="text" name="kode" value="${barang.kode}">
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input type="text" name="nama" value="${barang.nama}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Keterangan
                        </td>
                        <td>
                            <input type="text" name="keterangan" value="${barang.keterangan}">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="Simpan">
                            <input type="reset" value="Reset">
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
