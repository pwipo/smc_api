package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceType;

import java.util.Optional;

/**
 * Interface for Source
 *
 * @version 1.0.0
 */
public interface ISource {

    /**
     * get type of source.
     *
     * @return ContextSourceType
     */
    SourceType getType();

    /**
     * count params
     *
     * @return int
     */
    int countParams();

    /**
     * get param
     * params may have any types, depends on the SourceType and id
     *
     * @param id serial number in the list of source params
     * @return Object depend on type:
     * MODULE_CONFIGURATION: IConfiguration configuration (source), SourceGetType getType (type of get commands from source), int countLast (only for ContextSourceGetType.LAST. minimum 1), boolean eventDriven (is event driven)
     * EXECUTION_CONTEXT: IExecutionContext executionContext (source), SourceGetType getType (type of get commands from source), int countLast (only for ContextSourceGetType.LAST. minimum 1), boolean eventDriven (is event driven)
     * STATIC_VALUE: IValue (String, Number or byte array)
     * MULTIPART: null
     * CALLER_RELATIVE_NAME: String (caller level cfg name)
     */
    Optional<Object> getParam(int id);

    /**
     * count filters
     *
     * @return int
     */
    int countFilters();

    /**
     * get filter
     *
     * @param id serial number in the list of Filters
     * @return ISourceFilter
     */
    Optional<ISourceFilter> getFilter(int id);

}
