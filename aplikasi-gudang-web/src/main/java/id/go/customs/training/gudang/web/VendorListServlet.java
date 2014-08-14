/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.web;

import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CEISA7
 */
public class VendorListServlet extends HttpServlet {
    private VendorDao vendorDao = new VendorDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Menampilkan List Vendor");
        List<Vendor> dataVendor = vendorDao.semuaVendor();
        req.setAttribute("daftarVendor", dataVendor);
        req.getRequestDispatcher("/WEB-INF/templates/jsp/vendor/vendor.jsp")
                .forward(req, resp);
            
    }

}
