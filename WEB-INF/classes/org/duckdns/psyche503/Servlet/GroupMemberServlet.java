
package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.duckdns.psyche503.Dao.ContactDao;
import org.duckdns.psyche503.Dao.UserDao;
import org.duckdns.psyche503.Vo.ContactVo;
import org.duckdns.psyche503.Vo.UserVo;

/**
 * Servlet implementation class groupMemberServlet
 */
@WebServlet("/groupMember.do")
public class GroupMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "group/groupMember.jsp";
        HttpSession session = request.getSession();
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        request.setAttribute("groupId", groupId);
        if (session.getAttribute("loginUser") == null) {
            url = "user/loginForm.jsp";
        }
        ContactDao cDao = ContactDao.getInstance();
        ArrayList<ContactVo> contacts = cDao.getMember(groupId); 
        request.setAttribute("members", contacts);
        RequestDispatcher disp = request.getRequestDispatcher(url);
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
