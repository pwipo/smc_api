package ru.smcsystem.api.dto;

import ru.smcsystem.api.enumeration.ObjectType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * array of objects
 * use for serialization/deserialization messages as object - object serialization format
 * main class
 * contain list of object of same type.
 * the values can be one of the following types: ObjectElement, ObjectArray, String, Byte, Short, Integer, Long, Float, Double, BigInteger, BigDecimal, byte[].
 */
public class ObjectArray implements Serializable, Cloneable {

    private List<Object> objects;

    private ObjectType type;

    public ObjectArray(int count, ObjectType type) {
        Objects.requireNonNull(type);
        this.objects = new ArrayList<>(count > 10 ? count + 1 : 10);
        this.type = type;
    }

    public ObjectArray(ObjectType type, Object... values) {
        this(values != null ? Arrays.asList(values) : null, type);
    }

    public ObjectArray(ObjectElement... values) {
        this(values != null ? Arrays.asList(values) : null, ObjectType.OBJECT_ELEMENT);
    }

    public ObjectArray(List<Object> objects, ObjectType type) {
        this(objects != null ? objects.size() : 0, type);
        if (objects != null) {
            switch (type) {
                case OBJECT_ARRAY:
                    ((List<ObjectArray>) (List) objects).forEach(this::add);
                    break;
                case OBJECT_ELEMENT:
                    ((List<ObjectElement>) (List) objects).forEach(this::add);
                    break;
                case VALUE_ANY:
                    objects.forEach(this::addValueAny);
                    break;
                case STRING:
                    ((List<String>) (List) objects).forEach(this::add);
                    break;
                case BYTE:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case SHORT:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case INTEGER:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case LONG:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case FLOAT:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case DOUBLE:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case BIG_INTEGER:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case BIG_DECIMAL:
                    ((List<Number>) (List) objects).forEach(this::add);
                    break;
                case BYTES:
                    ((List<byte[]>) (List) objects).forEach(this::add);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public ObjectArray() {
        this(null, ObjectType.OBJECT_ELEMENT);
    }

    private void check(ObjectType type) {
        if (!this.type.equals(type)
                && !(ObjectType.VALUE_ANY.equals(this.type) && (ObjectType.STRING.equals(type) || ObjectType.BYTE.equals(type) || ObjectType.SHORT.equals(type) || ObjectType.INTEGER.equals(type) || ObjectType.LONG.equals(type) || ObjectType.FLOAT.equals(type) || ObjectType.DOUBLE.equals(type) || ObjectType.BIG_INTEGER.equals(type) || ObjectType.BIG_DECIMAL.equals(type) || ObjectType.BYTES.equals(type))))
            throw new IllegalArgumentException();
    }

    public int size() {
        return objects.size();
    }

    public Object get(int id) {
        return objects.get(id);
    }

    public void add(IValue value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.valueOf(value.getType().name()));
        objects.add(value.getValue());
    }

    public void add(ObjectArray value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.OBJECT_ARRAY);
        objects.add(value);
    }

    public void add(ObjectElement value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.OBJECT_ELEMENT);
        objects.add(value);
    }

    public void add(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.STRING);
        objects.add(value);
    }

    public void add(Number value) {
        if (value == null)
            throw new IllegalArgumentException();
        if (!(ObjectType.BYTE.equals(this.type) || ObjectType.SHORT.equals(this.type) || ObjectType.INTEGER.equals(this.type) || ObjectType.LONG.equals(this.type) || ObjectType.FLOAT.equals(this.type) || ObjectType.DOUBLE.equals(this.type) || ObjectType.BIG_INTEGER.equals(this.type) || ObjectType.BIG_DECIMAL.equals(this.type)))
            throw new IllegalArgumentException();
        switch (this.type) {
            case BYTE:
                objects.add(value.byteValue());
                break;
            case SHORT:
                objects.add(value.shortValue());
                break;
            case INTEGER:
                objects.add(value.intValue());
                break;
            case LONG:
                objects.add(value.longValue());
                break;
            case FLOAT:
                objects.add(value.floatValue());
                break;
            case DOUBLE:
                objects.add(value.doubleValue());
                break;
            case BIG_INTEGER:
                if (!(value instanceof BigInteger))
                    throw new IllegalArgumentException();
                objects.add(value);
                break;
            case BIG_DECIMAL:
                if (!(value instanceof BigDecimal))
                    throw new IllegalArgumentException();
                objects.add(value);
                break;
        }
    }

    public void add(byte[] value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.BYTES);
        objects.add(value);
    }

    public void add(ObjectField value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(value.getType());
        objects.add(value.getValue());
    }

    public void addValueAny(Object value) {
        if (value == null)
            throw new IllegalArgumentException();
        if (!(value instanceof String || value instanceof Number || value instanceof byte[]))
            throw new IllegalArgumentException();
        check(ObjectType.VALUE_ANY);
        objects.add(value);
    }

    public void add(int id, IValue value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.valueOf(value.getType().name()));
        objects.add(id, value);
    }

    public void add(int id, ObjectArray value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.OBJECT_ARRAY);
        objects.add(id, value);
    }

    public void add(int id, ObjectElement value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.OBJECT_ELEMENT);
        objects.add(id, value);
    }

    public void add(int id, String value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.STRING);
        objects.add(id, value);
    }

    public void add(int id, Number value) {
        if (value == null)
            throw new IllegalArgumentException();
        if (!(ObjectType.BYTE.equals(this.type) || ObjectType.SHORT.equals(this.type) || ObjectType.INTEGER.equals(this.type) || ObjectType.LONG.equals(this.type) || ObjectType.FLOAT.equals(this.type) || ObjectType.DOUBLE.equals(this.type) || ObjectType.BIG_INTEGER.equals(this.type) || ObjectType.BIG_DECIMAL.equals(this.type)))
            throw new IllegalArgumentException();
        switch (this.type) {
            case BYTE:
                objects.add(id, value.byteValue());
                break;
            case SHORT:
                objects.add(id, value.shortValue());
                break;
            case INTEGER:
                objects.add(id, value.intValue());
                break;
            case LONG:
                objects.add(id, value.longValue());
                break;
            case FLOAT:
                objects.add(id, value.floatValue());
                break;
            case DOUBLE:
                objects.add(id, value.doubleValue());
                break;
            case BIG_INTEGER:
                if (!(value instanceof BigInteger))
                    throw new IllegalArgumentException();
                objects.add(id, value);
                break;
            case BIG_DECIMAL:
                if (!(value instanceof BigDecimal))
                    throw new IllegalArgumentException();
                objects.add(id, value);
                break;
        }
    }

    public void add(int id, byte[] value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(ObjectType.BYTES);
        objects.add(id, value);
    }

    public void add(int id, ObjectField value) {
        if (value == null)
            throw new IllegalArgumentException();
        check(value.getType());
        objects.add(id, value.getValue());
    }

    public Object remove(int id) {
        return objects.remove(id);
    }

    public ObjectType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" +
                "size=" + objects.size() +
                ", objects=" + objects +
                ", type=" + type +
                ']';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ObjectArray obj = (ObjectArray) super.clone();
        obj.objects = new ArrayList<>(this.objects.size());
        if (this.type == ObjectType.OBJECT_ARRAY) {
            for (Object e : this.objects)
                obj.objects.add(((ObjectArray) e).clone());
        } else if (this.type == ObjectType.OBJECT_ELEMENT) {
            for (Object e : this.objects)
                obj.objects.add(((ObjectElement) e).clone());
        } else {
            obj.objects.addAll(this.objects);
        }
        return obj;
    }

    public boolean isSimple() {
        return ObjectType.OBJECT_ARRAY != type && ObjectType.OBJECT_ELEMENT != type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectArray that = (ObjectArray) o;
        return Objects.equals(objects, that.objects) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects, type);
    }
}
