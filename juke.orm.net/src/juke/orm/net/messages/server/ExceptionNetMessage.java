package juke.orm.net.messages.server;

public class ExceptionNetMessage
{
    private int initMessageNumber;
    private Exception exception;

    public Exception getException()
    {
        return exception;
    }

    public void setException(Exception exception)
    {
        this.exception = exception;
    }
}
