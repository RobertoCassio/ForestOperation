package com.api.forestoperation.emshe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface EquipmentModelStateHourlyEarningsRepository
		extends JpaRepository<EquipmentModelStateHourlyEarningsModel, EquipmentModelStateHourlyEarningsPK> {
}
