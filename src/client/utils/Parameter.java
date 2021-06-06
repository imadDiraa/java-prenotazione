package client.utils;

import java.io.Serializable;

public class Parameter implements Serializable {

    private String key;
    private Object value;

    public Parameter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Class<?> getValueClass() {
        return value.getClass();
    }
}
