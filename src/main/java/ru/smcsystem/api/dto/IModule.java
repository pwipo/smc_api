package ru.smcsystem.api.dto;

/**
 * Interface for Module
 *
 * @version 1.0.0
 */
public interface IModule {

    /**
     * module name
     * unique for system
     *
     * @return name
     */
    String getName();

    /*
     * module version
     *
     * @return version
     */
    // String getVersion();

    /*
     * module provider
     *
     * @return String
     */
    //String getProvider();

    /**
     * get minimum count sources
     *
     * @return int
     */
    int getMinCountSources();

    /**
     * get maximum count sources
     *
     * @return int
     */
    int getMaxCountSources();

    /**
     * get minimum count execution contexts
     *
     * @return int
     */
    int getMinCountExecutionContexts();

    /**
     * get maximum count execution contexts
     *
     * @return int
     */
    int getMaxCountExecutionContexts();

    /**
     * get minimum count managed configurations
     *
     * @return int
     */
    int getMinCountManagedConfigurations();

    /**
     * get maximum count managed configurations
     *
     * @return int
     */
    int getMaxCountManagedConfigurations();

    int countTypes();

    /**
     * get type name
     *
     * @param typeId serial number in the list of types
     * @return type name
     */
    String getTypeName(int typeId);

    /**
     * get minimum count sources
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMinCountSources(int typeId);

    /**
     * get maximum count sources
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMaxCountSources(int typeId);

    /**
     * get minimum count execution contexts
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMinCountExecutionContexts(int typeId);

    /**
     * get maximum count execution contexts
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMaxCountExecutionContexts(int typeId);

    /**
     * get minimum count managed configurations
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMinCountManagedConfigurations(int typeId);

    /**
     * get maximum count managed configurations
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getMaxCountManagedConfigurations(int typeId);
}
