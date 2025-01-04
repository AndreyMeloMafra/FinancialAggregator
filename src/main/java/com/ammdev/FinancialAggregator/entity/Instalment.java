package com.ammdev.FinancialAggregator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "instalment")
@Deprecated
public class Instalment {

    @Id
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "start_date", nullable = false)
    private Date startDate;
}
