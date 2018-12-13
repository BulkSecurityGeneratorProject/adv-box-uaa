package com.devcircus.adventurebox.uaa.model.repository;

import com.devcircus.adventurebox.uaa.model.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
