package ru.smcsystem.api.tools;

import ru.smcsystem.api.dto.IConfiguration;
import ru.smcsystem.api.dto.IContainerManaged;
import ru.smcsystem.api.dto.IExecutionContext;
import ru.smcsystem.api.dto.ObjectArray;
import ru.smcsystem.api.exceptions.ModuleException;

import java.math.BigDecimal;
import java.math.BigInteger;
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
     * @param value value object
     */
    void setVariable(String key, String value);

    void setVariable(String key, Byte value);

    void setVariable(String key, Short value);

    void setVariable(String key, Integer value);

    void setVariable(String key, Long value);

    void setVariable(String key, Float value);

    void setVariable(String key, Double value);

    void setVariable(String key, BigInteger value);

    void setVariable(String key, BigDecimal value);

    void setVariable(String key, byte[] value);

    void setVariable(String key, ObjectArray value);

    void setVariable(String key, Boolean value);

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
     * logger trace
     *
     * @param text - text
     */
    void loggerTrace(String text);

    /**
     * logger debug
     *
     * @param text - text
     */
    void loggerDebug(String text);

    /**
     * logger info
     *
     * @param text - text
     */
    void loggerInfo(String text);

    /**
     * logger warn
     *
     * @param text - text
     */
    void loggerWarn(String text);

    /**
     * logger error
     *
     * @param text - text
     */
    void loggerError(String text);

}
