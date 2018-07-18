package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

	@Query("from Keyword where code = :code")
	Keyword findByCode(@Param("code") String code);

}