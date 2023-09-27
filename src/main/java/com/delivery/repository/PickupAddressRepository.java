package com.delivery.repository;

import com.delivery.entity.PickupAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupAddressRepository extends JpaRepository<PickupAddressEntity, Long> {
}
