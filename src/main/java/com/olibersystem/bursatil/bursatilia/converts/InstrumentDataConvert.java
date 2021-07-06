package com.olibersystem.bursatil.bursatilia.converts;

import com.olibersystem.bursatil.bursatilia.dtos.etoro.InstrumentDataRequestDTO;
import com.olibersystem.bursatil.bursatilia.model.etoro.InstrumentData;
import org.springframework.stereotype.Component;

@Component
public class InstrumentDataConvert {

    public static InstrumentData entityToRequestDTO(InstrumentDataRequestDTO request) {
        return InstrumentData.builder()
                .instrumentID(request.getInstrumentID())
                .exchangeID(request.getExchangeID())
                .instrumentDisplayName(request.getInstrumentDisplayName())
                .instrumentTypeID(request.getInstrumentTypeID())
                .symbolFull(request.getSymbolFull())
                .build();
    }
}
