package ru.smcsystem.api.tools.execution;

import ru.smcsystem.api.dto.IConfigurationManaged;
import ru.smcsystem.api.dto.IContainer;
import ru.smcsystem.api.dto.IModule;

import java.util.List;
import java.util.Optional;

/**
 * Tool for work with managed configurations
 *
 * @version 1.0.0
 */
public interface ConfigurationControlTool {

    /**
     * list of all installed modules
     *
     * @return list of modules
     */
    List<IModule> getModules();

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
     * @return IConfigurationManaged
     */
    Optional<IConfigurationManaged> getManagedConfiguration(int id);

    /**
     * create configuration and add it in list of managed configurations
     *
     * @param id        index at which the specified element is to be inserted
     * @param container container
     * @param module    module
     * @param name      unique name for configuration
     * @return IConfigurationManaged
     */
    IConfigurationManaged createConfiguration(int id, IContainer container, IModule module, String name);

    /**
     * remove managed configuration
     *
     * @param id serial number in the list of Managed configurations
     */
    void removeManagedConfiguration(int id);

}
