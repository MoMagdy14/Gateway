package com.bm.internship.gateway.service;

import com.bm.internship.gateway.entity.Device;
import com.bm.internship.gateway.entity.Gateway;
import com.bm.internship.gateway.repository.DeviceRepository;
import com.bm.internship.gateway.repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class GatewayService {
    @Autowired
    private GatewayRepository gatewayRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Gateway> getAllGateway() {
        return (List<Gateway>) gatewayRepository.findAll();
    }

    public Gateway getGatewayBySerialNumber(String serialNumber) {
        return gatewayRepository.findById(serialNumber).get();
    }

    public Gateway CreateNewGateway(Gateway newGateway) {
        if (newGateway != null) {
            String ip = newGateway.getIpv4();
            String arr[] = ip.split("\\.");
            if (arr.length != 4) {
                return null;
            }
            for (int i = 0; i < arr.length; i++) {
                int value = Integer.parseInt(arr[i]);
                if (value > 255 || value < 0) {
                    return null;
                }
            }
            return gatewayRepository.save(newGateway);
        }
        return null;
    }

    public boolean deleteGatewayBySerialNumber(String serialNumber) {
        if (serialNumber != null) {
            gatewayRepository.deleteById(serialNumber);
            return true;
        }
        return false;
    }

    public boolean addDeviceToGateway(String serialNumber, Long deviceId) {
        if (serialNumber != null && deviceId != null) {
            Device device = deviceRepository.findById(deviceId).get();
            Gateway gateway = gatewayRepository.findById(serialNumber).get();
            if (gateway.getDevices().size() < 10) {
                device.setGateway(gateway);
            }
            else {
                return false;
            }
            deviceRepository.save(device);
            return true;
        }
        return false;
    }
}
