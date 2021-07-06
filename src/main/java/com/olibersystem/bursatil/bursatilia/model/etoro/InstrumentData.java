package com.olibersystem.bursatil.bursatilia.model.etoro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instrument_data_etoro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrumentData {

	@Id
	private Long instrumentID;
	private Long exchangeID;
	private String instrumentDisplayName;
	private Long instrumentTypeID;
	private String symbolFull;



}
