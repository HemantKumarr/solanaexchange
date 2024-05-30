package com.solanaexchange.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="LOGIN_HISTORY")
@Data
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private String id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="LOGIN_TIME")
    private Long loginTime;
    @Column(name="IP_ADDR")
    private String ipAddr;
    @Column(name="DEVICE_NAME")
    private String deviceName;
    @Column(name="LOCATION")
    private String location;
}
