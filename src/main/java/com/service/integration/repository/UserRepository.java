package com.service.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.integration.modal.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	@Query("FROM UserDetails t where t.name = :name") 
	UserDetails findUserByName(@Param("name") String name);
}
