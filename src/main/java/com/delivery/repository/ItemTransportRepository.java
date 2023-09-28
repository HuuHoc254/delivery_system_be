package com.delivery.repository;

import com.delivery.entity.ItemTransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTransportRepository extends JpaRepository<ItemTransportEntity, Long> {
}
