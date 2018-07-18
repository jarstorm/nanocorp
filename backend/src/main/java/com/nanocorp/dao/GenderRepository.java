package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

	@Query("from Gender where code = :code")
	Gender findByCode(@Param("code") String code);

}