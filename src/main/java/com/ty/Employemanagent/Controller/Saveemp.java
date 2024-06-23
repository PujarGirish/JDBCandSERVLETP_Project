package com.ty.Employemanagent.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Employemanagent.Entity.Employe;
import com.ty.Employemanagent.service.EmpService;

@WebServlet(value = "/save")
public class Saveemp  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String id= req.getParameter("id");
  String name= req.getParameter("name");
  String age= req.getParameter("age");
  String email= req.getParameter("email");
   String salary=req.getParameter("salary");
   
   int ids=Integer.parseInt(id);
   int salarys=Integer.parseInt(salary);
   int ages=Integer.parseInt(age);
   
Employe e=new Employe();
e.setId(ids);
e.setName(name);
e.setAge(ages);
e.setEmailid(email);
e.setSalary(salarys);
EmpService empService=new EmpService();
int res=empService.save(e);
if (res!=0) {
	RequestDispatcher rs=req.getRequestDispatcher("Welcome.html");
	rs.include(req, resp);
	   
}
else
{
	RequestDispatcher rs=req.getRequestDispatcher("Welcome.html");
	rs.include(req, resp);
	   
}

}
}
