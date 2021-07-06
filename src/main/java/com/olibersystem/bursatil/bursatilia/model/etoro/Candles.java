package com.olibersystem.bursatil.bursatilia.model.etoro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "candles_etoro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long instrumentID;
    private String fromDate;
    private Long fromDateLong;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
}
