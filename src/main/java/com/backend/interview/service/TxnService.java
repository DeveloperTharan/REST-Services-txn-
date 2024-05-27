package com.backend.interview.service;

import com.backend.interview.entity.Txn;
import com.backend.interview.repository.TxnRepository;
import com.backend.interview.req_res.TxnRequest;
import com.backend.interview.req_res.TxnResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TxnService {
    private final TxnRepository repository;

    public TxnResponse addTxn(TxnRequest request) {
        if(request.getAmount() < 0){
            throw new IllegalArgumentException("Amount must not be less than 0");
        }

        Txn txn;

        if(request.getAmount() == 0){
            txn = Txn.builder()
                    .customerName(request.getCustomerName())
                    .service(request.getService())
                    .amount(request.getAmount())
                    .gst(0)
                    .commission(0)
                    .build();
        } else {
            txn = Txn.builder()
                    .customerName(request.getCustomerName())
                    .service(request.getService())
                    .amount(request.getAmount())
                    .gst(request.getGst())
                    .commission(request.getCommission())
                    .build();
        }

        repository.save(txn);

        return TxnResponse.builder()
                .txnId(txn.getTxnId())
                .customerName(txn.getCustomerName())
                .service(txn.getService())
                .amount(txn.getAmount())
                .gst(txn.getGst())
                .commission(txn.getCommission())
                .build();
    }

    public List<Txn> getTxnsByAmountRange(float initialRange, float finalRange) {
        return repository.findByAmountBetween(initialRange, finalRange);
    }

    public List<Txn> getAllTxnsSortedByAmount() {
        return repository.findAllByOrderByAmountAsc();
    }
}
