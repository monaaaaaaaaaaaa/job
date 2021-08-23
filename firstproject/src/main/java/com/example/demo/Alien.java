package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
private int aid;
private String aname;
private String tech;
@Autowired
@Qualifier("lap1")
private Laptop laptop;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public Laptop getLaptop() {
	return laptop;
}
public void setLaptop(Laptop laptop) {
	this.laptop = laptop;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getTech() {
	return tech;
}
public void setTech(String tech) {
	this.tech = tech;
}
public void show() {
	System.out.println("hello there");
	laptop.compile();
}
}
