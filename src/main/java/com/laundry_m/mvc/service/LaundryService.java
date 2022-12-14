package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

public interface LaundryService {
	/**
	 *  세탁소 등록
 	 * 1. 세탁소 레코드 인서트 한다.
 	 * 2. 회원이 세탁소를 즐겨찾기를 한다면 즐겨찾기를 인서트한다.
 	 * 
	 * @param : Laundry laundry(세탁소 점포아이디, 아이디, 점포 이름, 점포 번호, 점포 주소, 수거비, 점주 계좌번호)
	 * @exception : DuplicationException(세탁소 id가 이미 존재할 경우 오류)
	 * 				NotLoginException(로그인 하지 않고 세탁소 가입할 경우 오류)
	 * 				NotExistException(점주 로그인 id, 세탁소 id DB에 존재하지 않을 경우 오류)
	 * 				NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */
	void insertLaundry(SqlSession session, Laundry laundry) throws SQLException, NotLoginException, DuplicationException, NotExistException, NotFilledInException;
	
	/**
	 *  세탁소 수정
	 *  @param : Laundry laundry(점포 이름, 점포 번호, 수거비, 점주 계좌번호)
	 *  @exception : NotloginException(로그인 하지 않고 세탁소 수정할 경우 오류)
	 *  			 NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 *  			 NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */
	void updateLaundry(Laundry laundry) throws SQLException, NotLoginException, NotExistException, NotFilledInException;
	
	/**
	 *  옷 추가 -- 옷 DB 기본으로 등록 필요한 과정??
	 *	1. 옷 테이블 레코드 인서트
	 * 	2. 세탁소 점포에서 가격표에 옷을 사용하면 가격레코드 인서트 
	 *  @exception: NotLoginException(로그인하지 않고 옷 추가를 시도할 경우 오류)
	 * 			    NotExistException(점포 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			    NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */	
	void insertClothes(Clothes clothes) throws SQLException, NotLoginException, NotExistException, NotFilledInException;
	
	/**
	 *  점포 가격 추가 
	 *  @param : Fee fee(가격 번호, 세탁소아이디, 옷 아이디, 가격)
	 *  @exception: NotLoginException(로그인하지 않고 점포가격 추가를 시도할 경우 오류)
	 * 			    NotExistException(점포 아이디나 회원 아이디 등이 DB에 존재하지 않을 경우 오류)
	 * 			    NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */	
	void insertFee(SqlSession session, Fee fee) throws SQLException, NotExistException, NotFilledInException;
	
	/**
	 *  점포 가격 갱신
	 *  @param : Fee fee(세탁소 아이디, 옷 아이디, 가격)
	 *  @exception : NotExistException(점포 아이디나 회원 아이디 등이 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 점포가격 추가를 시도할 경우 오류)
	 *  			 NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */	
	void updateFee(Fee fee) throws SQLException, NotExistException, NotFilledInException;
	
	/**
	 *  천 추가 -- 천 DB 기본으로 등록 필요한 과정??
	 *  @param : Fabric fabric(천 아이디, 천이름, 세탁방법)
	 */
	void insertFabric(Fabric fabric) throws SQLException;
	
	/**
	 *  추가가격 추가
	 *  @param : ExtraFee extraFee(추가가격 아이디, 천아이디, 점포 아이디, 가격)
	 *  @exception : NotExistException(점포 아이디나 회원 아이디 등이 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 점포가격 추가를 시도할 경우 오류)
	 *  			 NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */
	void insertExtraFee(SqlSession session, ExtraFee extraFee) throws SQLException, NotLoginException, NotFilledInException;
	
	/**
	 *  추가가격 수정: extra_fee 테이블 레코드 update
	 *  @param : ExtraFee extraFee(천아이디, 점포 아이디, 가격)
	 *  @exception : NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 *   			 NotLoginException(로그인하지 않고 점포가격 추가를 시도할 경우 오류)
	 *   			 NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */
	void updateExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 *  추가가격 삭제: extra_fee 테이블 레코드 delete
	 *  @return : ExtraFee extraFee
	 *  @exception : NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 점포가격 추가를 시도할 경우 오류)
	 *    			 InvalidUserException(점주가 아닐 경우 오류)
	 */
	void deleteExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, InvalidUserException;

	/**
	 *  세탁소 이름으로 찾기
	 *  @param : String LaundryName
	 *  @return : List<Laundry>
	 *  @exception : NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException, NotLoginException;
	
	/**
	 *  세탁소 주소로 찾기
	 *  @param : String LaundryAddress
	 *  @return : List<Laundry>
	 *  @exception : NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException, NotLoginException;
	
	/**
	 *  옷 가격 최저가 세탁소 검색
	 *  1. 옷 가격 검색 시 가격
	 *  2. 천 가격 검색 시 가격
	 *  3. 두 가격을 더한 값 order by 첫번째 값에 대한 점포아이디
	 *  @param : Long feeId, Long extraFeeId
	 *  @return : Laundry
	 *  @exception : NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	Laundry selectByLowestByLaundry(String userAddress, int feeId, int FabricId) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 * 특정 세탁소에서 옷 + 재질 가격 더하는 메소드
	 * */
	int clothesfabricFee(Long laundryId, int clothesId, int fabricId) throws SQLException, NotExistException, NotLoginException;;
	
	/**
	 * 회원 아이디로 세탁소 찾기
	 * */
	Laundry selectByUserId(String userId) throws SQLException, NotExistException, NotLoginException;;
	
	/**
	 * 회원 주소 - 세탁소 주소 사이 거리 구하기
	 * */
	int userBetweenLaun(Users users, Laundry laundry) throws SQLException, NotLoginException, NotExistException;
	
	/**
	 * 사용자 위치에서 세탁소 찾기
	 * */
	List<Laundry> selectByMyLaundry(String userAddress) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 * 천으로 세탁 방법 찾기
	 * */
	Fabric selectWashByFabric(int fabricId) throws SQLException, NotExistException, NotLoginException;

	/**
	 * 세탁소 메뉴 보기
	 * */
	Laundry selectAllFee(Long laundryId) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 * 세탁소 추가가격 메뉴 보기
	 * */
	Laundry selectAllExtraFees(Long laundryId) throws SQLException, NotExistException, NotLoginException;
	
}