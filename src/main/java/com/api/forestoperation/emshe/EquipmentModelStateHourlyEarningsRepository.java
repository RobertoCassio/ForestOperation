package com.api.forestoperation.emshe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarningsModel, EquipmentModelStateHourlyEarningsPK>{
}
