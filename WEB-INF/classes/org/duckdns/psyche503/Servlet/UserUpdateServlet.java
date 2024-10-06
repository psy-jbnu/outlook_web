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

import org.duckdns.psyche503.Dao.UserDao;
import org.duckdns.psyche503.Vo.UserVo;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/userUpdate.do")
public class UserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "user/userUpdateForm.jsp";
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) {
            url = "login.do";
        }
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "contactsList.do";
        request.setCharacterEncoding("utf-8");
        String userEmail = request.getParameter("userEmail");
        String pwd = request.getParameter("pwd");
        String msg = null;
        UserVo user = new UserVo();
        user.setUserEmail(userEmail);
        user.setPwd(pwd);
        
        UserDao uDao = UserDao.getInstance();
        int result = uDao.updateUser(user);
        if (result == 1) {
            msg = "회원 정보를 수정하였습니다.";
            HttpSession session = request.getSession();
            session.setAttribute("loginUser" , user);
        }else {
            msg = "회원 정보 수정이 실패하였습니다.";
        }
        url = url + "?msg=" + URLEncoder.encode(msg, "utf-8");
        response.sendRedirect(url);
    }

}
