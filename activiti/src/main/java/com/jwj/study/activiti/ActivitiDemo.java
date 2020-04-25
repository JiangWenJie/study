package com.jwj.study.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;

/**
 * @ClassName ActivitiDemo
 * @Description TODO
 * @Author wenjiejiang
 * @Date 2020/4/25 15:01
 * @Version 1.0
 */
public class ActivitiDemo {
    public static void main(String[] args) {
        ActivitiDemo activitiDemo=new ActivitiDemo();
        //创建一个流程引擎的配置信息
        ProcessEngineConfiguration cfg=activitiDemo.buildProcessEngineConfiguration();

        // 创建流程引擎后会生成数据库schema，并在表act_ge_property插入数据，该表以key-value的形式存储数据，内容如下
        // cfg.execution-related-entities-count:false  先忽略此属性
        // next.dbid:1   下一个主键ID
        // schema.version:6.0.0.4  当前数据库版本
        // schema.history:create(5.22.0.0) upgrade(5.22.0.0->6.0.0.4) 数据库升级历史
        ProcessEngine processEngine=cfg.buildProcessEngine();
        System.out.println("构建流程引擎: "+processEngine.getName());

        //获取仓储服务
        RepositoryService repositoryService=processEngine.getRepositoryService();
        Deployment deployment=repositoryService.createDeployment().addClasspathResource("onboarding.bpmn20.xml").deploy();

    }

    //创建一个流程引擎的配置信息
    private ProcessEngineConfiguration buildProcessEngineConfiguration(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useSSL=false&serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("123456")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                // 这里需要注意，此处值有三种,schema是指数据库的组织和结构，包括表、关系、视图和存储过程等。
                // false:在创建流程引擎（ProcessEngine）时，对照库检查数据库schema的版本，如果版本不匹配，则引发异常。
                // true:在构建流程引擎（ProcessEngine）时，将执行检查并在必要时执行schema的更新。如果该schema不存在，则会创建它。
                // create-drop:在创建流程引擎（ProcessEngine）时创建schema，并在关闭流程引擎（ProcessEngine）时删除schema。
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return cfg;
    }


}
