package com.info.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.model.InfoModel;

public interface InfoRepository extends JpaRepository<InfoModel,Long>{

}
