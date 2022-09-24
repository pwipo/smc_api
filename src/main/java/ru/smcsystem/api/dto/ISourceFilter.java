package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.SourceFilterType;

import java.util.Optional;

/**
 * Interface for Source filter
 *
 * @version 1.0.0
 */
public interface ISourceFilter {

    /**
     * get type.
     *
     * @return SourceFilterType
     */
    SourceFilterType getType();

    /**
     * count params
     *
     * @return int
     */
    int countParams();

    /**
     * get param
     * params may have any types, depends on the SourceFilterType and id
     *
     * @param id serial number in the list of filter params
     * @return Object depend on type:
     * POSITION: List of int (n*2 elements: from - inclusive and to - exclusive for range or position and null), int (period length, if greater than zero, then defines the set within which the previous list values apply), int (count periods, determines the number of periods), int (start offset, before the first period)
     * NUMBER: double (min, inclusive), double (max, inclusive)
     * STRING_EQUAL: boolean (type, if true then need equals, also, not equal), string (value for compare)
     * STRING_CONTAIN: boolean (type, if true then need contain, also, not contain), string (value)
     */
    Optional<Object> getParam(int id);

}
