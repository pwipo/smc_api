package ru.smcsystem.api.tools.execution;

import ru.smcsystem.api.dto.IAction;
import ru.smcsystem.api.dto.ICommand;
import ru.smcsystem.api.dto.IExecutionContext;
import ru.smcsystem.api.dto.IExecutionContextManaged;

import java.util.List;

/**
 * main execution context tool
 *
 * @version 1.0.0
 */
public interface ExecutionContextTool extends IExecutionContext {

    /**
     * emit message
     * type DATA
     *
     * @param value object (type String, Number, byte[])
     */
    void addMessage(Object value);

    /**
     * emit error message
     * type ERROR
     *
     * @param value object (type String, Number, byte[])
     */
    void addError(Object value);

    /**
     * get count commands in source
     *
     * @param sourceId serial number in the list of Sources
     * @return count
     */
    int countCommands(int sourceId);

    /**
     * get count commands (all) for managed execution context
     *
     * @param executionContext managed execution context
     * @return count
     */
    int countCommands(IExecutionContextManaged executionContext);

    /**
     * get Process Actions from source
     *
     * @param sourceId serial number in the list of Sources
     * @return only DATA messages
     */
    List<IAction> getMessages(int sourceId);

    /**
     * get Process Actions from source
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param sourceId  serial number in the list of Sources
     * @param fromIndex start serial number in the list of commands in source (exclusive)
     * @param toIndex   end serial number in the list of commands in source (inclusive)
     * @return only DATA messages
     */
    List<IAction> getMessages(int sourceId, int fromIndex, int toIndex);

    /**
     * get Commands from source
     *
     * @param sourceId serial number in the list of Sources
     * @return all commands
     */
    List<ICommand> getCommands(int sourceId);

    /**
     * get Commands from source
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param sourceId  serial number in the list of Sources
     * @param fromIndex start serial number in the list of commands in source
     * @param toIndex   end serial number in the list of commands in source
     * @return list of commands
     */
    List<ICommand> getCommands(int sourceId, int fromIndex, int toIndex);

    /**
     * get Commands from managed execution context
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param executionContext managed execution context
     * @param fromIndex        start serial number in the list of commands
     * @param toIndex          end serial number in the list of commands
     * @return list of commands
     */
    List<ICommand> getCommands(IExecutionContextManaged executionContext, int fromIndex, int toIndex);

    /**
     * is Process Actions has errors
     *
     * @param action action for analyze
     * @return true if has error
     */
    boolean isError(IAction action);

    /**
     * get tool for work with managed configurations
     *
     * @return ConfigurationControlTool
     */
    ConfigurationControlTool getConfigurationControlTool();

    /**
     * get tool for throw new command to managed execution contexts and get result
     *
     * @return FlowControlTool
     */
    FlowControlTool getFlowControlTool();

    /**
     * check is need stop process work immediately
     * usefull for long work (example - web server)
     *
     * @return true if need stop
     */
    boolean isNeedStop();

}
