package com.attractor.lesson_49.entity;

public class CandidatePercentVote {
    private final String name;

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    private final String photo;
    private final Integer votes;

    public CandidatePercentVote(Candidate person, Integer votes) {
        this.name = person.getName();
        this.photo = person.getPhoto();
        this.votes = votes;
    }

    public static CandidatePercentVote make(Candidate person, Integer votes) {
        return new CandidatePercentVote(person, votes);
    }

    public Integer getVotes() {
        return votes;
    }
}
