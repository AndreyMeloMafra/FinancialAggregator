package com.ammdev.FinancialAggregator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
@Deprecated
public class User {

    private Long id;
    private String name;
    private String email;
}
