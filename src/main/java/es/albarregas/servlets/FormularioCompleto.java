/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Collection;
//import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "FormularioCompleto", urlPatterns = {"/FormularioCompleto"})
public class FormularioCompleto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formularioCompleto</title>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/servletEstilo.css'>");
            out.println("</head>");
            out.println("<body id='bodySform'>");
            out.println("<header>");
            out.println("<div id='resp'>");
            out.println("<ul>");           
            
                
            
            Map<String, String[]> miMapa = request.getParameterMap();
            Iterator it = miMapa.entrySet().iterator();
            
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();                  
                out.println("<li>");
                out.println( "<strong>"+e.getKey()+": "+request.getParameter(e.getKey().toString())+"</strong>");              
                out.println("</li>");
                out.println("<br>");
                
            }

            
            
           /* Enumeration <String> parametros = request.getParameterNames();
            while (parametros.hasMoreElements()){
                String nombre = parametros.nextElement();
                if(!nombre.startsWith("env")){
                out.println("<li>");    
		out.println("<strong/>"+nombre+":"+"   "+"<strong/>"+request.getParameter(nombre));
                out.println("</li>");
                out.println("<br>");
                }
            }*/
 
            out.println("</ul>");
            out.println("<a href= index.html>Menú Principal</a>");
            out.println("</div>");
            out.println("</header>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
