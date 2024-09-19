package com.example.demo.controller;

import com.example.demo.model.Issue;
import com.example.demo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/insert")
    public void createIssue(@RequestBody Issue issue) {
        issueService.saveIssue(issue);
    }

    @GetMapping("/{id}")
    public Issue getIssue(@PathVariable int id) {
        return issueService.getIssueById(id);
    }

    @GetMapping("/all")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }
    @GetMapping("/user/{userId}")
    public List<Issue> getIssuesByUserId(@PathVariable int userId) {
        return issueService.getIssuesByUserId(userId);
    }
    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable int id) {
        issueService.deleteIssueById(id);
    }
    @PutMapping("/{id}/reply")
    public void updateIssueReply(@PathVariable int id, @RequestParam String reply) {
        issueService.updateIssueReply(id, reply);
    }
}
