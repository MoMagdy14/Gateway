package com.bm.internship.gateway.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "device")
public class Device {
    public static enum Status {
        Online, Offline
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long UID;

    @Column(name = "vendor", length = 50, nullable = false)
    private String vendor;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "status", nullable = false)
    private Status status;

    @JoinColumn(name = "gateway_serial")
    @JsonIgnore
    @ManyToOne
    private Gateway gateway;
}
