package com.tracker.ExpenseTracker.service;

import com.tracker.ExpenseTracker.models.Expense;
import com.tracker.ExpenseTracker.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public  void deleteExpense(Long id) {
        expenseRepo.deleteById(id);
    }

    public void createExpense(Double amount, String category, String paymentMethod, String description) {
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setPaymentMethod(paymentMethod);
        expense.setDescription(description);
        expenseRepo.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepo.findAll();
    }


    public void editExpense(Long id, Double amount, String category, String paymentMethod, String description) {
        Expense expense = expenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setId(id);
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setPaymentMethod(paymentMethod);
        expense.setDescription(description);
        expenseRepo.save(expense);
    }


}
