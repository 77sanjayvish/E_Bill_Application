package com.bill.controller;

import com.bill.entity.Bill;
import com.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin("*") // Enables CORS for frontend access
public class BillController {

    @Autowired
    private BillService billService;

    // Create a new bill
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return ResponseEntity.status(201).body(billService.createBill(bill));
    }

    // Get bills by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bill>> getBillsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(billService.getBillsByUserId(userId));
    }

    // Get bill by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return ResponseEntity.ok(billService.getBillById(id));
    }

    // Update an existing bill
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill billDetails) {
        return ResponseEntity.ok(billService.updateBill(id, billDetails));
    }

    // Delete a bill
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully.");
    }
}
