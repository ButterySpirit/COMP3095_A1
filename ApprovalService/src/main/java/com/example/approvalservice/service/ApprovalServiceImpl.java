package com.example.approvalservice.service;

import com.example.approvalservice.model.Approval;
import com.example.approvalservice.model.ApprovalStatus;
import com.example.approvalservice.repository.ApprovalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {

    private final ApprovalRepository approvalRepository;

    @Override
    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    @Override
    public Approval getApprovalById(String id) {
        return approvalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));
    }

    @Override
    public List<Approval> getApprovalsByRequesterId(Long requesterId) {
        return approvalRepository.findByRequesterId(requesterId);
    }

    @Override
    public List<Approval> getApprovalsByApproverId(Long approverId) {
        return approvalRepository.findByApproverId(approverId);
    }

    @Override
    public List<Approval> getApprovalsByStatus(ApprovalStatus status) {
        return approvalRepository.findByStatus(status);
    }

    @Override
    public Approval updateApproval(String id, Approval approvalDetails) {
        Approval approval = getApprovalById(id);

        approval.setStatus(approvalDetails.getStatus());
        approval.setApprovalNotes(approvalDetails.getApprovalNotes());
        approval.setRejectionReason(approvalDetails.getRejectionReason());
        approval.setProcessedAt(approvalDetails.getProcessedAt());

        return approvalRepository.save(approval);
    }

    @Override
    public void deleteApproval(String id) {
        approvalRepository.deleteById(id);
    }
}
