package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.webapp.controller.BaseControllerTestCase;
import com.sinonet.mdm.model.Task;
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

public class TaskFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private TaskFormController form;
    private Task task;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/taskform");
        request.addParameter("id", "-1");

        task = form.showForm(request);
        assertNotNull(task);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/taskform");
        request.addParameter("id", "-1");

        task = form.showForm(request);
        assertNotNull(task);

        request = newPost("/taskform");

        task = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(task).getBindingResult();
        form.onSubmit(task, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/taskform");
        request.addParameter("delete", "");
        task = new Task();
        task.setId(-2L);

        BindingResult errors = new DataBinder(task).getBindingResult();
        form.onSubmit(task, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
