package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hcl.model.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}
