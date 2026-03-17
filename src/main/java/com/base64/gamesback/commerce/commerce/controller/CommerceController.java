package com.base64.gamesback.commerce.commerce.controller;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.repository.CommerceCriteriaRepository;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller(value = "commerce")
@RequestMapping("/commerce")
public class CommerceController {

    private final CommerceService commerceService;

    public CommerceController(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    @PostMapping("/")
    @Operation(description = "create commerce")
    @ApiResponse(responseCode = "204", description = "create")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody CommerceDto commerceDto){
        commerceService.createCommerce(commerceDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(description = "Get commerce by id")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<CommerceDto> getCommerceById(@Valid @PathVariable UUID id){
        return new ResponseEntity<>(commerceService.findCommerceById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation( description = "get all commerce")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<List<CommerceDto>> getAllCommerce(){
        return new ResponseEntity<>(commerceService.getAllCommerce(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update commerce")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<HttpStatus> updateCommerce(@Valid @PathVariable UUID id, @RequestBody CommerceDto commerceDto){
        commerceService.updateCommerce(id, commerceDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "delete commerce")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<HttpStatus> deleteCommerceById(@Valid @PathVariable UUID id){
        commerceService.deleteCommerceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
