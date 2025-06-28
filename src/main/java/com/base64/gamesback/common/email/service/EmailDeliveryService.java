package com.base64.gamesback.common.email.service;

import com.base64.gamesback.common.email.dto.EmailRequest;

public interface EmailDeliveryService {

    void send(EmailRequest request);
}
