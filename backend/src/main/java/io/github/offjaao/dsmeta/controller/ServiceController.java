package io.github.offjaao.dsmeta.controller;


import io.github.offjaao.dsmeta.entity.Sale;
import io.github.offjaao.dsmeta.service.SaleService;
import io.github.offjaao.dsmeta.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/sales"})
public class ServiceController {

    @Autowired
    private SaleService service;
    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> searchSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return service.searchSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }


}
