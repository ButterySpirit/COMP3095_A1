package com.example.approvalservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Document(collection = "approvals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Approval {
    @Id
    private String id;

    @Indexed
    private String eventId;

    @Indexed
    private String bookingId;

    @Indexed
    private Long requesterId;
    private String requesterName;
    private String requesterEmail;
    private RequesterRole requesterRole;

    @Indexed
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

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime processedAt;
}