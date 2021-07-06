package com.olibersystem.bursatil.bursatilia.converts;

import com.olibersystem.bursatil.bursatilia.Util;
import com.olibersystem.bursatil.bursatilia.dtos.etoro.candles.CandleDTO;
import com.olibersystem.bursatil.bursatilia.dtos.etoro.candles.CandleValueDTO;
import com.olibersystem.bursatil.bursatilia.model.etoro.Candles;

public class CandleConvert {

    public static Candles toRequestDTO(CandleValueDTO candleDTO) {
        return Candles.builder()
                .instrumentID(candleDTO.getInstrumentID())
                .close(candleDTO.getClose())
                .fromDate(candleDTO.getFromDate())
                .fromDateLong(Util.createTimestampStringLong(candleDTO.getFromDate()))
                .high(candleDTO.getHigh())
                .low(candleDTO.getLow())
                .open(candleDTO.getOpen())
                .build();

    }

}
