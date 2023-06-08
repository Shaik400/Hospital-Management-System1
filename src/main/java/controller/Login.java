package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/Login")
public class Login extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	
	MyDao m=new MyDao();
	Doctor d=m.fetchDoctor(id);
	Staff s=m.fetchStaff(id);
	
	if(s==null && d==null && id!=999999)
	{
		resp.getWriter().print("<h1 style='color:red'>Incorrect id</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
		else
		{
			if(s!=null)
			{
				if(s.getPassword().equals(password)){
					if(s.isStatus())
				{
					resp.getWriter().print("<h1 style='color:green'>Login succesfully</h1>");
					req.getRequestDispatcher("StaffHome.html").include(req, resp);
				}
				else{
					resp.getWriter().print("<h1 style='color:red'>Incorrect password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
				if(d!=null)
				{
					if(d.getPassword().equals(password))
					{
						if(d.isStatus()){
						resp.getWriter().print("<h1 style='color:green'>Login succesfully</h1>");
						req.getRequestDispatcher("DoctorHome.html").include(req, resp);
					}
					else{
						resp.getWriter().print("<h1 style='color:red'>Wait for admin approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
			}
				if(id==999999)
				{
					if("999999".equals(password))
					{

						resp.getWriter().print("<h1 style='color:green'>Login succesfully</h1>");
						req.getRequestDispatcher("AdminHome.html").include(req, resp);
					}
					else{
						resp.getWriter().print("<h1 style='color:red'> Wait for admin approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
			}
					}
				}
		}                                                                          
}
}
}
	


