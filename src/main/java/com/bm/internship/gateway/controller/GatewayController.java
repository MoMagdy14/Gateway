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

    @GetMapping(value="/getById")
    public Gateway getGatewayById(@RequestParam String id) {
        return gatewayService.getGatewayById(id);
    }

    @PostMapping(value = "/add")
    public Gateway createNewGateway(@RequestParam Gateway newGateway) {
        return gatewayService.CreateNewGateway(newGateway);
    }

    @DeleteMapping(value = "/del/{gatewayId}")
    public boolean deleteGatewayById(@PathVariable(value = "gatewayId") String id) {
        return gatewayService.deleteGatewayById(id);
    }

    @PostMapping(value = "/addDevice")
    public boolean addDeviceToGateway(@RequestBody String gatewaySerialNumber,
                                      @RequestBody Long deviceId) {
        return gatewayService.addDeviceToGateway(gatewaySerialNumber, deviceId);
    }

}
