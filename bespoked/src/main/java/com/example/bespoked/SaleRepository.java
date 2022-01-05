package com.example.bespoked;

import com.example.bespoked.Sale;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer>{
    @Query(value ="select *from sale where date(sale_date) > (curdate()-90);", nativeQuery = true)
    Iterable<Sale> findByQuarterlySale();
}
