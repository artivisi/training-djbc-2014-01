package id.go.customs.training.gudang.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

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
            exportJson(data, req, resp);
            return;
        }
        
        if("pdf".equalsIgnoreCase(format.trim())){
            exportPdfXls("pdf", data,req, resp);
            return;
        }
        
        if("xls".equalsIgnoreCase(format.trim())){
            exportPdfXls("xls", data,req, resp);
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
    
    private void exportJson(List<Barang> data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(data);
        resp.getWriter().println(output);
        resp.getWriter().flush();
    }
    
    private void exportPdfXls(String format, List<Barang> data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // 1. Load dan compile template JRXML
            JasperReport reportTemplate = JasperCompileManager
                    .compileReport(req.getServletContext().getRealPath("/WEB-INF/templates/jrxml/barang.jrxml"));
            
            // 2. Merge template + data (print)
            JasperPrint report = JasperFillManager
                    .fillReport(reportTemplate, 
                            new HashMap<String, Object>(), new JRBeanCollectionDataSource(data));
            
            // 3. Kirim ke client
            if("pdf".equalsIgnoreCase(format)){
                resp.setContentType("application/pdf");
                JasperExportManager.exportReportToPdfStream(report, resp.getOutputStream());
            } else {
                resp.setContentType("application/vnd.ms-excel");
                JRXlsExporter exporter = new JRXlsExporter();
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(resp.getOutputStream()));
                exporter.exportReport();
            }
            
        } catch (JRException ex) {
            Logger.getLogger(BarangDownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}