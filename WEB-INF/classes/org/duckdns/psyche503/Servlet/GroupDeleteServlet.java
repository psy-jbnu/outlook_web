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
 * Servlet implementation class GroupDeleteServlet
 */
@WebServlet("/groupDelete.do")
public class GroupDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        GroupDao gDao = GroupDao.getInstance();
        String msg = null;
        String url = "group.do";
        int result = gDao.deleteGroup(groupId);
        if (result == 1) {
            msg = "그룹이 삭제되었습니다.";
        }else {
            msg = "그룹 삭제에 실패하였습니다.";
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
        doGet(request, response);
    }

}
