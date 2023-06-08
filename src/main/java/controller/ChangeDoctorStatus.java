package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Staff;
@WebServlet("/fetchalldoctor")
public class ChangeDoctorStatus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MyDao m=new MyDao();
		Staff staff=m.fetchStaff(id);
		if(staff.isStatus())
			staff.setStatus(false);
		else
			staff.setStatus(true);
		resp.getWriter().print("<h1 style='color:red'>Updated Successfully</h1>");
		req.setAttribute("list", m.fetchallstaff());
		req.getRequestDispatcher("ApproveStaff.jsp").include(req, resp);
	}
}
