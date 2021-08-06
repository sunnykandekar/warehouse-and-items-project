package com.WarehousePro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WarehousePro.entities.item;

@Repository
public interface itemRepository  extends JpaRepository<item,Integer>
{


}
