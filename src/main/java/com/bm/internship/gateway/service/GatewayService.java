package com.bm.internship.gateway.service;

import com.bm.internship.gateway.entity.Device;
import com.bm.internship.gateway.entity.Gateway;
import com.bm.internship.gateway.repository.DeviceRepository;
import com.bm.internship.gateway.repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GatewayService {
    @Autowired
    private GatewayRepository gatewayRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Gateway> getAllGateway() {
        return (List<Gateway>) gatewayRepository.findAll();
    }

    public Gateway getGatewayById(String serialNumber) {
        return gatewayRepository.findById(serialNumber).get();
    }

    public Gateway CreateNewGateway(Gateway newGateway) {
        if (newGateway != null) {
            return gatewayRepository.save(newGateway);
        }
        return null;
    }

    public boolean deleteGatewayById(String serialNumber) {
        if (serialNumber != null) {
            gatewayRepository.deleteById(serialNumber);
            return true;
        }
        return false;
    }

    public boolean addDeviceToGateway(String serialNumber, Long deviceId) {
        if (serialNumber != null && deviceId != null) {
            Device device = deviceRepository.findById(deviceId).get();
            device.setGateway(gatewayRepository.findById(serialNumber).get());
            deviceRepository.save(device);
            return true;
        }
        return false;
    }
}
