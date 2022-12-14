package com.laundry_m.mvc.view;

import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.BookController;
import com.laundry_m.mvc.controller.ReviewController;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.Review;


public class ReviewMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static ReviewController reviewController = new ReviewController();
	private static BookController bookController = new BookController();
	
	/**
	 * 리뷰 입력폼 메뉴
	 * */
	public static void reviewForm() {
		Long starRate;
		
			try {
				List<Book> books = bookController.existBook(10L, 10L);
				if (books == null || books.size() == 0) {
					System.out.println("예약 건이 없습니다.");
				} else {
					System.out.println(" 주문번호 | 아이디 | 수량 | 총금액 | 결제방법 | 주문시간 | 주문상태 | 메모 ");
					bookController.searchBookByUserId(10L, 10L); //수정
					System.out.println("리뷰 작성할 주문번호를 입력해주세요");
					System.out.print("▶ ");
					Long bookId = Long.parseLong(sc.nextLine());
					Review review = reviewController.searchReviewByBookId(bookId);
					if(review == null) {
						do {
							System.out.println("\n" + " 해당 주문 완료 건에 ★(별점)을 입력해주세요.");
							System.out.print("▶ ★x");
							starRate = (long) Integer.parseInt(sc.nextLine());
							if((starRate >= 6) || (starRate < 0)) {
								System.out.println("별점은 0~5 까지 입력해주세요.");
							}
						}while(starRate>5);
						
						System.out.println("\n" + " 리뷰를 입력해주세요");
						System.out.print("▶ ");
						String content = sc.nextLine();
						Review reviews = Review.builder().bookId(bookId)
								.reviewRate(starRate)
								.reviewContent(content).build();
						reviewController.createReview(reviews);
						
					}else if(review != null){
						FailView.errorMessage("해당 예약에 대한 리뷰를 이미 작성하셨습니다.");
					}
				}				
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}

	//리뷰 수정 form
	public static void reviewUpdateForm() {
		Long starRate;
		try {
			List<Review> existReview = reviewController.existReviewByUserId();
			if (existReview == null || existReview.size() == 0) {
				System.out.println("예약 건이 없습니다.");
			}else {
				reviewController.searchReviewByUserId();
				System.out.println("업데이트할 리뷰 번호를 입력해주세요.");
				System.out.print("▶ ");
				Long reviewId = (long)Integer.parseInt(sc.nextLine());
					do {
						System.out.println("\n" + " 해당 주문 완료 건에 ★(별점)을 입력해주세요.");
						System.out.print("▶ ★x");
						starRate = (long) Integer.parseInt(sc.nextLine());
						if((starRate > 6) || (starRate < 0)) {
							System.out.println("별점은 0~5 까지 입력해주세요.");
						}
					}while(starRate>5 && starRate >= 0);
					
					System.out.println("\n" + " 리뷰를 입력해주세요");
					System.out.print("▶ ");
					String content = sc.nextLine();
	
					Review reviews = Review.builder().reviewId(reviewId)
							.reviewRate(starRate)
							.reviewContent(content).build();
					
					reviewController.modifyReview(reviews);
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}

	public static void deleteForm() {
		boolean run = true;
		while (run) {
			List<Review> existReview = reviewController.existReviewByUserId();
			if(existReview==null || existReview.size()==0) {
				System.out.println("작성한 리뷰가 없습니다.");
				break;
			}else {
				try {
					reviewController.searchReviewByUserId();
					System.out.println("삭제할 리뷰 번호를 입력해주세요.");
					System.out.print("▶ ");
					Long reviewId = (long)Integer.parseInt(sc.nextLine());
					reviewController.deleteReview(reviewId);
					break;
				} catch (Exception e) {
					FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
				}
			}
		}
	}

}
