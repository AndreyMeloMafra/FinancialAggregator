package com.ammdev.financialaggregator.entity.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "costs")
@Entity(name = "Cost")
@SecondaryTable(name = "instalments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CostEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String description;

        private Double value;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "instalment_id",
                table = "instalments",
                referencedColumnName = "id"
        )
        private InstalmentEntity instalment;

        private String date;

        @Enumerated(EnumType.STRING)
        private CostSource costSource;
}
