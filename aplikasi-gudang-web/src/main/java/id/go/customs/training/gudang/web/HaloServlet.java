package id.go.customs.training.gudang.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class HaloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nama = req.getParameter("nama");
        
        String output = "Halo "+nama;
        resp.setContentType("text/html");
        resp.getWriter().print(output);
        resp.getWriter().flush();
    }
    
}
