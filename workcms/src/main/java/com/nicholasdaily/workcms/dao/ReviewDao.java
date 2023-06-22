package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Review;

import java.util.List;

public interface ReviewDao {
    Review getReviewById(int id);

    List<Review> getAllReviews();

    void createReview(Review review);

    Review updateReview(Review review);

    void deleteReview(Review review);

    void deleteReviewById(int id);
}
