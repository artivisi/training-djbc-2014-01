/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class BarangListServlet extends HttpServlet {

    private BarangDao barangDao = new BarangDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Menjalankan BarangListServlet");
        
        List<Barang> dataBarang = barangDao.semuaBarang();
        System.out.println("Jumlah Record"+dataBarang.size());
        req.setAttribute("daftarBarang", dataBarang);
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/barang/list.jsp")
                .forward(req, resp);
    }
    
}
