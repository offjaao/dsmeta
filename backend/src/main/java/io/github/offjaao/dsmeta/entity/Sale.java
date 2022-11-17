package io.github.offjaao.dsmeta.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_sales")
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sellerName;
    private int visited;
    private int deals;
    private double amount;
    private LocalDate date;




}
