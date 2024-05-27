package com.backend.interview.entity;

import com.backend.interview.utils.GenerateId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "txns")
public class Txn {
    @Id
    private String txnId;

    private String customerName;
    private String service;
    private float amount;
    private float gst;
    private float commission;

    @PrePersist
    public void generateId() {
        if(txnId == null){
            txnId = GenerateId.generateUniqueId();
        }
    }
}
