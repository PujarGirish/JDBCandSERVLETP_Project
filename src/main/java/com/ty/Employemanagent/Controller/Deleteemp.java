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

@WebServlet(value="/delete")
public class Deleteemp extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String ids=req.getParameter("id");
  int id=Integer.parseInt(ids);	
  
  EmpService empService=new EmpService();
  int res=empService.delete(id);
  if (res!=0) {
	RequestDispatcher rsdp=req.getRequestDispatcher("Welcome.html");
	rsdp.include(req, resp);
}
}
}
