package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	
	// input: id
	// output: Review
	public Review getReviewById(int id) { // where절이 있는 경우 메소드명에 by를 붙인다.
		return reviewDAO.selectReviewById(id);
	}
	
	// return int : 인서트가 성공한 행의 개수
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "맛점맛저", 5.0, "짱맛탱 하루 한끼 뚝딱 순삭!!!")
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) { // point default값(3.5)이 있기 때문에 null 가능한 Double형으로 지정
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public int updateReviewById(int id, String review) {
		return reviewDAO.updateReviewById(id, review);
	}
	
	// input: 삭제할 id
	// output: X
	public void deleteReviewById(int id) {
		reviewDAO.deleteReviewById(id);
	}
}
