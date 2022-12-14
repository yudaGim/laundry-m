package com.laundry_m.mvc.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class ExtraFee {
	private Long extraFeeId;
	private int fabricId;
	private Long laundryId;
	private int fabricFee;
	private char extraFeeOperation;
	
	private Fabric fabric;
	private Laundry laundry;
	
	@Builder
	public ExtraFee(Long extraFeeId, int fabricId, Long laundryId, int fabricFee, char extraFeeOperation,
			Fabric fabric, Laundry laundry) {
		super();
		this.extraFeeId = extraFeeId;
		this.fabricId = fabricId;
		this.laundryId = laundryId;
		this.fabricFee = fabricFee;
		this.extraFeeOperation = extraFeeOperation;
		this.fabric = fabric;
		this.laundry = laundry;
	}
	
	
	
}
