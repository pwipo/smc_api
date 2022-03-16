package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.ActionType;

import java.util.List;

/**
 * Interface for Action
 *
 * @version 1.0.0
 */
public interface IAction {

    /**
     * get messages
     *
     * @return IMessage list
     */
    List<IMessage> getMessages();

    /**
     * get type
     *
     * @return ActionType
     */
    ActionType getType();

}
