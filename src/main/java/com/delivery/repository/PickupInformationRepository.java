package com.delivery.repository;

import com.delivery.entity.PickupInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupInformationRepository extends JpaRepository<PickupInformationEntity, Long> {
}
