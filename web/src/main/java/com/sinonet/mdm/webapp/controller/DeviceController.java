package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.dao.SearchException;
import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/devices*")
public class DeviceController {
    private GenericManager<Device, Long> deviceManager;

    @Autowired
    public void setDeviceManager(@Qualifier("deviceManager") GenericManager<Device, Long> deviceManager) {
        this.deviceManager = deviceManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(deviceManager.search(query, Device.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(deviceManager.getAll());
        }
        return model;
    }
}
