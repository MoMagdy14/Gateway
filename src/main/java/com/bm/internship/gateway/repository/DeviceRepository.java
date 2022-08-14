package com.bm.internship.gateway.repository;

import com.bm.internship.gateway.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
}
