package com.example.approvalservice.controller;

import com.example.approvalservice.dto.ApprovalRequest;
import com.example.approvalservice.model.Approval;
import com.example.approvalservice.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.approvalservice.model.ApprovalStatus;


import java.util.List;

@RestController
@RequestMapping("/api/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;

    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody ApprovalRequest approvalRequest) {
        Approval approval = mapToApproval(approvalRequest);
        return new ResponseEntity<>(approvalService.createApproval(approval), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        return ResponseEntity.ok(approvalService.getAllApprovals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable String id) {
        return ResponseEntity.ok(approvalService.getApprovalById(id));
    }

    @GetMapping("/requester/{requesterId}")
    public ResponseEntity<List<Approval>> getApprovalsByRequesterId(@PathVariable Long requesterId) {
        return ResponseEntity.ok(approvalService.getApprovalsByRequesterId(requesterId));
    }

    @GetMapping("/approver/{approverId}")
    public ResponseEntity<List<Approval>> getApprovalsByApproverId(@PathVariable Long approverId) {
        return ResponseEntity.ok(approvalService.getApprovalsByApproverId(approverId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Approval>> getApprovalsByStatus(@PathVariable ApprovalStatus status) {
        return ResponseEntity.ok(approvalService.getApprovalsByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable String id, @RequestBody ApprovalRequest approvalRequest) {
        Approval approvalDetails = mapToApproval(approvalRequest);
        return ResponseEntity.ok(approvalService.updateApproval(id, approvalDetails));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApproval(@PathVariable String id) {
        approvalService.deleteApproval(id);
    }

    private Approval mapToApproval(ApprovalRequest request) {
        return Approval.builder()
                .eventId(request.getEventId())
                .bookingId(request.getBookingId())
                .requesterId(request.getRequesterId())
                .requesterName(request.getRequesterName())
                .requesterEmail(request.getRequesterEmail())
                .requesterRole(request.getRequesterRole())
                .approverId(request.getApproverId())
                .approverName(request.getApproverName())
                .approverRole(request.getApproverRole())
                .status(request.getStatus())
                .eventName(request.getEventName())
                .eventStartTime(request.getEventStartTime())
                .eventEndTime(request.getEventEndTime())
                .roomId(request.getRoomId())
                .roomName(request.getRoomName())
                .requestNotes(request.getRequestNotes())
                .approvalNotes(request.getApprovalNotes())
                .rejectionReason(request.getRejectionReason())
                .processedAt(request.getProcessedAt())
                .build();
    }
}
