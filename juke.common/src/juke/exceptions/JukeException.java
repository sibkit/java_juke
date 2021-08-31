package juke.exceptions;

public class JukeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public JukeException(String message)
    {
        super(message);
    }
}
