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
        
        String output = "<html>\n";
        output += "\t<head><title>Halo Servlet</title></head>\n";
        output += "\t<body>\n";
        output += "\t\t<b>Halo "+nama+"</b>\n";
        output += "\t</body>\n";
        output += "</html>";
        
        
        resp.setContentType("text/html");
        resp.getWriter().print(output);
        resp.getWriter().flush();
    }    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
