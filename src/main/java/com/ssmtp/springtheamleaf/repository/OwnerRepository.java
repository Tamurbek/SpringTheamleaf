package com.ssmtp.springtheamleaf.repository;

import com.ssmtp.springtheamleaf.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {

}
