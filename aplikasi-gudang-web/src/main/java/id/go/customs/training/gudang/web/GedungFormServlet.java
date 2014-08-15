package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class GedungFormServlet extends HttpServlet {

    private GedungDao bd = new GedungDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        
        if(id != null && !id.isEmpty()){
            Integer idGedung = Integer.parseInt(id);
            Gedung b = bd.cariById(idGedung);
            if(b != null){
                req.setAttribute("gedung", b);
            }
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/gedung/form.jsp")
                .forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gedung b = new Gedung();
        String id = req.getParameter("id");
        if(id != null && !id.isEmpty()){
            b.setId(Integer.parseInt(id));
        }
        b.setKode(req.getParameter("kode"));
        b.setNama(req.getParameter("nama"));
        b.setAlamat(req.getParameter("alamat"));
        b.setKeterangan(req.getParameter("keterangan"));
        
        bd.simpan(b);
        resp.sendRedirect("list");
    }
    
}