package com.bm.internship.gateway.service;

import com.bm.internship.gateway.entity.Device;
import com.bm.internship.gateway.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public Device createNewDevice(Device newDevice) {
        if (newDevice != null) {
            return deviceRepository.save(newDevice);
        }
        return null;
    }

    public boolean deleteDeviceById(Long UID) {
        if (UID != null) {
            deviceRepository.deleteById(UID);
            return true;
        }
        return false;
    }

}
