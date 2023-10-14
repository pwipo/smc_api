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
     * get count sources
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getCountSources(int typeId);


    /**
     * get count execution contexts
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getCountExecutionContexts(int typeId);

    /**
     * get minimum count managed configurations
     *
     * @param typeId serial number in the list of types
     * @return int
     */
    int getCountManagedConfigurations(int typeId);

}
