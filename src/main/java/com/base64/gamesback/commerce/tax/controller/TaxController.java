package com.base64.gamesback.commerce.tax.controller;

import com.base64.gamesback.commerce.tax.dto.TaxDto;
import com.base64.gamesback.commerce.tax.service.TaxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller(value = "tax")
@RequestMapping("/tax")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("/{taxId}")
    @Operation(description = "Get tax by id")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<TaxDto> getTaxById(@Valid @PathVariable UUID taxId) {
        return new ResponseEntity<>(taxService.findTaxById(taxId), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Operation(description = "Create Tax")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> createTax(@Valid @RequestBody TaxDto taxDto) {
        taxService.createTax(taxDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{taxId}")
    @Operation(description = "Update tax")
    @ApiResponse(responseCode = "204", description = "Update")
    public ResponseEntity<HttpStatus> updateTax(@Valid @PathVariable UUID taxId, @RequestBody TaxDto taxDto){
        taxService.updateTax(taxId, taxDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    @Operation(description = "Get all taxes")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<List<TaxDto>> getAllTaxes() {
        return new ResponseEntity<>(taxService.getAllTaxes(), HttpStatus.OK);
    }

    @DeleteMapping("/{taxId}")
    @Operation(description = "Delete tax by id")
    @ApiResponse(responseCode = "204", description = "delete")
    public ResponseEntity<HttpStatus> deleteTaxById(@Valid @PathVariable UUID taxId) {
        taxService.deleteTax(taxId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
