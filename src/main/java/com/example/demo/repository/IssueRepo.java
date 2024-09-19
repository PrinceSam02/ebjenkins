package com.example.demo.repository;

import com.example.demo.model.Issue;
import java.util.List;

public interface IssueRepo {
    void save(Issue issue);
    Issue findById(int id);
    List<Issue> findAll();
    void deleteById(int id);
    void updateReply(int id, String reply);
    List<Issue> findByUserId(int userId);
}
