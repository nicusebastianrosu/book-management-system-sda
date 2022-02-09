package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Review;
import com.sda.nicurosu.bms.repository.BaseRepository;
import com.sda.nicurosu.bms.repository.BaseRepositoryImpl;
import com.sda.nicurosu.bms.repository.ReviewRepository;

public class ReviewRepositoryImpl extends BaseRepositoryImpl<Review, Integer> implements ReviewRepository {

    public ReviewRepositoryImpl() {
        super(Review.class);
    }
}
