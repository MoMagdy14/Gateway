package com.bm.internship.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="device")
public class Device {
    public static enum Status {
        Online, offline
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid", length = 100)
    private Long UID;

    @Column(name="vender", length = 50, nullable = false)
    private String vendor;

    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private Date dateCreated;

    @Column(name="status", nullable = false)
    private Status status;
}
