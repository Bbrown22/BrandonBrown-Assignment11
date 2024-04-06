package com.codercampus.Assignment11.web;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Controller
public class TransactionController {
	
	private final TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionController(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/transaction")
	public String getTransactions(ModelMap model) {
		List<Transaction> transactions = transactionRepository.findAll();
		transactions.sort(Comparator.comparing(Transaction::getDate));
		model.addAttribute("transactions",transactions);

		return "transactions";
	}
	
	
	

}
