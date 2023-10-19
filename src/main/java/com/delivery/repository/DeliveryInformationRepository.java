package com.delivery.repository;

import com.delivery.entity.DeliveryInformationEntity;
import com.delivery.entity.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformationEntity, Long> {
    List<DeliveryInformationEntity> findAllByStatusIs(EStatus status);
    @Query("Select d From DeliveryInformationEntity d Where d.shipper.id = :shipperId And d.status = 'DELIVERING'")
    List<DeliveryInformationEntity> findTransportOrdersUnFinishedByShipperId(@Param("shipperId") Long shipperId);
}

