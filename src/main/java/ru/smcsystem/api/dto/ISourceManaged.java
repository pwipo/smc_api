package ru.smcsystem.api.dto;

import java.util.List;

/**
 * Interface for Managed source
 *
 * @version 1.0.0
 */
public interface ISourceManaged extends ISource {

    /**
     * Create position filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param forObject    if true - used for ObjectArrays, overwise for all values
     * @param range        n*2 elements: from - inclusive and to - exclusive for range. to may be null for get only 1 element
     * @param period       period length, if greater than zero, then defines the set within which the previous list values apply
     * @param countPeriods determines the number of periods
     * @param startOffset  before the first period
     * @return ISourceFilter
     */
    ISourceFilter createFilter(boolean forObject, List<Integer> range, int period, int countPeriods, int startOffset);

    /**
     * Create number filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param fieldName field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param min       inclusive
     * @param max       inclusive
     * @return ISourceFilter
     */
    ISourceFilter createFilter(String fieldName, double min, double max);

    /**
     * Create string equal filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param fieldName  field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param needEquals if true then need equals, also, not equal
     * @param value      value for compare
     * @return ISourceFilter
     */
    ISourceFilter createFilterStrEq(String fieldName, boolean needEquals, String value);

    /**
     * Create string contain filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param fieldName   field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param needContain if true then need contain, also, not contain
     * @param value       value for compare
     * @return ISourceFilter
     */
    ISourceFilter createFilterStrContain(String fieldName, boolean needContain, String value);

    /**
     * Create object paths filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param paths object array paths. path - dot separated names.
     * @return ISourceFilter
     */
    ISourceFilter createFilterObjectPaths(List<String> paths);

    /**
     * Update position filter in list
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param id           serial number in the list
     * @param forObject    if true - used for ObjectArrays, overwise for all values
     * @param range        n*2 elements: from - inclusive and to - exclusive for range. to may be null for get only 1 element
     * @param period       period length, if greater than zero, then defines the set within which the previous list values apply
     * @param countPeriods determines the number of periods
     * @param startOffset  before the first period
     * @return ISourceFilter
     */
    ISourceFilter updateFilter(int id, boolean forObject, List<Integer> range, int period, int countPeriods, int startOffset);

    /**
     * Update number filter in list
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param id        serial number in the list
     * @param fieldName field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param min       inclusive
     * @param max       inclusive
     * @return ISourceFilter
     */
    ISourceFilter updateFilter(int id, String fieldName, double min, double max);

    /**
     * Update string equal filter in list
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param id         serial number in the list
     * @param fieldName  field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param needEquals if true then need equals, also, not equal
     * @param value      value for compare
     * @return ISourceFilter
     */
    ISourceFilter updateFilterStrEq(int id, String fieldName, boolean needEquals, String value);

    /**
     * Update string contain filter in list
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param id          serial number in the list
     * @param fieldName   field name in ObjectArray. if empty used for simple values, overwise for ObjectArrays.
     * @param needContain if true then need contain, also, not contain
     * @param value       value for compare
     * @return ISourceFilter
     */
    ISourceFilter updateFilterStrContain(int id, String fieldName, boolean needContain, String value);

    /**
     * Update object paths filter in list
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param id    serial number in the list
     * @param paths object array paths. path - dot separated names.
     * @return ISourceFilter
     */
    ISourceFilter updateFilterObjectPaths(int id, List<String> paths);

    /**
     * Remove filter from list
     *
     * @param id serial number in the list of filters
     */
    void removeFilter(int id);

}
