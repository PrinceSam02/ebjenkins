package com.example.demo.service;

import com.example.demo.model.Issue;
import java.util.List;

public interface IssueService {
    void saveIssue(Issue issue);
    Issue getIssueById(int id);
    List<Issue> getAllIssues();
    void deleteIssueById(int id);
    void updateIssueReply(int id, String reply); 
    List<Issue> getIssuesByUserId(int userId); 
}
