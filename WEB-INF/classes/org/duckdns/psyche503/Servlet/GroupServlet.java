package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.duckdns.psyche503.Dao.ContactDao;
import org.duckdns.psyche503.Dao.GroupDao;
import org.duckdns.psyche503.Vo.ContactVo;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/group.do")
public class GroupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "group/group.jsp";
        String msg = request.getParameter("msg");
        HttpSession session = request.getSession();
        
        ContactDao cDao = ContactDao.getInstance();
        
        ArrayList<ContactVo> contacts = cDao.getAllContacts();
        
        session.setAttribute("contacts", contacts);
        
        GroupDao gDao = GroupDao.getInstance();
        
        HashMap<Integer, String> groups = gDao.getAllGroups();
        ArrayList<Integer> groupIds = new ArrayList<Integer>(groups.keySet());
        session.setAttribute("groups", groups);
        session.setAttribute("groupIds", groupIds);
        request.setAttribute("msg", msg);
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
