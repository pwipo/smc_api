package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceGetType;

import java.util.Optional;

/**
 * Interface for Managed Source multipart
 *
 * @version 1.0.0
 */
public interface ISourceListManaged extends ISourceList {

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is MODULE_CONFIGURATION
     *
     * @param configuration configuration source.
     * @param getType       type of get commands from source.
     * @param countLast     only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven   if set, then source is event driven
     * @return ISourceManaged
     */
    ISourceManaged createSource(IConfiguration configuration, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is EXECUTION_CONTEXT
     *
     * @param executionContext execution context source.
     * @param getType          type of get commands from source.
     * @param countLast        only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven      if set, then source is event driven
     * @return ISourceManaged
     */
    ISourceManaged createSource(IExecutionContext executionContext, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is STATIC_VALUE
     *
     * @param value value (String, Number or byte array)
     * @return ISourceManaged
     */
    ISourceManaged createSource(Object value);

    /**
     * create source and bind it to this execution context
     * add source to end of list (order = max_order + 1)
     * created ContextSourceType is MULTIPART
     *
     * @return ISourceManaged
     */
    ISourceManaged createSource();

    /**
     * remove source from list
     *
     * @param id serial number in the list of sources
     */
    void removeSource(int id);

    /**
     * get managed source list
     *
     * @param id serial number in the list of sources
     * @return optional ISourceListManaged
     */
    Optional<ISourceListManaged> getSourceListManaged(int id);

    /**
     * get managed source
     *
     * @param id serial number in the list of sources
     * @return optional ISourceManaged
     */
    Optional<ISourceManaged> getSourceManaged(int id);

}
