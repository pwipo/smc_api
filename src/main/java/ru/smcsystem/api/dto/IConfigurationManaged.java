package ru.smcsystem.api.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
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
     * get all settings
     *
     * @return settings
     */
    Map<String, IValue> getAllSettings();

    /**
     * get setting value
     *
     * @param key setting name
     * @return IValue
     */
    Optional<IValue> getSetting(String key);

    /**
     * get all variables
     *
     * @return IValue
     */
    Map<String, IValue> getAllVariables();

    /**
     * get variable
     *
     * @param key variable name
     * @return IValue
     */
    Optional<IValue> getVariable(String key);

    /**
     * change setting
     *
     * @param key   setting name
     * @param value value object
     */
    void setSetting(String key, String value);

    void setSetting(String key, Byte value);

    void setSetting(String key, Short value);

    void setSetting(String key, Integer value);

    void setSetting(String key, Long value);

    void setSetting(String key, Float value);

    void setSetting(String key, Double value);

    void setSetting(String key, BigInteger value);

    void setSetting(String key, BigDecimal value);

    void setSetting(String key, byte[] value);

    void setSetting(String key, Boolean value);

    void setSetting(String key, ObjectArray value);

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

    void setVariable(String key, Boolean value);

    void setVariable(String key, ObjectArray value);

    /**
     * remove variable
     *
     * @param key variable name
     */
    void removeVariable(String key);

    /**
     * change buffer size
     *
     * @param bufferSize 0 is minimum
     */
    void setBufferSize(long bufferSize);

    /**
     * change thread buffer size
     *
     * @param threadBufferSize 1 is minimum
     */
    void setThreadBufferSize(long threadBufferSize);

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
     * @param name            unique name for configuration
     * @param type            type
     * @param maxWorkInterval max work interval. if -1, no time limit. in milliseconds
     * @return IExecutionContextManaged
     */
    IExecutionContextManaged createExecutionContext(String name, String type, int maxWorkInterval);

    /**
     * update execution context in list
     *
     * @param id              serial number in the list of execution contexts
     * @param name            unique name for configuration
     * @param type            type
     * @param maxWorkInterval max work interval. if -1, no time limit. in milliseconds
     * @return IExecutionContextManaged
     */
    IExecutionContextManaged updateExecutionContext(int id, String name, String type, int maxWorkInterval);

    /**
     * delete execution context
     *
     * @param id serial number in the list of Execution Contexts
     */
    void removeExecutionContext(int id);

    /**
     * get container
     *
     * @return IContainerManaged
     */
    IContainerManaged getContainer();

}
