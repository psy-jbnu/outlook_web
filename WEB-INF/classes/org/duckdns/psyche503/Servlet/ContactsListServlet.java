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
import org.duckdns.psyche503.Vo.UserVo;

/**
 * Servlet implementation class ContactsListServlet
 */
@WebServlet("/contactsList.do")
public class ContactsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
        String url = "main.jsp";
        UserVo loginUser = (UserVo)session.getAttribute("loginUser");
        if (loginUser ==  null) {
            url = "user/loginForm.jsp";
        } 
        
        ContactDao cDao = ContactDao.getInstance();
        
        ArrayList<ContactVo> contacts = cDao.getAllContacts();
        
        session.setAttribute("contacts", contacts);
        
        GroupDao gDao = GroupDao.getInstance();
        
        HashMap<Integer, String> groups = gDao.getAllGroups();
        ArrayList<Integer> groupIds = new ArrayList<Integer>(groups.keySet());
        session.setAttribute("groups", groups);
        session.setAttribute("groupIds", groupIds);
        
        String msg = request.getParameter("msg");
        if (msg != null) {
            request.setAttribute("msg", msg);
        }
        
        RequestDispatcher disp =
                request.getRequestDispatcher(url);
        disp.forward(request, response);
        
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
