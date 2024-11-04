package com.example.approvalservice.repository;

import com.example.approvalservice.model.Approval;
import com.example.approvalservice.model.ApprovalStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApprovalRepository extends MongoRepository<Approval, String> {
    List<Approval> findByRequesterId(Long requesterId);
    List<Approval> findByApproverId(Long approverId);
    List<Approval> findByStatus(ApprovalStatus status);
}
