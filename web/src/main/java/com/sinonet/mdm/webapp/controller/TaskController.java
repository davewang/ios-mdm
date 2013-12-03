package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.dao.SearchException;
import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tasks*")
public class TaskController {
    private GenericManager<Task, Long> taskManager;

    @Autowired
    public void setTaskManager(@Qualifier("taskManager") GenericManager<Task, Long> taskManager) {
        this.taskManager = taskManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(taskManager.search(query, Task.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(taskManager.getAll());
        }
        return model;
    }
}
