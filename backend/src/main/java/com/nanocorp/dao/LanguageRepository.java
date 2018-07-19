package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Language;

/**
 * Language repository object
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

	@Query("from Language where code = :code")
	Language findByCode(@Param("code") String code);

}