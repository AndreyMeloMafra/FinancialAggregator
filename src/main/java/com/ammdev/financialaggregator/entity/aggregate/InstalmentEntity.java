package com.ammdev.financialaggregator.entity.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "instalments")
@Entity(name = "Instalment")
@SecondaryTable(name = "taxes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class InstalmentEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Integer number;

        private Double value;

        private String startDate;

        @Enumerated(EnumType.STRING)
        private CostType costType;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "tax_id",
                table = "taxes",
                referencedColumnName = "id"
        )
        private TaxEntity lateFee;
}
