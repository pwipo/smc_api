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
     * @param configurationTool
     * @throws ModuleException
     */
    void start(ConfigurationTool configurationTool) throws ModuleException;

    /**
     * main method. call every time when need execute
     *
     * @param configurationTool
     * @param executionContextTool
     * @throws ModuleException
     */
    void process(ConfigurationTool configurationTool, ExecutionContextTool executionContextTool) throws ModuleException;

    /**
     * call then need update
     *
     * @param configurationTool
     * @throws ModuleException
     */
    void update(ConfigurationTool configurationTool) throws ModuleException;

    /**
     * call once per process on stop
     *
     * @param configurationTool
     * @throws ModuleException
     */
    void stop(ConfigurationTool configurationTool) throws ModuleException;

}
