package ru.smcsystem.api.dto;

import ru.smcsystem.api.exceptions.ModuleException;

import java.util.Map;
import java.util.Optional;

/**
 * Interface for Module Configuration
 *
 * @version 1.0.0
 */
public interface IConfiguration {

    /**
     * get module
     *
     * @return IModule
     */
    IModule getModule();

    /**
     * get name
     *
     * @return name
     */
    String getName();

    /**
     * get description
     *
     * @return description
     */
    String getDescription();

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
     * get buffer size
     *
     * @return int
     */
    long getBufferSize();

    /**
     * is work
     *
     * @return true if work
     */
    boolean isEnable();

}
