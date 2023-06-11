package com.example.practiceapis.Service;

import com.example.practiceapis.Model.Refund;
import com.example.practiceapis.Repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundService {

    @Autowired
    RefundRepository refundRepository;

    public int getMaximumRefund() {

        List<Refund> refundList = refundRepository.findAll();
        int userId = -1;
        int maxAmount = -1;

        for(Refund refund : refundList){
            if (refund.getAmount() > maxAmount){
                maxAmount = refund.getAmount();
                userId = refund.getUser().getUserId();
            }
        }
        return userId;
    }
}
