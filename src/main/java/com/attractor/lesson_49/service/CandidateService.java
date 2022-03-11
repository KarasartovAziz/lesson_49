package com.attractor.lesson_49.service;

import com.attractor.lesson_49.entity.Candidate;
import com.attractor.lesson_49.entity.CandidatePercentVote;
import com.attractor.lesson_49.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CandidateService {
    private final CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    private static int calculatePercent(double votes, int totalVotes) {
        if (totalVotes == 0) {
            return 0;
        }

        if (votes == 0) {
            return 0;
        }

        return (int) ((votes / totalVotes) * 100);
    }

    public void voteFor(String candidateId) {
        var c = repository.findById(candidateId).orElse(Candidate.EMPTY);
        c.vote();
        repository.save(c);
    }

    public Candidate getById(String candidateId) {
        return repository.findById(candidateId).orElse(Candidate.EMPTY);
    }

    private int getTotalVotes() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .mapToInt(Candidate::getVotes)
                .sum();
    }

    public int calculatePercentForOne(Candidate candidate) {
        var totalVotes = getTotalVotes();
        var votes = candidate.getVotes();

        return calculatePercent(votes, totalVotes);
    }

    public List<CandidatePercentVote> candidatesWithVotes() {
        var total = getTotalVotes();
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(c -> CandidatePercentVote.make(c, calculatePercent(c.getVotes(), total)))
                .sorted(Comparator.comparingInt(CandidatePercentVote::getVotes).reversed())
                .collect(Collectors.toList());
    }
}
