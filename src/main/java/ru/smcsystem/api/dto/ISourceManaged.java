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
     * @param range        n*2 elements: from - inclusive and to - exclusive for range or position and null
     * @param period       period length, if greater than zero, then defines the set within which the previous list values apply
     * @param countPeriods determines the number of periods
     * @param startOffset  before the first period
     * @return ISourceFilter
     */
    ISourceFilter createFilter(List<Integer> range, int period, int countPeriods, int startOffset);

    /**
     * Create number filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param min inclusive
     * @param max inclusive
     * @return ISourceFilter
     */
    ISourceFilter createFilter(double min, double max);

    /**
     * Create string equal filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param needEquals if true then need equals, also, not equal
     * @param value      value for compare
     * @return ISourceFilter
     */
    ISourceFilter createFilterStrEq(boolean needEquals, String value);

    /**
     * Create string contain filter and bind it to this source
     * add filter to end of current list (order = max_order + 1)
     * only for MODULE_CONFIGURATION and EXECUTION_CONTEXT SourceType
     *
     * @param needContain if true then need contain, also, not contain
     * @param value       value for compare
     * @return ISourceFilter
     */
    ISourceFilter createFilterStrContain(boolean needContain, String value);

    /**
     * remove filter from list
     *
     * @param id serial number in the list of filters
     */
    void removeFilter(int id);

}
