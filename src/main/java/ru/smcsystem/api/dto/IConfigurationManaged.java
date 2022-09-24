package ru.smcsystem.api.dto;

import java.util.Optional;

/**
 * Interface for Managed Module Configuration
 *
 * @version 1.0.0
 */
public interface IConfigurationManaged extends IConfiguration {

    /**
     * change name
     *
     * @param name unique name for container
     */
    void setName(String name);

    /**
     * change setting
     *
     * @param key   setting name
     * @param value value object (String, Number, byte[])
     */
    void setSetting(String key, Object value);

    /**
     * change variable
     *
     * @param key   variable name
     * @param value value object (String, Number, byte[])
     */
    void setVariable(String key, Object value);

    /**
     * remove variable
     *
     * @param key variable name
     */
    void removeVariable(String key);

    /**
     * change buffer size
     *
     * @param bufferSize 1 is minimum
     */
    void setBufferSize(long bufferSize);

    /**
     * enable or disable configuration
     *
     * @param enable true for enable
     */
    void setEnable(boolean enable);

    /**
     * count execution contexts
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
    Optional<IExecutionContextManaged> getExecutionContext(int id);

    /**
     * create execution context and bind it to this configuration
     *
     * @param name unique name for configuration
     * @param maxWorkInterval max work interval. if -1, no time limit. in milliseconds
     * @return IExecutionContextManaged
     */
    IExecutionContextManaged createExecutionContext(String name, int maxWorkInterval);

    /**
     * delete execution context
     *
     * @param id serial number in the list of Execution Contexts
     */
    void removeExecutionContext(int id);

    /**
     * get container
     * @return IContainerManaged
     */
    IContainerManaged getContainer();

}
