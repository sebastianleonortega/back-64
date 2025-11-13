package com.base64.gamesback.common.email.service;

import com.base64.gamesback.commerce.commerce.dto.ActivateCommerceDto;

public interface EmailCommerceService {

    void sendEmailActivation(ActivateCommerceDto activateCommerceDto);
}
