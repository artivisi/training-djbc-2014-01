<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Gedung</title>
    </head>
    <body>
        <h1>Edit Gedung</h1>
        
        <form method="post">
            <input type="hidden" name="id" value="${gedung.id}">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input type="text" name="kode" value="${gedung.kode}">
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input type="text" name="nama" value="${gedung.nama}">
                        </td>
                    </tr>
                    <tr>
                        <td>Alamat</td>
                        <td>
                            <input type="text" name="nama" value="${gedung.alamat}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Keterangan
                        </td>
                        <td>
                            <input type="text" name="keterangan" value="${gedung.keterangan}">
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
