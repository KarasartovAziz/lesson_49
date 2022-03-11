package com.attractor.lesson_49.controller;

import com.attractor.lesson_49.repository.CandidateRepository;
import com.attractor.lesson_49.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CandidateController {
    private final CandidateService service;
    private final CandidateRepository repository;

    public CandidateController(CandidateRepository repository, CandidateService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("candidates", repository.findAll());
        return "candidates";
    }

    @GetMapping("/votes")
    public String handleVotes(Model model) {
        model.addAttribute("candidates", service.candidatesWithVotes());
        return "votes";
    }

    @GetMapping("/thankyou/{candidateId}")
    public String handleThankYou(@PathVariable String candidateId, Model model) {
        var candidate = service.getById(candidateId);
        model.addAttribute("person", candidate);
        model.addAttribute("votes", service.calculatePercentForOne(candidate));

        return "thankyou";
    }

    @PostMapping("/vote")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String handleRegisterVote(@RequestParam(defaultValue = "--no-value--") String candidateId) {
        service.voteFor(candidateId);
        return "redirect:/thankyou/" + candidateId;
    }
}
