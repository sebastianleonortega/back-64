package com.base64.gamesback.commerce.commerce.controller;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller(value = "commerce")
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
}
