package com.example.approvalservice.dto;

import com.example.approvalservice.model.ApprovalStatus;
import com.example.approvalservice.model.ApproverRole;
import com.example.approvalservice.model.RequesterRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApprovalRequest {
    private String eventId;
    private String bookingId;
    private Long requesterId;
    private String requesterName;
    private String requesterEmail;
    private RequesterRole requesterRole;
    private Long approverId;
    private String approverName;
    private ApproverRole approverRole;
    private ApprovalStatus status;
    private String eventName;
    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;
    private Long roomId;
    private String roomName;
    private String requestNotes;
    private String approvalNotes;
    private String rejectionReason;
    private LocalDateTime processedAt;  // Add this line
}
