package com.tracker.ExpenseTracker.repository;

import com.tracker.ExpenseTracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}