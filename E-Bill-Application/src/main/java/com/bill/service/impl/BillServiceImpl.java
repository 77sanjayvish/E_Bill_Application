package com.bill.service.impl;

import com.bill.entity.Bill;
import com.bill.entity.User;
import com.bill.repository.BillRepository;
import com.bill.repository.UserRepository;
import com.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;
    
    public Bill createBill(Bill bill) {
        // Check if the user exists
        User user = userRepository.findById(bill.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + bill.getUser().getId()));

        bill.setUser(user); // Ensure the user is properly set
        return billRepository.save(bill);
    }
    
    @Override
    public List<Bill> getBillsByUserId(Long userId) {
        List<Bill> bills = billRepository.findByUserId(userId);
        if (bills.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bills found for user with ID: " + userId);
        }
        return bills;
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found with ID: " + id));
    }

    @Override
    public Bill updateBill(Long id, Bill billDetails) {
        Bill bill = getBillById(id);
        bill.setUnitsConsumed(billDetails.getUnitsConsumed());
        bill.setAmountDue(billDetails.getAmountDue());
        bill.setDueDate(billDetails.getDueDate());
        bill.setBillStatus(billDetails.getBillStatus());
        return billRepository.save(bill);
    }

    @Override
    @Transactional
    public void deleteBill(Long id) {
        if (!billRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found with ID: " + id);
        }
        billRepository.deleteById(id);
    }
}
