package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.CommandType;

import java.util.List;

/**
 * Interface for Command
 *
 * @version 1.0.0
 */
public interface ICommand {

    /**
     * get type
     *
     * @return CommandType
     */
    CommandType getType();

    /**
     * get actions
     *
     * @return IAction list
     */
    List<IAction> getActions();

}
