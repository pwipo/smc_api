package ru.smcsystem.api.dto;

import java.util.Optional;

/**
 * Interface for Managed Execution Context
 *
 * @version 1.0.0
 */
public interface IExecutionContextManaged extends IExecutionContext, ISourceList {

    /**
     * change name
     *
     * @param name unique name for configuration
     */
    void setName(String name);

    /**
     * change max work interval
     *
     * @param maxWorkInterval if -1, no time limit. in milliseconds
     */
    void setMaxWorkInterval(int maxWorkInterval);

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
    Optional<IExecutionContext> getExecutionContext(int id);

    /**
     * insert execution context in list
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param id               serial number in the list of Execution Contexts
     * @param executionContext execution context
     */
    void insertExecutionContext(int id, IExecutionContext executionContext);

    /**
     * remove execution context from list
     *
     * @param id serial number in the list of Execution Contexts
     */
    void removeExecutionContext(int id);


    /**
     * count managed configurations
     *
     * @return int
     */
    int countManagedConfigurations();


    /**
     * get managed configuration
     *
     * @param id serial number in the list of Managed configurations
     * @return IConfiguration
     */
    Optional<IConfiguration> getManagedConfiguration(int id);

    /**
     * insert configuration in list
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param id            serial number in the list of Managed configurations
     * @param configuration configuration
     */
    void insertManagedConfiguration(int id, IConfiguration configuration);

    /**
     * remove configuration from list
     *
     * @param id serial number in the list of Managed configurations
     */
    void removeManagedConfiguration(int id);

}
