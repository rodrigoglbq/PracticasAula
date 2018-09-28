/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
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
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
            out.println("<meta charset=\"UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"CSS/registroEstilo.css\">");
            out.println("<title>Servlet registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");

            String[] error = new String[4];

            if (request.getParameter("Nombre").equals("")) {
                System.out.println("error nombre");
                comprobar[0] = 0;
                error[0] = "ERROR.Tiene que introducir un nombre.";

            }

            /*int year = Integer.parseInt(request.getParameter("Year"));
            int month = Integer.parseInt(request.getParameter("Month"));
            int day = Integer.parseInt(request.getParameter("Day"));

            int[] meses = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};*/

 /*GregorianCalendar calendar = new GregorianCalendar();
            
            if (calendar.isLeapYear(year)) {
                meses[2] = 29;
            System.out.println("calendario bisiesto");
            }

            if (meses[month] > day) {
                 System.out.println("comprobar fecha");
                comprobar[1] = 1;
                error[1] = "ERROR.Tiene que introducir una Fecha correcta";
            }*/
            if (request.getParameter("Usuario").equals("")) {

                comprobar[2] = 2;
                error[2] = "ERROR.Tiene que introducir un usuario.";
            }

            if (request.getParameter("Password").equals("")) {

                comprobar[3] = 3;
                error[3] = "ERROR.Tiene que introducir una contraseña";
            }

            if (comprobarError(request, response) == false) {

                Map<String, String[]> miMapa = request.getParameterMap();
                Iterator it = miMapa.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
                    out.println("<li>");
                    out.println("<strong>" + e.getKey() + ": " + request.getParameter(e.getKey().toString()) + "</strong>");
                    out.println("</li>");
                    out.println("<br>");
                }

            } else {

                for (String x : error) {

                    if (x != null) {
                        out.println("<h1>" + x + "</h1>");
                    }

                }

                out.println("      <form action=\"Registro\" method=\"post\">\n"
                        + "        <h1>Registro de Usuario</h1>\n"
                        + "        <fieldset>\n"
                        + "            <legend>Información Personal</legend>\n"
                        + "            <label for=\"nombre\">Nombre:</label>\n"
                        + "            <input type=\"text\" name=\"Nombre\" id=\"nombre\" value=" + request.getParameter("Nombre") + ">\n"
                        + "\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "\n"
                        + "            <label for=\"apellido\">Apellidos</label>\n"
                        + "            <input type=\"text\" name=\"Apellidos\" id=\"apellido\" value=" + request.getParameter("Apellidos") + ">\n"
                        + "\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "\n");
                if (request.getParameter("Sexo") != null) {
                    out.println("<label for=\"sexo\">Sexo:</label>&nbsp;\n"
                            + "\n"
                            + "            <label for=\"hombre\">Hombre</label>\n"
                            + "            <input type=\"radio\" name=\"Sexo\" id=\"sexo\" value=\"Hombre\" checked>\n"
                            + "\n"
                            + "            <label for=\"sexo\">Mujer</label>\n"
                            + "            <input type=\"radio\" name=\"Sexo\" id=\"sexo\" value=\"Mujer\" checked>\n"
                            + "\n"
                            + "            <br>\n"
                            + "            <br>\n"
                            + "\n");
                } else {
                    out.println("<label for=\"sexo\">Sexo:</label>&nbsp;\n"
                            + "\n"
                            + "            <label for=\"hombre\">Hombre</label>\n"
                            + "            <input type=\"radio\" name=\"Sexo\" id=\"sexo\" value=\"Hombre\">\n"
                            + "\n"
                            + "            <label for=\"sexo\">Mujer</label>\n"
                            + "            <input type=\"radio\" name=\"Sexo\" id=\"sexo\" value=\"Mujer\">\n"
                            + "\n"
                            + "            <br>\n"
                            + "            <br>\n"
                            + "\n");
                }//Fin else

                out.println("<label for=\"dia\">Fecha de Nacimineto</label>\n"
                        + "            <select name=\"Day\" id=\"dia\">\n"
                        + "                <option value=\"1\">1</option>\n"
                        + "                <option value=\"2\">2</option>\n"
                        + "                <option value=\"3\">3</option>\n"
                        + "                <option value=\"4\">4</option>\n"
                        + "                <option value=\"5\">5</option>\n"
                        + "                <option value=\"6\">6</option>\n"
                        + "                <option value=\"7\">7</option>\n"
                        + "                <option value=\"8\">8</option>\n"
                        + "                <option value=\"9\">9</option>\n"
                        + "                <option value=\"10\">10</option>\n"
                        + "                <option value=\"11\">11</option>\n"
                        + "                <option value=\"12\">12</option>\n"
                        + "                <option value=\"13\">13</option>\n"
                        + "                <option value=\"14\">14</option>\n"
                        + "                <option value=\"15\">15</option>\n"
                        + "                <option value=\"16\">16</option>\n"
                        + "                <option value=\"17\">17</option>\n"
                        + "                <option value=\"18\">18</option>\n"
                        + "                <option value=\"19\">19</option>\n"
                        + "                <option value=\"20\">20</option>\n"
                        + "                <option value=\"21\">21</option>\n"
                        + "                <option value=\"22\">22</option>\n"
                        + "                <option value=\"23\">23</option>\n"
                        + "                <option value=\"24\">24</option>\n"
                        + "                <option value=\"25\">25</option>\n"
                        + "                <option value=\"26\">26</option>\n"
                        + "                <option value=\"27\">27</option>\n"
                        + "                <option value=\"28\">28</option>\n"
                        + "                <option value=\"29\">29</option>\n"
                        + "                <option value=\"30\">30</option>\n"
                        + "                <option value=\"31\">31</option>\n"
                        + "            </select>\n"
                        + "\n"
                        + "            <select name=\"Month\" id=\"mes\">\n"
                        + "                <option value=\"Enero\">Enero</option>\n"
                        + "                <option value=\"Febrero\">Febrero</option>\n"
                        + "                <option value=\"Marzo\">Marzo</option>\n"
                        + "                <option value=\"Abril\">Abril</option>\n"
                        + "                <option value=\"Mayo\">Mayo</option>\n"
                        + "                <option value=\"Junio\">Junio</option>\n"
                        + "                <option value=\"Julio\">Julio</option>\n"
                        + "                <option value=\"Agosto\">Agosto</option>\n"
                        + "                <option value=\"Sptiembre\">Sptiembre</option>\n"
                        + "                <option value=\"Octubre\">Octubre</option>\n"
                        + "                <option value=\"Noviembre\">Noviembre</option>\n"
                        + "                <option value=\"Diciembre\">Diciembre</option>\n"
                        + "            </select>\n"
                        + "\n"
                        + "            <select name=\"Year\" id=\"anio\">\n"
                        + "                \n"
                        + "                <option value=\"2018\">2018</option>\n"
                        + "                <option value=\"2017\">2017</option>\n"
                        + "                <option value=\"2016\">2016</option>\n"
                        + "                <option value=\"2015\">2015</option>\n"
                        + "                <option value=\"2014\">2014</option>\n"
                        + "                <option value=\"2013\">2013</option>\n"
                        + "                <option value=\"2012\">2012</option>\n"
                        + "                <option value=\"2011\">2011</option>\n"
                        + "                <option value=\"2010\">2010</option>\n"
                        + "                <option value=\"2009\">2009</option>\n"
                        + "                <option value=\"2008\">2008</option>\n"
                        + "                <option value=\"2007\">2007</option>\n"
                        + "                <option value=\"2006\">2006</option>\n"
                        + "                <option value=\"2005\">2005</option>\n"
                        + "                <option value=\"2004\">2004</option>\n"
                        + "                <option value=\"2003\">2003</option>\n"
                        + "                <option value=\"2002\">2002</option>\n"
                        + "                <option value=\"2001\">2001</option>\n"
                        + "                <option value=\"2000\">2000</option>\n"
                        + "                <option value=\"1999\">1999</option>\n"
                        + "                <option value=\"1998\">1998</option>\n"
                        + "                <option value=\"1997\">1997</option>\n"
                        + "                <option value=\"1996\">1996</option>\n"
                        + "                <option value=\"1995\">1995</option>\n"
                        + "                <option value=\"1994\">1994</option>\n"
                        + "                <option value=\"1993\">1993</option>\n"
                        + "                <option value=\"1992\">1992</option>\n"
                        + "                <option value=\"1991\">1991</option>\n"
                        + "                <option value=\"1990\">1990</option>\n"
                        + "                <option value=\"1989\">1989</option>\n"
                        + "                <option value=\"1988\">1988</option>\n"
                        + "                <option value=\"1988\">1988</option>\n"
                        + "                <option value=\"1987\">1987</option>\n"
                        + "                <option value=\"1986\">1986</option>\n"
                        + "                <option value=\"1985\">1985</option>\n"
                        + "                <option value=\"1984\">1984</option>\n"
                        + "                <option value=\"1983\">1983</option>\n"
                        + "                <option value=\"1982\">1982</option>\n"
                        + "                <option value=\"1981\">1981</option>\n"
                        + "                <option value=\"1980\">1980</option>\n"
                        + "                <option value=\"1979\">1979</option>\n"
                        + "                <option value=\"1978\">1978</option>\n"
                        + "                <option value=\"1977\">1977</option>\n"
                        + "                <option value=\"1976\">1976</option>\n"
                        + "                <option value=\"1975\">1975</option>\n"
                        + "                <option value=\"1974\">1974</option>\n"
                        + "                <option value=\"1973\">1973</option>\n"
                        + "                <option value=\"1972\">1972</option>\n"
                        + "                <option value=\"1971\">1971</option>\n"
                        + "                <option value=\"1970\">1970</option>\n"
                        + "                <option value=\"1969\">1969</option>\n"
                        + "                <option value=\"1968\">1968</option>\n"
                        + "                <option value=\"1967\">1967</option>\n"
                        + "                <option value=\"1966\">1966</option>\n"
                        + "                <option value=\"1965\">1965</option>\n"
                        + "                <option value=\"1964\">1964</option>\n"
                        + "                <option value=\"1963\">1963</option>\n"
                        + "                <option value=\"1962\">1962</option>\n"
                        + "                <option value=\"1961\">1961</option>\n"
                        + "                <option value=\"1960\">1960</option>\n"
                        + "                <option value=\"1959\">1959</option>\n"
                        + "                <option value=\"1958\">1958</option>\n"
                        + "                <option value=\"1957\">1957</option>\n"
                        + "                <option value=\"1956\">1956</option>\n"
                        + "                <option value=\"1955\">1955</option>\n"
                        + "                <option value=\"1954\">1954</option>\n"
                        + "                <option value=\"1953\">1953</option>\n"
                        + "                <option value=\"1952\">1952</option>\n"
                        + "                <option value=\"1951\">1951</option>\n"
                        + "                <option value=\"1950\">1950</option>\n"
                        + "                <option value=\"1949\">1949</option>\n"
                        + "                <option value=\"1948\">1948</option>\n"
                        + "                <option value=\"1947\">1947</option>\n"
                        + "                <option value=\"1946\">1946</option>\n"
                        + "                <option value=\"1945\">1945</option>\n"
                        + "                <option value=\"1944\">1944</option>\n"
                        + "                <option value=\"1943\">1943</option>\n"
                        + "                <option value=\"1942\">1942</option>\n"
                        + "                <option value=\"1941\">1941</option>\n"
                        + "                <option value=\"1940\">1940</option>\n"
                        + "                <option value=\"1939\">1939</option>\n"
                        + "                <option value=\"1938\">1938</option>\n"
                        + "                <option value=\"1937\">1937</option>\n"
                        + "                <option value=\"1936\">1936</option>\n"
                        + "                <option value=\"1935\">1935</option>\n"
                        + "                <option value=\"1934\">1934</option>\n"
                        + "                <option value=\"1933\">1933</option>\n"
                        + "                <option value=\"1932\">1932</option>\n"
                        + "                <option value=\"1931\">1931</option>\n"
                        + "                <option value=\"1930\">1930</option>\n"
                        + "                <option value=\"1929\">1929</option>\n"
                        + "                <option value=\"1928\">1928</option>\n"
                        + "                \n"
                        + "            </select>\n"
                        + "        </fieldset>\n"
                        + "\n"
                        + "        <fieldset>\n"
                        + "            <legend>Datos de Acceso</legend>\n"
                        + "\n"
                        + "            <label for=\"usuario\">Usuario:</label>\n"
                        + "            <input type=\"text\" name=\"Usuario\" id=\"usuario\" value=" + request.getParameter("Usuario") + ">\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "\n"
                        + "            <label for=\"password\">Contraseña:</label>\n"
                        + "            <input type=\"password\" name=\"Password\" id=\"password\" value=" + request.getParameter("Password") + ">\n"
                        + "\n"
                        + "        </fieldset>\n"
                        + "\n"
                        + "        <fieldset>\n"
                        + "            <legend>Información general</legend>\n"
                        + "            <label for=\"preferencias\">Preferencias:</label>&nbsp;\n"
                        + "\n"
                        + "            <label for=\"preferencias\">Deporte</label>\n");

                if (request.getParameter("Preferencias") != null) {
                    out.println(" <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Deporte\" checked>\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Lectura</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Lectura\" checked>\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Cine</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Cine\" cheked>\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Viajes</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Viajes\" cheked>\n");
                } else {
                    out.println(" <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Deporte\" >\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Lectura</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Lectura\" >\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Cine</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Cine\" >\n"
                            + "\n"
                            + "            <label for=\"preferencias\">Viajes</label>\n"
                            + "            <input type=\"checkbox\" name=\"Preferencias\" id=\"preferencias\" value=\"Viajes\" >\n");
                }

                out.println("\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "            \n"
                        + "            <input class=\"boton\" type=\"submit\" name=\"enviar\" id=\"enviar\" value=\"Enviar\">\n"
                        + "            \n"
                        + "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n"
                        + "       \n"
                        + "            <input class=\"boton\" type=\"reset\" name=\"limpiar\" id=\"limpiar\" value=\"Limpiar\">\n"
                        + "        </fieldset>\n"
                        + "\n"
                        + "    </form>\n"
                        + "");
                out.println("<div class='menu'>");
                out.println("<a href= index.html>Menú Principal</a>");
                out.println("</div>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }

    }
    static int[] comprobar = {-1, -1, -1, -1};

    static boolean comprobarError(HttpServletRequest request, HttpServletResponse response) {

        while (comprobar[0] == -1 || comprobar[1] == -1 || comprobar[2] == -1 || comprobar[3] == -1) {
            return true;
        }
        return false;
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
