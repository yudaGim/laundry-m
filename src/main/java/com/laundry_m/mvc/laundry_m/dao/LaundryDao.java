package com.laundry_m.mvc.laundry_m.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Clothes;
import com.laundry_m.mvc.domain.ExtraFee;
import com.laundry_m.mvc.domain.Fabric;
import com.laundry_m.mvc.domain.Fee;
import com.laundry_m.mvc.domain.Laundry;

public interface LaundryDao {
	/** 
	 * 	세탁소 등록: laundry 테이블 레코드 insert
	 * 	@param : Laundry laundry(세탁소 점포아이디, 아이디, 점포 이름, 점포 번호, 수거비용)
	 * 	@return : Laundry laundry
	 *  */
	int insertLaundry(Laundry laundry) throws SQLException;

	/** 
	 *  세탁소 수정: laundry 테이블 레코드 update
	 *  @param : Laundry laundry(세탁소 이름, 전화번호, 세탁소 주소)
	 *  @return : Laundry laundry
	 *  */
	int updateLaundry(Laundry laundry) throws SQLException;

	/** 
	 *  가격 추가: fee 테이블 레코드 insert
	 *  @param : Fee fee(가격 번호, 세탁소아이디, 옷 아이디, 가격)
	 *  @return : Fee fee
	 * */
	int insertFee(Fee fee) throws SQLException;

	/** 
	 *  가격 수정: fee 테이블 레코드 update
	 *  @param : Fee fee(세탁소 아이디, 옷 아이디, 가격)
	 *  @return : Fee fee
	 * */
	int updateFee(Fee fee) throws SQLException;

	/** 
	 *  옷 추가: clothes 테이블 레코드 insert
	 *  @param : Clothes clothes(옷 아이디, 옷 이름)
	 *  */
	int insertClothes(Clothes clothes) throws SQLException;

	/** 
	 * 	천 추가 
	 *  천 추가: fabric 테이블 레코드 insert
	 *  @param : Fabric fabric(천 아이디, 천이름, 세탁방법)*  
	 * */
	int insertFabric(Fabric fabric) throws SQLException;

	/** 
	 *  추가가격 추가: extra_fee 테이블 레코드 insert
	 *  @param : ExtraFee extraFee(추가가격 아이디, 천아이디, 점포 아이디, 가격) 
	 *  */
	int insertExtraFee(ExtraFee extrafee) throws SQLException;

	/** 
	 *  추가가격 수정: extra_fee 테이블 레코드 update
	 *  @param : ExtraFee extraFee(천아이디, 점포 아이디, 가격)
	 * */
	int updateFee(ExtraFee extrafee) throws SQLException;

	/** 
	 * 	추가가격 삭제
	 *  추가가격 삭제: extra_fee 테이블 레코드 delete
	 *  @return : ExtraFee extraFee 
	 *  */
	int deleteFee(ExtraFee extrafee) throws SQLException;

	/** 
	 *  세탁소 이름으로 찾기
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<Laundry>
	 * */
	List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException;

	/** 
	 * 세탁소 주소 찾기
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<Laundry>
	 *  */
	List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException;

}