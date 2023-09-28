package com.delivery.repository;

import com.delivery.entity.RawEcommerceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawEcommerceOrderRepository extends JpaRepository<RawEcommerceOrderEntity, Long> {
}
