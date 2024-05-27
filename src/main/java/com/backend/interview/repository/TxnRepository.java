package com.backend.interview.repository;

import com.backend.interview.entity.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TxnRepository extends JpaRepository<Txn, String> {
    List<Txn> findByAmountBetween(float initialRange, float finalRange);
    List<Txn> findAllByOrderByAmountAsc();
}
