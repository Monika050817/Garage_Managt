package org.m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.m.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}