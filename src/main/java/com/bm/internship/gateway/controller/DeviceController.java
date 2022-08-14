package com.bm.internship.gateway.controller;

import com.bm.internship.gateway.entity.Device;
import com.bm.internship.gateway.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/device/v1")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @PostMapping(value = "/add")
    public Device createNewDevice(@RequestBody Device newDevice) {
        return deviceService.createNewDevice(newDevice);
    }

    @DeleteMapping(value = "/del/{deviceId}")
    public boolean deleteDeviceById(@PathVariable(value = "deviceId") Long UID) {
        return deviceService.deleteDeviceById(UID);
    }
}
