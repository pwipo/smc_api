package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.ValueType;

/**
 * Interface for value objects
 *
 * @version 1.0.0
 */
public interface IValue {

    /**
     * value type
     *
     * @return ValueType
     */
    ValueType getType();

    /**
     * value as object
     *
     * @return Object: String, Number, byte[]
     */
    Object getValue();

}
