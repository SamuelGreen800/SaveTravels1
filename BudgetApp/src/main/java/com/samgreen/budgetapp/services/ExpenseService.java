package com.samgreen.budgetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samgreen.budgetapp.models.Expense;
import com.samgreen.budgetapp.repositories.ExpenseRepository;

@Service

public class ExpenseService {
	private final ExpenseRepository repo;
	
	public ExpenseService(ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public List<Expense> all() {
		return repo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return repo.save(expense);
	}
	
//	public Expense findExpense(int id) {
//		Optional<Expense> optionalExpense = expenseRepository.findById(id);
//		if(optionalExpense.isPresent() ) {
//			return optionalBook.get();
//		}
//		else {
//			return null;
//		}
//	}

}
