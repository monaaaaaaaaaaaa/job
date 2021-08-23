package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;



@Controller
public class AlienController extends Alien{
	@Autowired
	AlienRepo repo;
@RequestMapping("/")
	public String home() {
	System.out.println(repo.findByTech("cse"));
	System.out.println(repo.findByAidGreaterThan(2));
	System.out.println(repo.findByTechSorted("cse"));
	return "home.jsp";
}
@RequestMapping("/addAlien")
public String addAlien(Alien alien) {
	repo.save(alien);
	return "home.jsp";
}

@RequestMapping(path="/aliens",produces= {"application/xml"})
@ResponseBody
public List<Alien> getAliensREST() {
//return repo.findAll().toString();
return repo.findAll();
}

@PostMapping("/aliens")
@ResponseBody
public Alien addAlienPOSTMAN(@RequestBody Alien alien) {
	repo.save(alien);
	return alien;
}

@RequestMapping("/aliens/{aid}")
@ResponseBody
public Optional<Alien> getAlienREST(@PathVariable("aid") int aid) {
return repo.findById(aid);	
}

@DeleteMapping("/aliens/{aid}")
@ResponseBody
public String deleteAlienREST(@PathVariable("aid") int aid) {
	Alien alien=repo.getOne(aid);
	repo.delete(alien);
	
return "deleted";	
}

@PutMapping("/aliens")
@ResponseBody
public Alien updateAlienPOSTMAN(@RequestBody Alien alien) {
	repo.save(alien);
	return alien;
}

@RequestMapping("/getAlien")
public ModelAndView getAlien(int aid) {
	ModelAndView mv=new ModelAndView();
	Alien alien=repo.findById(aid).orElse(new Alien());
	mv.addObject(alien);
	mv.setViewName("showAlien.jsp");
	return mv;
}
@RequestMapping("/updateAlien")
public ModelAndView updateAlien(int aid) {
	ModelAndView mv=new ModelAndView();
	Alien alien=repo.findById(aid).orElse(new Alien());
	alien.setAname("friend");
	repo.save(alien);
	mv.addObject(alien);
	mv.setViewName("showAlien.jsp");
	return mv;
}
@RequestMapping("/deleteAlien")
public String deleteAlien(int aid) {
	
	Alien alien=repo.findById(aid).orElse(new Alien());
	repo.delete(alien);
	
	return "home.jsp";
}
@RequestMapping("/createAlien")
public String createAlien(Alien alien) {
	
	alien.setAid(11);
	alien.setAname("mona");
	alien.setTech("cse");
	repo.save(alien);
	alien.setAid(12);
	alien.setAname("mona");
	alien.setTech("cse");
	repo.save(alien);
	return "home.jsp";
}
}
