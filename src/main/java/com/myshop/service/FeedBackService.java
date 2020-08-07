package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.FeedBackDAO;
import com.myshop.entity.Feedback;

@Service
@Transactional
public class FeedBackService {

	@Autowired
	private FeedBackDAO feedbackDAO;
	
	public boolean save(final Feedback feedback) {
		return feedbackDAO.save(feedback);
	}
	
	public List<Feedback> getAll(){
		return feedbackDAO.getAll();
	}
	
//	public Feedback findById(int feedbackId) {
//		return feedbackDAO.findById(feedbackId);
//	}
}
