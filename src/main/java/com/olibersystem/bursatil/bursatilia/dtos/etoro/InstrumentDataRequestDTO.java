package com.olibersystem.bursatil.bursatilia.dtos.etoro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties
public class InstrumentDataRequestDTO implements Serializable {
    @JsonProperty("InstrumentID")
    private Long instrumentID;
    @JsonProperty("InstrumentDisplayName")
    private String instrumentDisplayName;
    @JsonProperty("InstrumentTypeID")
    private Long instrumentTypeID;
    @JsonProperty("ExchangeID")
    private Long exchangeID;
    @JsonProperty("SymbolFull")
    private String symbolFull;
    @JsonProperty("PriceSource")
    private String priceSource;
    @JsonProperty("HasExpirationDate")
    private Boolean hasExpirationDate;
    @JsonProperty("IsInternalInstrument")
    private Boolean isInternalInstrument;
}
