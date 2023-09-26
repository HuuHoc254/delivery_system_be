package com.delivery.repository;

import com.delivery.entity.TransportOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportOrderDetailRepository extends JpaRepository<TransportOrderDetailEntity, Long> {
}
