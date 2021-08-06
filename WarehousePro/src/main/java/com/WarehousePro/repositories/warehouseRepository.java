package com.WarehousePro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WarehousePro.entities.warehouse;

@Repository
public interface warehouseRepository extends JpaRepository<warehouse,Integer>
{

}
