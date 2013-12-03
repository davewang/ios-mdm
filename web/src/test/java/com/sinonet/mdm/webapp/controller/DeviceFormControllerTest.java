package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.webapp.controller.BaseControllerTestCase;
import com.sinonet.mdm.model.Device;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeviceFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private DeviceFormController form;
    private Device device;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/deviceform");
        request.addParameter("id", "-1");

        device = form.showForm(request);
        assertNotNull(device);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/deviceform");
        request.addParameter("id", "-1");

        device = form.showForm(request);
        assertNotNull(device);

        request = newPost("/deviceform");

        device = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(device).getBindingResult();
        form.onSubmit(device, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/deviceform");
        request.addParameter("delete", "");
        device = new Device();
        device.setId(-2L);

        BindingResult errors = new DataBinder(device).getBindingResult();
        form.onSubmit(device, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
