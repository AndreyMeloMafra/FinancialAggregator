package com.ammdev.financialaggregator.entity.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "taxes")
@Entity(name = "Tax")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TaxEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double value;

        private String currency;
}
