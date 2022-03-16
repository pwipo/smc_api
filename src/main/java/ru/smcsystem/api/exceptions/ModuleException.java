package ru.smcsystem.api.exceptions;

/**
 * main exception
 *
 * @version 1.0.0
 */
public class ModuleException extends RuntimeException {

    protected String strMessage;

    public ModuleException(String strMessage) {
        this(strMessage, null);
    }

    public ModuleException(String strMessage, Exception e) {
        super(e);
        this.strMessage = strMessage;
    }

    @Override
    public String getMessage() {
        return strMessage;
    }
}
