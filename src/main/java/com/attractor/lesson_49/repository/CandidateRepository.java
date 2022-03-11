package com.attractor.lesson_49.repository;

import com.attractor.lesson_49.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, String> { }
