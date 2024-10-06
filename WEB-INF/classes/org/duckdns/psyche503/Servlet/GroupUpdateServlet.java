package org.duckdns.psyche503.Servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.duckdns.psyche503.Dao.GroupDao;

/**
 * Servlet implementation class GroupUpdateServlet
 */
@WebServlet("/GroupUpdateServlet")
public class GroupUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "group.do";
        String msg = "그룹 수정이 실패하였습니다.";
        String groupName = request.getParameter("newGroup");
        GroupDao gDao = GroupDao.getInstance();
        int result = gDao.insertNewGroup(groupName);
        if (result == 1) {
            msg = "그룹 수정이 성공하였습니다.";
        }
        url = url + "?msg=" + URLEncoder.encode(msg, "utf-8");
        response.sendRedirect(url);
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
