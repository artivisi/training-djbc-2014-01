/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CEISA12
 */
public class GedungListServlet extends HttpServlet {
    private GedungDao gedungDao = new GedungDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Menjalankan GedungListServlet");
        
        List<Gedung> dataGedung = gedungDao.semuaGedung();
        req.setAttribute("daftarGedung", dataGedung);
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/gedung/list.jsp")
                .forward(req, resp);
    }
    
}
