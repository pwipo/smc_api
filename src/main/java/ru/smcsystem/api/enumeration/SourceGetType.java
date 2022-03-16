package ru.smcsystem.api.enumeration;

/**
 * Source get type
 * defines the messages available to receive from the source
 *
 * @version 1.0.0
 */
public enum SourceGetType {

    /**
     * get all messages
     * allows you to work with all messages
     */
    ALL,

    /**
     * get messages for new teams
     * allows you to work with all messages since the last request with the given context
     * only works with messages generated in the current thread (important!) (thread safe)
     * used by default
     */
    NEW,

    /**
     * get messages for new teams
     * allows you to work with all messages since the last request with the given context
     * works with all messages: both those generated in the current stream and previously saved
     */
    NEW_ALL,

    /**
     * get messages for the last N commands
     */
    LAST,

    /**
     * get messages for the last N commands
     * works with all messages: both those generated in the current stream and previously saved
     */
    LAST_ALL

    // NEW_ALWAYS,    // as LAST, but if no new data, return last data part (with iterationCounter id)

}
