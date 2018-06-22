/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bilal
 */
@WebServlet(urlPatterns = {"/list"})
public class GetMovies extends HttpServlet {

    static ArrayList<Movie> movies = new ArrayList<>();

    static {
        initMovies();
    }

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

        final String movieNameFilter = request.getParameter("movieNameFilter");
        final boolean hasToFilter = movieNameFilter != null && !movieNameFilter.equals("");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>List of Movies</title>");
            out.println("</head>");
            out.println("<body>");
            if (movies.size() == 0) {
                out.println("<h1>Our List of movies is empty</h1>");
            } else {
                out.println("<h1>Our List of movies is:</h1>");
                out.println("<ul>");
                for (Movie movie : movies) {
                    if (hasToFilter) {
                        if (movie.getTitle().toLowerCase()
                                .contains(movieNameFilter.toLowerCase())) {
                            out.println("<li>" + movie.getTitle() + "</li>");
                        }
                    } else {
                        out.println("<li>" + movie.getTitle() + "</li>");
                    }
                }
                out.println("</ul>");
            }
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

    private static void initMovies() {
        Movie bucketList = new Movie("The Bucket List", 2007);
        movies.add(bucketList);
        movies.add(new Movie("Fight Club", 1999));
        movies.add(new Movie("Into the Wild", 2007));
    }

}
