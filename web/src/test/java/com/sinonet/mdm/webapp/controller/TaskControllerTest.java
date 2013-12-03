package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Task;

import com.sinonet.mdm.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskControllerTest extends BaseControllerTestCase {
    @Autowired
    private TaskController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("taskList"));
        assertTrue(((List) m.get("taskList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        GenericManager<Task, Long> taskManager = (GenericManager<Task, Long>) applicationContext.getBean("taskManager");
        taskManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("taskList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}