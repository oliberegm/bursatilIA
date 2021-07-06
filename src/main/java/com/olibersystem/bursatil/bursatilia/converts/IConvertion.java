package com.olibersystem.bursatil.bursatilia.converts;

public interface  IConvertion <E, D> {

    public D convertToDto(E entity);

    public E convertToEntity(D dto);
}
