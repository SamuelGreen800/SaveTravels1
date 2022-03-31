package com.samgreen.budgetapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samgreen.budgetapp.models.Expense;
import com.samgreen.budgetapp.services.ExpenseService;
import com.samgreen.budgetapp.repositories.ExpenseRepository;
@Controller
public class ExpenseController {
	
		@Autowired 
		private ExpenseService expenseService;

		@RequestMapping("/")
		public String landing() {
			return "redirect:/expenses";
		}
		
		@RequestMapping("/expenses")
		public String index(@ModelAttribute("expense") Expense expense, Model model) {
			List<Expense> expenses = expenseService.all();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
	}
		
		@PostMapping("/submitForm")
		public String saveExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
				if(result.hasErrors()) {
					List<Expense> expenses = expenseService.all();
					model.addAttribute("expenses", expenses);
					return "/index.jsp";
				}
				else {
					expenseService.createExpense(expense);
					return "redirect:/expenses";
				}
		}
		
		
		@RequestMapping("/results")
			public String results(HttpSession session, Model model) {
			String result = (String) session.getAttribute("results");
			model.addAttribute("result", result);
			return "results.jsp";
			
		}

		public ExpenseService getExpense() {
			return expenseService;
		}

		public void setExpense(ExpenseService expense) {
			this.expenseService = expense;
		}



	}



