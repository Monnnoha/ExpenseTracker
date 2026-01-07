package com.tracker.ExpenseTracker.controller;

import com.tracker.ExpenseTracker.models.Expense;
import com.tracker.ExpenseTracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/add")
    public String showExpenseForm() {
        return "expense";
    }

    @PostMapping("/add")
    public String createExpense(
            @RequestParam Double amount,
            @RequestParam String category,
            @RequestParam String paymentMethod,
            @RequestParam String description
    ) {
        expenseService.createExpense(amount, category, paymentMethod, description);
        return "redirect:/add";
    }

    @GetMapping("/expenses")
    public String viewExpenses(Model model){
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);

        return "expenses";
    }

    @PostMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

    @PostMapping("/expenses/edit/{id}")
    public String updateExpense(@PathVariable Long id,
                              @RequestParam Double amount,
                              @RequestParam String category,
                              @RequestParam String paymentMethod,
                              @RequestParam String description){
        expenseService.editExpense(id, amount, category, paymentMethod, description);
        return "redirect:/expenses";
    }
}
