package ru.smcsystem.api.dto;

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
     * get buffer size
     *
     * @return int
     */
    long getBufferSize();

    /**
     * get thread buffer size
     *
     * @return int
     */
    long getThreadBufferSize();

    /**
     * is work
     *
     * @return true if work
     */
    boolean isEnable();

    /**
     * check is configuration work now (process execute any commands)
     *
     * @return boolean
     */
    boolean isActive();

}
