package ru.smcsystem.api.tools;

import ru.smcsystem.api.dto.IConfiguration;
import ru.smcsystem.api.dto.IContainerManaged;
import ru.smcsystem.api.dto.IExecutionContext;
import ru.smcsystem.api.exceptions.ModuleException;

import java.util.Optional;

/**
 * main configuration tool
 *
 * @version 1.0.0
 */
public interface ConfigurationTool extends IConfiguration {

    /**
     * change variable
     *
     * @param key   variable name
     * @param value value object (String, Number, byte[])
     */
    void setVariable(String key, Object value);

    /**
     * check is variable has changed from last execution or last check
     * usfull for check changes from external (processes or user)
     *
     * @param key variable name
     * @return true if variable was changed
     */
    boolean isVariableChanged(String key);

    /**
     * remove variable
     *
     * @param key variable name
     */
    void removeVariable(String key);

    /**
     * get module folder
     * contains all files, what was in smcm file.
     *
     * @return FileTool
     */
    FileTool getHomeFolder();

    /**
     * get full path to work directory
     * only if module allow this
     *
     * @return full path to directory or NULL
     * @throws ModuleException if module not allow work with work directory
     */
    String getWorkDirectory();

    /**
     * count configuration execution contexts
     *
     * @return int
     */
    int countExecutionContexts();

    /**
     * get execution context
     *
     * @param id serial number in the list of Execution Contexts
     * @return IExecutionContext
     */
    Optional<IExecutionContext> getExecutionContext(int id);

    /**
     * get container
     *
     * @return IContainerManaged
     */
    IContainerManaged getContainer();

    /**
     * check if has license
     *
     * @param freeDays - free trial days. 0 or more.
     * @return boolean - true if has license
     */
    boolean hasLicense(int freeDays);

}
