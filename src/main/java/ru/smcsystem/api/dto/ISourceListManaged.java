package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceGetType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Managed Source multipart
 *
 * @version 1.0.0
 */
public interface ISourceListManaged extends ISourceList {

    /**
     * Create source and bind it to this execution context
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
     * Create source and bind it to this execution context
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
     * Create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is STATIC_VALUE
     *
     * @param value value
     * @return ISourceManaged
     */
    ISourceManaged createSource(String value);

    ISourceManaged createSource(Byte value);

    ISourceManaged createSource(Short value);

    ISourceManaged createSource(Integer value);

    ISourceManaged createSource(Long value);

    ISourceManaged createSource(Float value);

    ISourceManaged createSource(Double value);

    ISourceManaged createSource(BigInteger value);

    ISourceManaged createSource(BigDecimal value);

    ISourceManaged createSource(byte[] value);

    ISourceManaged createSource(ObjectArray value);

    /**
     * Create source and bind it to this execution context
     * add source to end of list (order = max_order + 1)
     * created ContextSourceType is MULTIPART
     *
     * @return ISourceManaged
     */
    ISourceManaged createSource();

    /**
     * Create source and bind it to this execution context
     * add source to end of current list (order = max_order + 1)
     * created ContextSourceType is OBJECT_ARRAY
     *
     * @param value  ObjectArray
     * @param fields List of field names to be changed. Сan be hierarchical, in which case the names are separated by a dot.
     * @return ISourceManaged
     */
    ISourceManaged createSource(ObjectArray value, List<String> fields);

    /**
     * Update source in list
     * ContextSourceType is MODULE_CONFIGURATION
     *
     * @param id            serial number in the list
     * @param configuration configuration source.
     * @param getType       type of get commands from source.
     * @param countLast     only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven   if set, then source is event driven
     * @return ISourceManaged
     */
    ISourceManaged updateSource(int id, IConfiguration configuration, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * Update source in list
     * created ContextSourceType is EXECUTION_CONTEXT
     *
     * @param id               serial number in the list
     * @param executionContext execution context source.
     * @param getType          type of get commands from source.
     * @param countLast        only for ContextSourceGetType.LAST. minimum 1.
     * @param eventDriven      if set, then source is event driven
     * @return ISourceManaged
     */
    ISourceManaged updateSource(int id, IExecutionContext executionContext, SourceGetType getType, int countLast, boolean eventDriven);

    /**
     * Update source in list
     * created ContextSourceType is STATIC_VALUE
     *
     * @param id    serial number in the list
     * @param value value
     * @return ISourceManaged
     */
    ISourceManaged updateSource(int id, String value);

    ISourceManaged updateSource(int id, Byte value);

    ISourceManaged updateSource(int id, Short value);

    ISourceManaged updateSource(int id, Integer value);

    ISourceManaged updateSource(int id, Long value);

    ISourceManaged updateSource(int id, Float value);

    ISourceManaged updateSource(int id, Double value);

    ISourceManaged updateSource(int id, BigInteger value);

    ISourceManaged updateSource(int id, BigDecimal value);

    ISourceManaged updateSource(int id, byte[] value);

    ISourceManaged updateSource(int id, ObjectArray value);

    /**
     * Update source in list
     * created ContextSourceType is OBJECT_ARRAY
     *
     * @param id     serial number in the list
     * @param value  ObjectArray
     * @param fields List of field names to be changed. Сan be hierarchical, in which case the names are separated by a dot.
     * @return ISourceManaged
     */
    ISourceManaged updateSource(int id, ObjectArray value, List<String> fields);

    /**
     * Remove source from list
     *
     * @param id serial number in the list of sources
     */
    void removeSource(int id);

    /**
     * Get managed source list
     *
     * @param id serial number in the list of sources
     * @return optional ISourceListManaged
     */
    Optional<ISourceListManaged> getSourceListManaged(int id);

    /**
     * Get managed source
     *
     * @param id serial number in the list of sources
     * @return optional ISourceManaged
     */
    Optional<ISourceManaged> getSourceManaged(int id);

}
