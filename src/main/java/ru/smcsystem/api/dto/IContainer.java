package ru.smcsystem.api.dto;

import java.util.Optional;

/**
 * Interface for Container
 *
 * @version 1.0.0
 */
public interface IContainer {

    /**
     * get name
     *
     * @return name
     */
    String getName();

    /**
     * is work
     *
     * @return true if work
     */
    boolean isEnable();

}
