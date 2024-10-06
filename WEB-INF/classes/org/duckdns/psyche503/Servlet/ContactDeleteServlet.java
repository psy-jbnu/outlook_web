package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.duckdns.psyche503.Dao.ContactDao;

/**
 * Servlet implementation class ContactDeleteServlet
 */
@WebServlet("/contactDelete.do")
public class ContactDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tel = request.getParameter("tel");
	    String[] tels = request.getParameterValues("tel_chk");
		if (tel != null) {
		    tels = new String[1];
            tels[0] = tel;
        }
	    String url = "contactsList.do";
		String msg = "삭제에 성공하였습니다.";
		if (tels == null) {
		    msg = "체크하시고 실행해주십시오.";

        }else {
            ContactDao cDao = ContactDao.getInstance();
            int result = cDao.deleteContacts(tels);
            msg = (result + 1) +"개 "+ msg;
            if ((result+1) != tels.length) {
                msg = "삭제에 실패하였습니다.";
            }
        }
		
		url = url +"?msg=" + URLEncoder.encode(msg, "utf-8");
		
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
