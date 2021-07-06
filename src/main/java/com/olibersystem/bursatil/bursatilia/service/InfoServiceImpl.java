package com.olibersystem.bursatil.bursatilia.service;

import com.olibersystem.bursatil.bursatilia.converts.InfoConver;
import com.olibersystem.bursatil.bursatilia.dtos.InfoResponseDTO;
import com.olibersystem.bursatil.bursatilia.practicas.Xor;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService{
    private final Xor xor;
    private final InfoConver infoConver;

    public InfoServiceImpl(Xor xor, InfoConver infoConver) {
        this.xor = xor;
        this.infoConver = infoConver;
    }

    @Override
    public InfoResponseDTO xorInfo(Double val1, Double val2) {
        Double result = xor.evaluate(val1, val2);
        return infoConver.infoResponseDTOToDouble(result);
    }
}
