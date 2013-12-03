package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Device;

import com.sinonet.mdm.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeviceControllerTest extends BaseControllerTestCase {
    @Autowired
    private DeviceController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("deviceList"));
        assertTrue(((List) m.get("deviceList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        GenericManager<Device, Long> deviceManager = (GenericManager<Device, Long>) applicationContext.getBean("deviceManager");
        deviceManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("deviceList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}