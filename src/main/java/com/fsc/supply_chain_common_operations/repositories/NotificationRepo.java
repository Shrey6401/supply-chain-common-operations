package com.fsc.supply_chain_common_operations.repositories;

import com.fsc.supply_chain_common_operations.Models.Notification;
import com.fsc.supply_chain_common_operations.enums.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, UUID> {

    public List<Notification> findByNotificationStatus(NotificationStatus notificationStatus);
}
