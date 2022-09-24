package ru.smcsystem.api.module;

import ru.smcsystem.api.exceptions.ModuleException;
import ru.smcsystem.api.tools.ConfigurationTool;
import ru.smcsystem.api.tools.execution.ExecutionContextTool;

/**
 * Main module interface
 *
 * @version 1.0.0
 */
public interface Module {

    /**
     * call once per process on start
     *
     * @param configurationTool config tool
     * @throws ModuleException main exception
     */
    void start(ConfigurationTool configurationTool) throws ModuleException;

    /**
     * main method. call every time when need execute
     *
     * @param configurationTool    config tool
     * @param executionContextTool execution context tool
     * @throws ModuleException main exception
     */
    void process(ConfigurationTool configurationTool, ExecutionContextTool executionContextTool) throws ModuleException;

    /**
     * call then need update
     *
     * @param configurationTool config tool
     * @throws ModuleException main exception
     */
    void update(ConfigurationTool configurationTool) throws ModuleException;

    /**
     * call once per process on stop
     *
     * @param configurationTool config tool
     * @throws ModuleException main exception
     */
    void stop(ConfigurationTool configurationTool) throws ModuleException;

}
