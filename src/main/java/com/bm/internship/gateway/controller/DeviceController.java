package com.bm.internship.gateway.controller;

import com.bm.internship.gateway.entity.Device;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/device/v1")
public class DeviceController {
    @PostMapping(value = "/add")
    public Device createNewDevice() {
        return null;
    }

    @DeleteMapping(value = "/del/{deviceId}")
    public boolean deleteDevice(@PathVariable(value = "deviceId") Long UID) {
        return false;
    }
}
