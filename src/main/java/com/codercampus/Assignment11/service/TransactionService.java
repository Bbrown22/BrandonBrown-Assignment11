package com.codercampus.Assignment11.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	 private final TransactionRepository transactionRepository;

	    @Autowired
	    public TransactionService(TransactionRepository transactionRepository) {
	        this.transactionRepository = transactionRepository;
	    }

	    public List<Transaction> findAll() {
	        return transactionRepository.findAll().stream()
	                                    .sorted(Comparator.comparing(Transaction::getDate))
	                                    .collect(Collectors.toList());
	    }
	    public Transaction findById(Long id) {
	        return transactionRepository.findById(id);
	    }

}
