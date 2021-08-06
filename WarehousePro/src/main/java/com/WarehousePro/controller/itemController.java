package com.WarehousePro.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.WarehousePro.entities.item;
import com.WarehousePro.repositories.itemRepository;



@Controller
public class itemController 
{

	@Autowired
	private itemRepository itemRepo;
	
	// get all item list
	
	@GetMapping("/")
	public String home(Model model)
	{
		List<item> itemlist =  this.itemRepo.findAll();
		model.addAttribute("data",itemlist);
		System.out.println(itemlist);
		
		return "itemList";
	
	}
	// add new item form 
	@RequestMapping("/AddItem")
	   public String AddItem(Model  model)
	   {
		model.addAttribute("item", new item());
		   return "additemform";
	   }
	 // process or submit items
	@PostMapping("/processitem")
	public RedirectView processitem( @ModelAttribute item item, HttpServletRequest request)
	{		
		item result =this.itemRepo.save(item);
		System.out.println(result);
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/");
    	return redirectView;
   
    	
    	}
		
	// display update item data form 
			@GetMapping("/update/{id}")
		    public String updateform(@PathVariable("id") int id, Model model)
		    {
		  item itemobj=this.itemRepo.findById(id).get();
			model.addAttribute("items",itemobj);
			System.out.println(itemobj);
		    	return "updateformitem";
		    }
		
		//handler for delete data
			@RequestMapping("/delete/{id}")
		    public RedirectView deleteItem(@PathVariable("id") int id, HttpServletRequest request)
		    {
				this.itemRepo.deleteById(id);
				RedirectView redirectView =new RedirectView();
				redirectView.setUrl(request.getContextPath()+ "/");
		    	return redirectView;
		    }
	
  
	 
}
