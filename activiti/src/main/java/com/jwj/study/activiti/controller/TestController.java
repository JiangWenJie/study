package com.jwj.study.activiti.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
@Controller
public class TestController {
    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @RequestMapping("/test")
    public void testActiviti(){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", "Kermit");
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");
        ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("onboarding",variables);
        Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId(),variables);

    }
}
