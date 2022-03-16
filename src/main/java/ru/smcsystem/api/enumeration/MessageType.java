package ru.smcsystem.api.enumeration;

/**
 * main data type
 *
 * @version 1.0.0
 */
public enum MessageType {

    /**
     * emit by system when action change process state
     */
    PROCESS_STATE_CHANGE/*(4)*/,

    /**
     * emit by system when process start action
     */
    ACTION_START/*(5)*/,
    /**
     * emit by system when process stop action
     */
    ACTION_STOP/*(6)*/,
    /**
     * emit by system when process get error in action
     */
    ACTION_ERROR/*(7)*/,

    /**
     * emit by system when process change managed configuration
     */
    CONFIGURATION_CONTROL_CONFIGURATION_SETTING_UPDATE/*(8)*/,
    CONFIGURATION_CONTROL_CONFIGURATION_VARIABLE_UPDATE/*(8)*/,
    CONFIGURATION_CONTROL_CONFIGURATION_VARIABLE_REMOVE/*(8)*/,
    CONFIGURATION_CONTROL_CONFIGURATION_CREATE/*(8)*/,
    CONFIGURATION_CONTROL_CONFIGURATION_UPDATE/*(9)*/,
    CONFIGURATION_CONTROL_CONFIGURATION_REMOVE/*(10)*/,
    CONFIGURATION_CONTROL_EXECUTION_CONTEXT_CREATE/*(11)*/,
    CONFIGURATION_CONTROL_EXECUTION_CONTEXT_UPDATE/*(12)*/,
    CONFIGURATION_CONTROL_EXECUTION_CONTEXT_REMOVE/*(13)*/,
    CONFIGURATION_CONTROL_SOURCE_CONTEXT_CREATE/*(14)*/,
    CONFIGURATION_CONTROL_SOURCE_CONTEXT_UPDATE/*(15)*/,
    CONFIGURATION_CONTROL_SOURCE_CONTEXT_REMOVE/*(16)*/,
    CONFIGURATION_CONTROL_CONTAINER_CREATE/*(17)*/,
    CONFIGURATION_CONTROL_CONTAINER_REMOVE/*(18)*/,

    /**
     * emit by system when process throw new command
     */
    FLOW_CONTROL_EXECUTE_NOW_START/*(17)*/,
    FLOW_CONTROL_EXECUTE_NOW_EXECUTE/*(18)*/,
    FLOW_CONTROL_EXECUTE_NOW_UPDATE/*(19)*/,
    FLOW_CONTROL_EXECUTE_NOW_STOP/*(20)*/,
    FLOW_CONTROL_EXECUTE_PARALLEL_START/*(21)*/,
    FLOW_CONTROL_EXECUTE_PARALLEL_EXECUTE/*(22)*/,
    FLOW_CONTROL_EXECUTE_PARALLEL_UPDATE/*(23)*/,
    FLOW_CONTROL_EXECUTE_PARALLEL_STOP/*(24)*/,
    FLOW_CONTROL_EXECUTE_PARALLEL_WAITING_TACTS/*(25)*/,

    /**
     * emit by module process while execution phase
     * error message
     */
    ERROR/*(1000)*/,

    /**
     * emit by module process while execution phase
     * normal message
     * or by system
     */
    DATA/*(1001)*/;


    /*
    private Integer value;

    MessageType(Integer value) {
        this.value = value;
    }

    public static MessageType parse(Integer value) {
        MessageType result = null;
        if (value == null || value <= 0)
            return result;
        for (MessageType dt : MessageType.values()) {
            if (dt.value.equals(value)) {
                result = dt;
                break;
            }
        }
        if (result == null && value >= DATA.value)
            result = DATA;
        return result;
    }

    public Integer getValue() {
        return value;
    }
    */
}
