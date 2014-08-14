/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CEISA7
 */
@WebServlet(name = "BimaServlet", urlPatterns = {"/Bima"})
public class BimaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nama = req.getParameter("nama");
        String output = "Halo " +nama;
        resp.setContentType("text/html");
        resp.getWriter().print(output);
        resp.getWriter().flush();
    }
    }

