package com.example.demo.serviceimpl;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepo;
import com.example.demo.service.IssueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepo issueRepository;

    @Override
    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    @Override
    public Issue getIssueById(int id) {
        return issueRepository.findById(id);
    }
    @Override
    public List<Issue> getIssuesByUserId(int userId) {
        return issueRepository.findByUserId(userId); // Calls the repository method
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public void deleteIssueById(int id) {
        issueRepository.deleteById(id);
    }
    @Override
    public void updateIssueReply(int id, String reply) {
        issueRepository.updateReply(id, reply); // Calls the repository method to update the reply
    }
}
