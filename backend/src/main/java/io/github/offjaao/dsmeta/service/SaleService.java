package io.github.offjaao.dsmeta.service;

import io.github.offjaao.dsmeta.entity.Sale;
import io.github.offjaao.dsmeta.repository.SaleRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> searchSales(String minDate, String maxDate, Pageable pageable) {

        val today = LocalDate.now();
        val parsedMinDate = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        val parsedMaxDate = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.searchSales(parsedMinDate, parsedMaxDate, pageable);
    }


}
