package com.ty.Employemanagent.Entity;

public class Employe {
private int id;
private String name;
private int age;
private String emailid;
private int Salary;



public Employe() {
	super();
}
public Employe(int id, String name, int age, String emailid, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.emailid = emailid;
	Salary = salary;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}

}
