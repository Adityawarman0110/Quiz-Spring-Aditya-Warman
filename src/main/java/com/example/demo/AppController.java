package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private CsrService service;
	
	//Handler Methods
	@RequestMapping("/")
	public String viewHomePage (Model model) {
		
		return "index";
	}
	
	@RequestMapping("/list")
	public String viewListPage (Model model) {
		List<Tblprogramcsr> listCsr = service.listAll();
		model.addAttribute("listCsr", listCsr);
		return "list";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateCsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
		service.save(tblprogramcsr);
			
		return "redirect:/list";	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
		service.save(tblprogramcsr);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCsrPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_csr");
		Tblprogramcsr tblprogramcsr = service.get(id);
		mav.addObject("tblprogramcsr", tblprogramcsr);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCsr(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/list";
	}
	
}
