package com.ty.Employemanagent.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Employemanagent.Entity.Employe;
import com.ty.Employemanagent.service.EmpService;

@WebServlet(value="/displays")
public class DipslayAll extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
EmpService empService=new EmpService();
List<Employe> emps=empService.fetchAll();
PrintWriter pr=resp.getWriter();


pr.print("<!DOCTYPE html>\r\n"
        + "<html lang=\"en\">\r\n"
        + "<head>\r\n"
        + "    <meta charset=\"UTF-8\">\r\n"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
        + "    <title>User Table</title>\r\n"
        + "    <style>\r\n"
        + "        body {\r\n"
        + "            font-family: Arial, sans-serif;\r\n"
        + "            background-color: #f4f4f4;\r\n"
        + "            display: flex;\r\n"
        + "            justify-content: center;\r\n"
        + "            align-items: center;\r\n"
        + "            height: 100vh;\r\n"
        + "            margin: 0;\r\n"
        + "        }\r\n"
        + "        .container {\r\n"
        + "            background-color: #fff;\r\n"
        + "            padding: 20px;\r\n"
        + "            border-radius: 10px;\r\n"
        + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
        + "        }\r\n"
        + "        table {\r\n"
        + "            width: 100%;\r\n"
        + "            border-collapse: collapse;\r\n"
        + "            margin-top: 20px;\r\n"
        + "        }\r\n"
        + "        table, th, td {\r\n"
        + "            border: 1px solid #ddd;\r\n"
        + "        }\r\n"
        + "        th, td {\r\n"
        + "            padding: 10px;\r\n"
        + "            text-align: left;\r\n"
        + "        }\r\n"
        + "        th {\r\n"
        + "            background-color: #f2f2f2;\r\n"
        + "        }\r\n"
        + "        .action-link {\r\n"
        + "            margin: 5px;\r\n"
        + "            padding: 5px 10px;\r\n"
        + "            font-size: 14px;\r\n"
        + "            cursor: pointer;\r\n"
        + "            text-decoration: none;\r\n"
        + "            border-radius: 5px;\r\n"
        + "            color: white;\r\n"
        + "            transition: background-color 0.3s;\r\n"
        + "        }\r\n"
        + "        .link-edit {\r\n"
        + "            background-color: #28a745;\r\n"
        + "        }\r\n"
        + "        .link-edit:hover {\r\n"
        + "            background-color: #218838;\r\n"
        + "        }\r\n"
        + "        .link-delete {\r\n"
        + "            background-color: #dc3545;\r\n"
        + "        }\r\n"
        + "        .link-delete:hover {\r\n"
        + "            background-color: #c82333;\r\n"
        + "        }\r\n"
        + "    </style>\r\n"
        + "</head>\r\n"
        + "<body>\r\n"
        + "    <div class=\"container\">\r\n"
        + "        <h1>User Table</h1>\r\n"
        + "        <table>\r\n"
        + "            <thead>\r\n"
        + "                <tr>\r\n"
        + "                    <th>ID</th>\r\n"
        + "                    <th>Name</th>\r\n"
        + "                    <th>Age</th>\r\n"
        + "                    <th>Email</th>\r\n"
        + "                    <th>Salary</th>\r\n"
        + "                    <th>Actions</th>\r\n"
        + "                </tr>\r\n"
        + "            </thead>\r\n"
        + "            <tbody>");

for (Employe employe : emps) {
	int id=employe.getId();
	String name=employe.getName();
	int age=employe.getAge();
	String emailid=employe.getEmailid();
	int salary=employe.getSalary();
	
	 pr.print("<tr>\r\n"
             + "    <td>" + id + "</td>\r\n"
             + "    <td>" + name + "</td>\r\n"
             + "    <td>" + age + "</td>\r\n"
             + "    <td>" + emailid + "</td>\r\n"
             + "    <td>" + salary + "</td>\r\n"
             + "    <td>\r\n"
             + "        <a href="+"editform.html"+">edit</a>\r\n"
             + "        <a href="+"deleteform.html"+">delete</a>\r\n"
             + "    </td>\r\n"
             + "</tr>");
 }

//pr.print("            </tbody>\r\n"
//        + "        </table>\r\n"
//        + "    </div>\r\n"
//        + "    <script>\r\n"
//        + "        function editUser(link) {\r\n"
//        + "            const row = link.parentNode.parentNode;\r\n"
//        + "            const cells = row.getElementsByTagName('td');\r\n"
//        + "            const id = cells[0].innerText;\r\n"
//        + "            const name = cells[1].innerText;\r\n"
//        + "            const age = cells[2].innerText;\r\n"
//        + "            const email = cells[3].innerText;\r\n"
//        + "            const salary = cells[4].innerText;\r\n"
//        + "            const newName = prompt('Enter new name:', name);\r\n"
//        + "            const newAge = prompt('Enter new age:', age);\r\n"
//        + "            const newEmail = prompt('Enter new email:', email);\r\n"
//        + "            const newSalary = prompt('Enter new salary:', salary);\r\n"
//        + "            if (newName && newAge && newEmail && newSalary) {\r\n"
//        + "                cells[1].innerText = newName;\r\n"
//        + "                cells[2].innerText = newAge;\r\n"
//        + "                cells[3].innerText = newEmail;\r\n"
//        + "                cells[4].innerText = newSalary;\r\n"
//        + "            }\r\n"
//        + "        }\r\n"
//        + "        function deleteUser(link) {\r\n"
//        + "            if (confirm('Are you sure you want to delete this user?')) {\r\n"
//        + "                const row = link.parentNode.parentNode;\r\n"
//        + "                row.parentNode.removeChild(row);\r\n"
//        + "            }\r\n"
//        + "        }\r\n"
//        + "    </script>\r\n"
//        + "</body>\r\n"
//        + "</html>");
}
}

