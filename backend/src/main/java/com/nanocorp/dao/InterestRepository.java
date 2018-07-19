package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Interest;

/**
 * Interest repository object
 */
@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

	@Query("from Interest where code = :code")
	Interest findByCode(@Param("code") String code);

}