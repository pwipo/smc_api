package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.MessageType;

import java.util.Date;

/**
 * Interface for Message
 *
 * @version 1.0.0
 */
public interface IMessage extends IValue {

    /**
     * get date of creation
     *
     * @return Date
     */
    Date getDate();

    /**
     * get message type
     * for process messages - DATA
     *
     * @return MessageType
     */
    MessageType getMessageType();

}
