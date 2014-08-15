/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author endy
 */
public class BarangUploadServlet extends HttpServlet {

    private final String lokasiPenyimpanan = "/upload";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/jsp/barang/upload.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean adaFile = ServletFileUpload.isMultipartContent(req);
        if(adaFile){
            try {
                String lokasiLengkap = req.getServletContext().getRealPath(lokasiPenyimpanan);
                System.out.println("Lokasi hasil upload : "+lokasiLengkap);
                
                // inisialisasi prosesor upload
                DiskFileItemFactory factory = new DiskFileItemFactory();
                File lokasiSementaraHasilUpload 
                        = (File) req.getServletContext()
                                .getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(lokasiSementaraHasilUpload);
                System.out.println("Lokasi upload sementara : "
                        +lokasiSementaraHasilUpload.getAbsolutePath());
                ServletFileUpload prosesorUpload = new ServletFileUpload(factory);
                
                List<FileItem> hasilUpload = prosesorUpload.parseRequest(req);
                System.out.println("Jumlah file = "+hasilUpload.size());
                
                for (FileItem fileItem : hasilUpload) {
                    System.out.println("----- Informasi File -----");
                    System.out.println("Tipe File : "+fileItem.getContentType());
                    System.out.println("Nama Field : "+fileItem.getFieldName());
                    System.out.println("Nama File : "+fileItem.getName());
                    System.out.println("Ukuran File : "+fileItem.getSize());
                    
                    String fileTujuan = lokasiLengkap + File.separator + fileItem.getName();
                    fileItem.write(new File(fileTujuan));
                    System.out.println("Hasil upload ada di "+fileTujuan);
                }
            } catch (Exception ex) {
                Logger.getLogger(BarangUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // selesai upload, arahkan user ke list barang
        resp.sendRedirect("list");
    }
    
}