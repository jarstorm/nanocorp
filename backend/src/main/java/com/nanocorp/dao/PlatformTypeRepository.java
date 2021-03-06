package com.nanocorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanocorp.bean.db.PlatformType;

/**
 * PlatformType repository object
 */
@Repository
public interface PlatformTypeRepository extends JpaRepository<PlatformType, Long> {

}