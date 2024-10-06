package org.duckdns.psyche503.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.duckdns.psyche503.Dao.UserDao;
import org.duckdns.psyche503.Vo.UserVo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "contactsList.do";
		UserVo loginUser = (UserVo)session.getAttribute("loginUser");
		if (loginUser ==  null) {
			url = "user/loginForm.jsp";
		} 
		
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String ipAddress = request.getRemoteAddr();
		UserVo loginUser = new UserVo();
		String userEmail = request.getParameter("userEmail");
		String pwd = request.getParameter("pwd");
		loginUser.setUserEmail(userEmail);
		loginUser.setPwd(pwd);
		loginUser.setIpAddress(ipAddress);
		
		UserDao uDao = UserDao.getInstance();
		
		UserVo user = uDao.getUser(loginUser);
		String msg = null;
		String url = "user/loginForm.jsp";
		if (user == null) {
            msg = "이메일이 존재하지 않습니다.";
        } else {
            int result = 0;
            if (pwd.equals(user.getPwd())) {
                url = "contactsList.do";
                session.setAttribute("loginUser", user);
                result = 1;
            } else {
                msg = "비밀번호가 일치하지 않습니다.";
                
            }
            uDao.writeLoginHis(ipAddress, result);
            System.out.println(user.getPwd()+"\\"+pwd);
        }
		request.setAttribute("msg", msg);
		
		RequestDispatcher disp = 
		        request.getRequestDispatcher(url);
		
		disp.forward(request, response);
	}

}
