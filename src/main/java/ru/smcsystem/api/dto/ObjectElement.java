package ru.smcsystem.api.dto;

import java.io.Serializable;
import java.util.*;

/**
 * Object in ObjectArray
 * use for serialization/deserialization messages as object - object serialization format
 * contain list of fields (ObjectField)
 */
public class ObjectElement implements Serializable, Cloneable {

    private List<ObjectField> fields;

    public ObjectElement(ObjectField... fields) {
        this(fields != null ? Arrays.asList(fields) : null);
    }

    public ObjectElement(List<ObjectField> fields) {
        this.fields = fields != null ? new ArrayList<>(fields) : new ArrayList<>();
    }

    public ObjectElement() {
        this((List<ObjectField>) null);
    }

    public List<ObjectField> getFields() {
        return fields;
    }

    public Optional<ObjectField> findField(String name) {
        return fields.stream()
                .filter(f -> name != null && name.equals(f.getName()))
                .findFirst();
    }

    public Optional<ObjectField> findFieldIgnoreCase(String name) {
        return fields.stream()
                .filter(f -> name != null && name.equalsIgnoreCase(f.getName()))
                .findFirst();
    }

    public boolean isSimple() {
        return getFields().stream().allMatch(ObjectField::isSimple);
    }

    @Override
    public String toString() {
        return "{" +
                "count=" + fields.size() +
                ", fields=" + fields +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ObjectElement obj = (ObjectElement) super.clone();
        obj.fields = new ArrayList<>(this.fields.size());
        for (ObjectField e : this.fields)
            obj.fields.add(e.clone());
        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectElement that = (ObjectElement) o;
        if (fields.size() != that.fields.size()) return false;
        for (ObjectField field : fields) {
            if (that.findField(field.getName()).filter(f -> f.equals(field)).isEmpty())
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }
}
