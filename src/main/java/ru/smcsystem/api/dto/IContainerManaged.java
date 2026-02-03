package ru.smcsystem.api.dto;

import java.util.Optional;

/**
 * Interface for Managed container
 *
 * @version 1.0.0
 */
public interface IContainerManaged extends IContainer {

    /**
     * count child configurations
     *
     * @return int
     */
    int countConfigurations();

    /**
     * get child configuration
     *
     * @param id serial number in the list of child configurations
     * @return IConfiguration
     */
    Optional<IConfiguration> getConfiguration(int id);

    /**
     * count child managed configurations
     *
     * @return int
     */
    int countManagedConfigurations();

    /**
     * get child managed configuration
     *
     * @param id serial number in the list of child managed configurations
     * @return IConfigurationManaged
     */
    Optional<IConfigurationManaged> getManagedConfiguration(int id);

    /**
     * count child containers
     *
     * @return int
     */
    int countContainers();

    /**
     * get child container
     *
     * @param id serial number in the list of child containers
     * @return IContainer
     */
    Optional<IContainer> getContainer(int id);

    /**
     * create child container
     *
     * @param name unique name for container
     * @return IContainerManaged
     */
    IContainerManaged createContainer(String name);

    /**
     * delete empty child container
     *
     * @param id serial number in the list of child containers
     */
    void removeContainer(int id);

    /**
     * get child configuration as managed
     * similar getConfiguration
     *
     * @param id serial number in the list of child configurations
     * @return IConfigurationManaged
     */
    Optional<IConfigurationManaged> getConfigurationManaged(int id);

    /**
     * get child container as managed
     * similar getContainer
     *
     * @param id serial number in the list of child containers
     * @return IContainerManaged
     */
    Optional<IContainerManaged> getContainerManaged(int id);

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

    /**
     * save and execute text on smcl in current container
     *
     * @param text text on smcl
     * @return true if success
     */
    boolean saveSmcl(String text);

}
