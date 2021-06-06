package utils;

import java.io.Serializable;
import java.util.Vector;

public class Request extends Object implements Serializable {

    private String path;

    private Vector<Parameter> parameters;

    public Request(String path, Vector<Parameter> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Vector<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Vector<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Boolean hasParameter(String keyParameter) {
        for (Parameter parameter:
                parameters) {
            if (parameter.getKey() == keyParameter) {
                return true;
            }
        }
        return false;
    }

    public Parameter getParameter(String keyParameter) {
        for (Parameter parameter:
                parameters) {
            if (parameter.getKey() == keyParameter) {
                return parameter;
            }
        }
        return null;
    }
}
