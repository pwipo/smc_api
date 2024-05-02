package ru.smcsystem.api.tools.execution;

import ru.smcsystem.api.dto.IAction;
import ru.smcsystem.api.dto.ICommand;
import ru.smcsystem.api.dto.IExecutionContext;
import ru.smcsystem.api.enumeration.CommandType;

import java.util.List;
import java.util.Optional;

/**
 * Tool for throw new command to managed execution contexts and get result
 *
 * @version 1.0.0
 */
public interface FlowControlTool {

    /**
     * count managed execution contexts
     *
     * @return count
     */
    int countManagedExecutionContexts();

    // int countManagedConfigurations();

    /**
     * throw new command to managed execution context
     * command execute in this thread
     * function will wait for the command to execute
     *
     * @param type      type of command
     * @param managedId serial number in the list of Managed execution contexts
     * @param values    list of values for create dummy messages from this process, or null
     */
    void executeNow(CommandType type, int managedId, List<Object> values);

    /**
     * throw new command to managed execution context
     * command execute in new thread
     * function return control immediately
     *
     * @param type            type of command
     * @param managedIds      serial number in the list of Managed execution contexts
     * @param values          list of values for create dummy messages from this process, or null
     * @param waitingTacts    if it is necessary that the new thread first wait for the specified time (in tacts)
     * @param maxWorkInterval define max work interval of new thread (in tacts)
     * @return return id of thread
     */
    long executeParallel(CommandType type, List<Integer> managedIds, List<Object> values, Integer waitingTacts, Integer maxWorkInterval);

    // boolean isExecute(int managedId);

    /**
     * check is thread alive
     *
     * @param threadId id thread
     * @return boolean
     */
    boolean isThreadActive(long threadId);

    /**
     * get data from managed execution context
     * who receive commands from this process
     *
     * @param managedId serial number in the list of Managed execution contexts
     * @return only DATA messages
     */
    List<IAction> getMessagesFromExecuted(int managedId);

    /**
     * get data from managed execution context
     * who receive commands from this process
     * in parallel thread
     *
     * @param threadId  id thread
     * @param managedId serial number in the list of Managed execution contexts
     * @return only DATA messages
     */
    List<IAction> getMessagesFromExecuted(long threadId, int managedId);

    /**
     * work as getMessagesFromExecuted
     *
     * @param managedId serial number in the list of Managed execution contexts
     * @return all commands
     */
    List<ICommand> getCommandsFromExecuted(int managedId);

    /**
     * work as getMessagesFromExecuted
     *
     * @param threadId  id thread
     * @param managedId serial number in the list of Managed execution contexts
     * @return all commands
     */
    List<ICommand> getCommandsFromExecuted(long threadId, int managedId);

    /**
     * after executeParallel and work with him, need to release thread
     * if thread work - stop it
     *
     * @param threadId id thread
     */
    void releaseThread(long threadId);

    /**
     * after executeParallel and work with him, need to release thread
     * if thread work - not stop it
     *
     * @param threadId id thread
     */
    void releaseThreadCache(long threadId);

    /**
     * get managed execution context
     *
     * @param id serial number in the list of Managed execution contexts
     * @return IExecutionContext
     */
    Optional<IExecutionContext> getManagedExecutionContext(int id);

}
