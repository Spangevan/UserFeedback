package com.hcl.service;


import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Feedback;
import com.hcl.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository repository;
	
	public Feedback createFeedback(Feedback feedback) {
		
		if(feedback.getId() != null) {
			Optional<Feedback> feedback2 = repository.findById(feedback.getId());
			
			if(feedback2.isPresent()) {
				Feedback newFeedback = feedback2.get();
				newFeedback.setFeedback(feedback.getFeedback());
				newFeedback.setId(feedback.getId());
				newFeedback.setRating(feedback.getRating());
				
				newFeedback = repository.save(newFeedback);
				
				return newFeedback;
			} else {
				feedback = repository.save(feedback);
				
				return feedback;
			}
		}
		
		else {
			feedback = repository.save(feedback);
			return feedback;
		}
		
		
		
	}

}
