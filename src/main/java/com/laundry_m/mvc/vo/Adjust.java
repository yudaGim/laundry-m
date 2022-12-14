package com.laundry_m.mvc.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Adjust {
	private Long adjustId;
	private Long laundryId;
	private Long bookId;
	private Timestamp adjustInsertDate;
	
	private Laundry laundry;
	private Book book;
	
	@Builder
	public Adjust(Long adjustId, Long laundryId, Long bookId, Timestamp adjustInsertDate, Laundry laundry,
			Book book) {
		super();
		this.adjustId = adjustId;
		this.laundryId = laundryId;
		this.bookId = bookId;
		this.adjustInsertDate = adjustInsertDate;
		this.laundry = laundry;
		this.book = book;
	}
	
	
}
