package com.appdev.core.ocampog4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.core.ocampog4.entity.CalendarEntity;

/**
 * Repository interface for CalendarEntity.
 */
@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {
}