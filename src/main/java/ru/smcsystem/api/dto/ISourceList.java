package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceGetType;

import java.util.Optional;

/**
 * Interface for Source multipart
 *
 * @version 1.0.0
 */
public interface ISourceList {

    /**
     * count sources
     *
     * @return int
     */
    int countSources();

    /**
     * get source
     *
     * @param id serial number in the list of sources
     * @return ISource
     */
    Optional<ISource> getSource(int id);

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is MODULE_CONFIGURATION
     *
     * @param configuration configuration source.
     * @param getType       type of get commands from source.
     * @param countLast     only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven   if set, then source is event driven
     * @return ISource
     */
    ISource createSource(IConfiguration configuration, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is EXECUTION_CONTEXT
     *
     * @param executionContext execution context source.
     * @param getType          type of get commands from source.
     * @param countLast        only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven   if set, then source is event driven
     * @return ISource
     */
    ISource createSource(IExecutionContext executionContext, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is STATIC_VALUE
     *
     * @param value     value (String, Number or byte array)
     * @return ISource
     */
    ISource createSource(Object value);

    /**
     * create source and bind it to this execution context
     * add source to end of list (order = max_order + 1)
     * created ContextSourceType is MULTIPART
     *
     * @return ISource
     */
    ISource createSource();

    /**
     * change order - up.
     *
     * @param id serial number in the list of sources
     */
    void changeOrderUp(int id);

    /**
     * change order - down.
     *
     * @param id serial number in the list of sources
     */
    void changeOrderDown(int id);

    /**
     * remove source from list
     *
     * @param id serial number in the list of sources
     */
    void removeSource(int id);

}
