package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.duckdns.psyche503.Dao.ContactDao;
import org.duckdns.psyche503.Vo.ContactVo;

/**
 * Servlet implementation class ContactSearchServlet
 */
@WebServlet("/contactSearch.do")
public class ContactSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher("contact/contactSearchForm.jsp");
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String searchVal = request.getParameter("searchVal");
        ContactDao cDao = ContactDao.getInstance();
        ArrayList<ContactVo> contacts = cDao.searchContacts(searchVal);
        request.setAttribute("s"
                + "contacts", contacts);
        RequestDispatcher disp = request.getRequestDispatcher("contact/contactSearchForm.jsp");
        disp.forward(request, response);
    }

}
