package com.ammdev.FinancialAggregator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cost")
@Deprecated
public class Cost {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "value", nullable = false)
    private Double value;

    @OneToOne
    @JoinColumn(name = "instalment_id", nullable = true)
    private Instalment instalment;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
