package ru.smcsystem.api.dto;

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

    /**
     * get all shapes in container
     *
     * @return ObjectArray
     */
    ObjectArray getShapes();

    /**
     * get decoration shapes in container
     * not include cfgs, apps and containers
     *
     * @return ObjectArray
     */
    ObjectArray getDecorationShapes();

    /**
     * get all cfgs as text on smcl in current container
     *
     * @return smcl
     */
    String getSmcl();

}
