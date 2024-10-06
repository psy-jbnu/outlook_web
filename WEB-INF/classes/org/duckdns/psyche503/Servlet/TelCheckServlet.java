package org.duckdns.psyche503.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.duckdns.psyche503.Dao.ContactDao;
import org.duckdns.psyche503.Vo.ContactVo;

/**
 * Servlet implementation class TelCheckServlet
 */
@WebServlet("/telCheck.do")
public class TelCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int result = -1;
        String url = "contact/telCheckForm.jsp";
        String tel = request.getParameter("tel");
        ContactDao cDao = ContactDao.getInstance();
        ContactVo contact = cDao.getContact(tel);
        if (contact != null) {
            result = 1;
        }
        System.out.println(result);
        request.setAttribute("result", result);
        request.setAttribute("tel", tel);
        RequestDispatcher disp =
                request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
