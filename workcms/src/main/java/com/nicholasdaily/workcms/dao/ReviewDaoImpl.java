package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao{
    EntityManager manager;

    ReviewDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public Review getReviewById(int id) {
        return manager.find(Review.class, id);
    }

    @Override
    public List<Review> getAllReviews() {
        TypedQuery<Review> query = manager.createQuery("FROM Review", Review.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createReview(Review review) {
        manager.persist(review);
    }

    @Override
    @Transactional
    public Review updateReview(Review review) {
        return manager.merge(review);
    }

    @Override
    @Transactional
    public void deleteReview(Review review) {
        deleteReviewById(review.getId());
    }

    @Override
    @Transactional
    public void deleteReviewById(int id) {
        Review tempReview = manager.find(Review.class, id);
        manager.remove(tempReview);
    }
}
