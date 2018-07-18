package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, String> {

	@Query("from Campaign")
	Campaign findByUsername(@Param("username") String username);
}