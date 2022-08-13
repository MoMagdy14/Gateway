package com.bm.internship.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="device")
public class Device {
    @Id
    @Column(name="uid", length = 100)
    private int UID;
    @Column(name="vender", length = 50, nullable = false)
    private String vendor;
    private Date dateCreated;
    private String status;
}
