package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.net.URLEncoder;

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
 * Servlet implementation class ContactInsertServlet
 */
@WebServlet("/contactInsert.do")
public class ContactInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "contact/contactInsertForm.jsp";
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) {
            url = "user/loginForm.jsp";
        }
        request.setAttribute("msg", request.getParameter("msg"));
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String msg = "";
        String url = "contactInsert.do";
        
        String contactName = request.getParameter("contactName");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr"); 
        String email = request.getParameter("email");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        if (groupId == -1) {
            GroupDao gDao = GroupDao.getInstance();
            String groupName = request.getParameter("newGroup");
            groupId = gDao.insertNewGroup(groupName);
        }
        if (groupId == -1) {
            msg = "신규 그룹 등록에 실패했습니다.";
        }else {
            ContactVo contact = new ContactVo();
            contact.setTel(tel);
            contact.setEmail(email);
            contact.setAddr(addr);
            contact.setContactName(contactName);
            contact.setGroupId(groupId);
            ContactDao cDao = ContactDao.getInstance();
            int result = cDao.insertContact(contact);
            if (result == 1) {
                msg = "등록에 성공하였습니다.";
            }else {
                msg = "등록에 실패하였습니다.";
            }
        }
        
        url = url + "?msg=" + URLEncoder.encode(msg, "Utf-8"); 
        response.sendRedirect(url);

    }

}
