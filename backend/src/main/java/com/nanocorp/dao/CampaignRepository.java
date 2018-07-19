package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.Campaign;

/**
 * Campaign repository object
 */
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}