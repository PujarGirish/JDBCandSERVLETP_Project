package com.ty.Employemanagent.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Employemanagent.Entity.Employe;
import com.ty.Employemanagent.service.EmpService;

@WebServlet(value = "/submit")
public class Editemp extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String age=req.getParameter("age");
	String email=req.getParameter("emailid");
	String salaray=req.getParameter("salary");
	
	int ids=Integer.parseInt(id);
	int agess=Integer.parseInt(age);
	int salarys=Integer.parseInt(salaray);
	
	Employe e=new Employe(ids, name, agess, email, salarys);
	
	
	EmpService empService=new EmpService();
	int res=empService.update(e);
	if (res!=0) {
		RequestDispatcher rsdp=req.getRequestDispatcher("Welcome.html");
		
		rsdp.include(req, resp);
	}
}
}
