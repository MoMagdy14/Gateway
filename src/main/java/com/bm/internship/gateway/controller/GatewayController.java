package com.bm.internship.gateway.controller;

import com.bm.internship.gateway.entity.Gateway;
import com.bm.internship.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate/v1")
public class GatewayController {
    @Autowired
    private GatewayService gatewayService;
    @GetMapping(value="/all")
    public List<Gateway> getAllGateway() {
        return gatewayService.getAllGateway();
    }

    @GetMapping(value="/getBySerialNumber")
    public Gateway getGatewayBySerialNumber(@RequestParam String serialNumber) {
        return gatewayService.getGatewayBySerialNumber(serialNumber);
    }

    @PostMapping(value = "/add")
    public Gateway createNewGateway(@RequestBody Gateway newGateway) {
        return gatewayService.CreateNewGateway(newGateway);
    }

    @DeleteMapping(value = "/del/{gatewaySerialNumber}")
    public boolean deleteGatewayBySerialNumber(@PathVariable(value = "gatewaySerialNumber") String serialNumber) {
        return gatewayService.deleteGatewayBySerialNumber(serialNumber);
    }

    @GetMapping(value = "/addDevice")
    public boolean addDeviceToGateway(@RequestParam String gatewaySerialNumber,
                                      @RequestParam Long deviceId) {
        return gatewayService.addDeviceToGateway(gatewaySerialNumber, deviceId);
    }

}
