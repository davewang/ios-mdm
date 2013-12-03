package com.sinonet.mdm.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Task;
import com.sinonet.mdm.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/taskform*")
public class TaskFormController extends BaseFormController {
    private GenericManager<Task, Long> taskManager = null;

    @Autowired
    public void setTaskManager(@Qualifier("taskManager") GenericManager<Task, Long> taskManager) {
        this.taskManager = taskManager;
    }

    public TaskFormController() {
        setCancelView("redirect:tasks");
        setSuccessView("redirect:tasks");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Task showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return taskManager.get(new Long(id));
        }

        return new Task();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Task task, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(task, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "taskform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (task.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            taskManager.remove(task.getId());
            saveMessage(request, getText("task.deleted", locale));
        } else {
            taskManager.save(task);
            String key = (isNew) ? "task.added" : "task.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:taskform?id=" + task.getId();
            }
        }

        return success;
    }
}
