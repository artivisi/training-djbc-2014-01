package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class BarangFormServlet extends HttpServlet {

    private BarangDao bd = new BarangDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        
        if(id != null && !id.isEmpty()){
            Integer idBarang = Integer.parseInt(id);
            Barang b = bd.cariById(idBarang);
            if(b != null){
                req.setAttribute("barang", b);
            }
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/barang/form.jsp")
                .forward(req, resp);
        
    }
    
}