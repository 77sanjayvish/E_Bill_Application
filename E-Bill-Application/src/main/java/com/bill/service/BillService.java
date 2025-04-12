package com.bill.service;

import com.bill.entity.Bill;
import java.util.List;

public interface BillService {

    Bill createBill(Bill bill);

    List<Bill> getBillsByUserId(Long userId);

    Bill getBillById(Long id);

    Bill updateBill(Long id, Bill billDetails);

    void deleteBill(Long id);
}
