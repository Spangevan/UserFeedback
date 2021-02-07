package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Feedback;
import com.hcl.repository.FeedbackRepository;

@RestController
public class FeedbackController {
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index.html");
	}
	
	@GetMapping("/show")
	public ModelAndView getAllFeedback() {
		
		Iterable<Feedback> showFeedback;
		feedbackRepository.findAll();
		
		return new ModelAndView("show.html");
	}

	@PostMapping("/add")
	public Feedback postFeedBack(@RequestBody Feedback feedback) {
		logger.info(feedback.toString());

		return feedbackRepository.save(feedback);
	}

}
