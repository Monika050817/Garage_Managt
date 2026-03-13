package org.m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.m.entity.Invoice;
import org.m.repository.InvoiceRepository;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable int id, @RequestBody Invoice invoice) {
        invoice.setInvoiceId(id);
        return invoiceRepository.save(invoice);
    }

    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable int id) {
        invoiceRepository.deleteById(id);
        return "Invoice Deleted Successfully";
    }
}