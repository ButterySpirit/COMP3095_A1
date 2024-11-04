package com.example.approvalservice.service;

import com.example.approvalservice.model.Approval;
import com.example.approvalservice.model.ApprovalStatus;

import java.util.List;

public interface ApprovalService {
    Approval createApproval(Approval approval);
    Approval getApprovalById(String id);
    List<Approval> getApprovalsByRequesterId(Long requesterId);
    List<Approval> getApprovalsByApproverId(Long approverId);
    List<Approval> getApprovalsByStatus(ApprovalStatus status);
    Approval updateApproval(String id, Approval approvalDetails);
    void deleteApproval(String id);
}
