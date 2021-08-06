package com.WarehousePro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.WarehousePro.entities.item;
import com.WarehousePro.entities.warehouse;
import com.WarehousePro.repositories.itemRepository;
import com.WarehousePro.repositories.warehouseRepository;

@Controller
public class warehouseController 
{


	@Autowired
	private warehouseRepository warehouseRepo;

	// get all warehouse list
	
  @RequestMapping("/whome")
	public String home(Model model)
	{
	  List<warehouse> whlist= warehouseRepo.findAll();
	  model.addAttribute("wh",whlist);	  
	  System.out.println(whlist);

	  return "warehouseList";
	
	}
     //add new warehouse form 
  
  @RequestMapping("/Addwarehouse")
  public String Addwarehouse(Model  model)
  {
	model.addAttribute("wh", new warehouse());
	   return "warehouseAddform";
  }
//process or submit warehouse
  @PostMapping("/processWarehouse")
	public RedirectView processWarehouse( @ModelAttribute warehouse warehouse, HttpServletRequest request)
	{		
	  warehouse result =this.warehouseRepo.save(warehouse);
		System.out.println(result);
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/whome");
  	return redirectView;
	}
  
//display update warehouse form 
			@GetMapping("/updatewarehouse/{id}")
		    public String updateformwarehouse(@PathVariable("id") int id, Model model)
		    {
				warehouse wobj=this.warehouseRepo.findById(id).get();
			model.addAttribute("whs",wobj);
			System.out.println(wobj);
		    	return "warehouseupdateform";
		    }
  
			
			
//handler for delete data
	@RequestMapping("/deletedata/{id}")
  public RedirectView deletedata(@PathVariable("id") int id, HttpServletRequest request)
  {
		this.warehouseRepo.deleteById(id);
		System.out.println("deleted");
		
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/whome");
  	return  redirectView;
  }

}
