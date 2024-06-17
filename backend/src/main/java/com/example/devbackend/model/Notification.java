package com.example.devbackend.model;

import com.example.devbackend.utils.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Notification extends BaseEntity{

    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    private Timestamp createdDate;

    @OneToOne
    private Posts post;

    @OneToOne
    private Comment comment;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private Boolean read=false;
}

