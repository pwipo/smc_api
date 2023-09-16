package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.ObjectType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Field for Object
 * use for serialization/deserialization messages as object - object serialization format
 * the value can be one of the following types: ObjectArray, ObjectElement, String, Byte, Short, Integer, Long, Float, Double, BigInteger, BigDecimal, byte[].
 */
public class ObjectField implements Serializable, Cloneable {

    private String name;
    private Object value;
    private ObjectType type;

    public ObjectField(String name) {
        this.setName(name);
    }

    public ObjectField(String name, IValue value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, ObjectArray value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, ObjectElement value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, String value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, Number value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, byte[] value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, ObjectField value) {
        this(name);
        this.setValue(value);
    }

    public ObjectField(String name, ObjectType type, Object value) {
        this(name);
        this.setValue(type, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        this.name = name.intern();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(IValue value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = ObjectType.valueOf(value.getType().name());
        this.value = value.getValue();
    }

    public void setValue(ObjectArray value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = ObjectType.OBJECT_ARRAY;
        this.value = value;
    }

    public void setValue(ObjectElement value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = ObjectType.OBJECT_ELEMENT;
        this.value = value;
    }

    public void setValue(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = ObjectType.STRING;
        this.value = value;
    }

    public void setValue(Number value) {
        if (value == null)
            throw new IllegalArgumentException();
        if (value instanceof Byte) {
            this.type = ObjectType.BYTE;
        } else if (value instanceof Short) {
            this.type = ObjectType.SHORT;
        } else if (value instanceof Integer) {
            this.type = ObjectType.INTEGER;
        } else if (value instanceof Long) {
            this.type = ObjectType.LONG;
        } else if (value instanceof Float) {
            this.type = ObjectType.FLOAT;
        } else if (value instanceof Double) {
            this.type = ObjectType.DOUBLE;
        } else if (value instanceof BigInteger) {
            this.type = ObjectType.BIG_INTEGER;
        } else if (value instanceof BigDecimal) {
            this.type = ObjectType.BIG_DECIMAL;
        } else {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public void setValue(byte[] value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = ObjectType.BYTES;
        this.value = value;
    }

    public void setValue(ObjectField value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.type = value.type;
        this.value = value.value;
    }

    public void setValue(ObjectType type, Object value) {
        if (type == null || value == null)
            throw new IllegalArgumentException();
        switch (type) {
            case OBJECT_ARRAY:
                setValue((ObjectArray) value);
                break;
            case OBJECT_ELEMENT:
                setValue((ObjectElement) value);
                break;
            case STRING:
                setValue((String) value);
                break;
            case BYTE:
            case SHORT:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case BIG_INTEGER:
            case BIG_DECIMAL:
                setValue((Number) value);
                break;
            case BYTES:
                setValue((byte[]) value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        this.type = type;
    }

    public ObjectType getType() {
        return type;
    }

    public boolean isSimple() {
        return ObjectType.OBJECT_ARRAY != type && ObjectType.OBJECT_ELEMENT != type;
    }

    @Override
    public String toString() {
        return type + " " + name + "=" + value;
    }

    @Override
    public ObjectField clone() throws CloneNotSupportedException {
        ObjectField obj = (ObjectField) super.clone();
        if (this.type == ObjectType.OBJECT_ARRAY) {
            obj.value = ((ObjectArray) this.value).clone();
        } else if (this.type == ObjectType.OBJECT_ELEMENT) {
            obj.value = ((ObjectElement) this.value).clone();
        }
        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectField that = (ObjectField) o;
        return Objects.equals(name, that.name) && Objects.equals(value, that.value) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, type);
    }
}
