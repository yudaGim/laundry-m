package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Entity
public class Fee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "fee_id_seq")
	@SequenceGenerator(sequenceName = "fee_id_seq" , allocationSize = 1 , name = "fee_id_seq")
	private Long feeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laundry_id")
	private Laundry laundry;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clothes_id")
	private Clothes clothes;
	
	private int clothesFee;
	
	@Builder
	public Fee(Long feeId, Laundry laundry, Clothes clothes, int clothesFee) {
		super();
		this.feeId = feeId;
		this.laundry = laundry;
		this.clothes = clothes;
		this.clothesFee = clothesFee;
	}
}
