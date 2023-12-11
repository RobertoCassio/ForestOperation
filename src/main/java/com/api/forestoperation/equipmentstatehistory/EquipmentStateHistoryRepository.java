package com.api.forestoperation.equipmentstatehistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistoryModel, EquipmentStateHistoryPK> {

}
