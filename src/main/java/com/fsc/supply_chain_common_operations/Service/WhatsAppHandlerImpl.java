package com.fsc.supply_chain_common_operations.Service;

import com.fsc.supply_chain_common_operations.Models.Notification;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppHandlerImpl implements NotificationHandler {
    @Override
    public Notification send(Notification notification) {
        return null;
    }
}