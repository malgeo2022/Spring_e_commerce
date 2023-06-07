package com.spring_e_commerce.web.controller;


import com.spring_e_commerce.web.model.Category;
import com.spring_e_commerce.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal){
        if (principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("size", categories.size());
        model.addAttribute("title", "Category");
        model.addAttribute("categoryNew", new Category());
        return "categories";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("categoryNew") Category category, RedirectAttributes attributes) {
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success", "added successfully");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Duplicate entry");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Server error");
        }
        return "redirect:/categories";
    }


    @RequestMapping(value = "/findById", method = {RequestMethod.PUT,RequestMethod.GET})
    @ResponseBody
    public Category findById(Long id){
        return categoryService.findById(id);
    }


    @GetMapping("/update-category")
    public String update(Category category, RedirectAttributes attributes){
          try {
              categoryService.update(category);
              attributes.addFlashAttribute("success","Updated Successfully");
          }catch (DataIntegrityViolationException e){
              e.printStackTrace();
              attributes.addFlashAttribute("failed", "Failed to Update due to Duplicate Entry");
          }catch (Exception e){
              e.printStackTrace();
              attributes.addFlashAttribute("failed", "Server Error");
          }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete-category", method = {RequestMethod.PUT,RequestMethod.GET})
    public String delete(Long id,RedirectAttributes attributes){
        try {
            categoryService.deleteById(id);
            attributes.addFlashAttribute("success", "Deleted Successfully!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to Delete Entry");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/enable-category", method = {RequestMethod.PUT,RequestMethod.GET})
    public String enable(Long id,RedirectAttributes attributes){
        try {
            categoryService.enableById(id);
            attributes.addFlashAttribute("success", "Enabled Successfully!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to enable Entry");
        }
        return "redirect:/categories";
    }



}
