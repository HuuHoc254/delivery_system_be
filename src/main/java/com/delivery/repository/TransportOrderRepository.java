package com.delivery.repository;

import com.delivery.entity.TransportOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportOrderRepository extends JpaRepository<TransportOrderEntity, Long> {
}
