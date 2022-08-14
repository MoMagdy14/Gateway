package com.bm.internship.gateway.controller;

import com.bm.internship.gateway.entity.Gateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate/v1")
public class GatewayController {
    @GetMapping(value="/all")
    public List<Gateway> getAllGateway() {
        return null;
    }

    @GetMapping(value="/getById")
    public Gateway getGatewayById() {
        return null;
    }

    @PostMapping(value = "/add")
    public Gateway createNewGateway() {
        return null;
    }

    @DeleteMapping(value = "/del/{gatewayId}")
    public boolean deleteGateway(@PathVariable(value = "gatewayId") String id) {
        return false;
    }

    @GetMapping(value = "/addDevice")
    public boolean addDeviceToGateway() {
        return false;
    }

}
