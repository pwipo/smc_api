package ru.smcsystem.api.dto;

/**
 * Interface for Execution Context
 *
 * @version 1.0.0
 */
public interface IExecutionContext {

    /**
     * get configuration
     * @return configuration
     */
    IConfiguration getConfiguration();

    /**
     * get name
     *
     * @return name
     */
    String getName();

    /**
     * get max work interval in milliseconds
     * if -1, no time limit
     *
     * @return int
     */
    int getMaxWorkInterval();

    /**
     * is work
     *
     * @return true if work
     */
    boolean isEnable();

}
