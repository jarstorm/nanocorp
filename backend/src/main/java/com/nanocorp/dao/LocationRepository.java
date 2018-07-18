package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	@Query("from Location where code = :code")
	Location findByCode(@Param("code") String code);

}