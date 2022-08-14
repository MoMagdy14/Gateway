package com.bm.internship.gateway.repository;

import com.bm.internship.gateway.entity.Gateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GatewayRepository extends CrudRepository<Gateway, String> {
}
