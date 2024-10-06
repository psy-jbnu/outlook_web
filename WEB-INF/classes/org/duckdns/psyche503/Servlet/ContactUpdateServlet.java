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
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/contactUpdate.do")
public class ContactUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "contact/contactUpdateForm.jsp";
        HttpSession session = request.getSession();
        String tel = request.getParameter("tel");
        if (session.getAttribute("loginUser") == null) {
            url = "login.do";
        }
        ContactDao cDao = ContactDao.getInstance();
        ContactVo contact = cDao.getContact(tel);
        request.setAttribute("contact", contact);
        request.setAttribute("oldTel", tel);
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
        String msg = "";
        request.setCharacterEncoding("utf-8");
        String oldTel = request.getParameter("oldTel");
        String url = "contactUpdate.do";
        String contactName = request.getParameter("contactName");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr"); 
        String email = request.getParameter("email");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        if (groupId == -1) {
            GroupDao gDao = GroupDao.getInstance();
            String newGroup = request.getParameter("newGroup");
            groupId = gDao.insertNewGroup(newGroup);
        }
        
        if(groupId == -1) {
            msg = "신규 그룹 등록에 실패하였습니다.";
        }else {
            ContactVo contact = new ContactVo();
            contact.setAddr(addr);
            contact.setContactName(contactName);
            contact.setEmail(email);
            contact.setGroupId(groupId);
            contact.setTel(tel);
            
            ContactDao cDao = ContactDao.getInstance();
            int result = cDao.updateContact(contact,oldTel);
            if (result == 1) {
                msg = "연락처 수정에 성공하였습니다.";
                url = "contactsList.do";
            } else {
                msg = "연락처 수정에 실패하였습니다.";
            }
        }
        url = url + "?tel=" + oldTel 
                + "&msg=" + URLEncoder.encode(msg, "Utf-8"); 
        response.sendRedirect(url);
    }

}
