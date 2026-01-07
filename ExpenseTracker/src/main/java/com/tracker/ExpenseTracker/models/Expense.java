package com.tracker.ExpenseTracker.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Double amount;
    private String category;
    private String description;
    private LocalDate expenseDate;
    private String paymentMethod;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
