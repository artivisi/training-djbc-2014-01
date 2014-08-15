package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BarangDownloadServlet extends HttpServlet {

    private final BarangDao bd = new BarangDao();
    private final SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String format = req.getParameter("format");
        if(format == null | format.isEmpty()){
            format = "csv";
        }
        
        List<Barang> data = bd.semuaBarang();
        
        if("csv".equalsIgnoreCase(format.trim())){
            exportCsv(data,req, resp);
            return;
        }
        
        if("json".equalsIgnoreCase(format.trim())){
            exportJson(req, resp);
            return;
        }
        
        if("pdf".equalsIgnoreCase(format.trim())){
            exportPdf(req, resp);
            return;
        }
        
        if("xls".equalsIgnoreCase(format.trim())){
            exportXls(req, resp);
            return;
        }
        
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        String output = "<html>\n";
        output += "\t<head><title>Download Data Barang</title></head>\n";
        output += "\t<body>\n";
        output += "\t\t<b>Format "+format+"</b> tidak tersedia\n";
        output += "\t</body>\n";
        output += "</html>";
        resp.getWriter().println(output);
        resp.getWriter().flush();
    }

    private void exportCsv(List<Barang> data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/csv");
        resp.getWriter().println("id,kode,nama,keterangan,tanggalProduksi,harga");
        for (Barang barang : data) {
            resp.getWriter().print(barang.getId());
            resp.getWriter().print(",");
            resp.getWriter().print(barang.getKode());
            resp.getWriter().print(",");
            resp.getWriter().print(barang.getNama());
            resp.getWriter().print(",");
            resp.getWriter().print(barang.getKeterangan());
            resp.getWriter().print(",");
            resp.getWriter().print(formatterTanggal.format(barang.getTanggalProduksi()));
            resp.getWriter().print(",");
            resp.getWriter().println(barang.getHarga());
        }
        resp.getWriter().flush();
    }
    
    private void exportJson(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
    }
    
    private void exportPdf(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/pdf");
    }
    
    private void exportXls(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/vnd.ms-excel");
    }
}