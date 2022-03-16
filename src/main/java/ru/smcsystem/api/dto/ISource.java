package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceGetType;
import ru.smcsystem.api.enumeration.SourceType;

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
     * get value
     * depend on type
     *
     * @return IConfiguration for MODULE_CONFIGURATION, IExecutionContext for EXECUTION_CONTEXT, IValue for STATIC_VALUE, NULL for MULTIPART
     */
    Object getValue();

    /**
     * get order.
     * determines the position in the source list.
     *
     * @return int
     */
    int getOrder();

    /**
     * is source event driven.
     *
     * @return true if it is true
     */
    boolean isEventDriven();

    /**
     * get source list
     *
     * @return ISourceList for MULTIPART or null
     */
    ISourceList getList();

}
