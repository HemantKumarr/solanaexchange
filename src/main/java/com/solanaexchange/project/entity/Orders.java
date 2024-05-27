package com.solanaexchange.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "AMOUNT")
    private String amount;
    @Column(name = "FROM_USER_EMAIL")
    private String fromUserEmail;
    @Column(name = "TO_USER_EMAIL")
    private String toUserEmail;
}
