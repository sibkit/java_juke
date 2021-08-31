package juke.orm.exceptions;

import juke.exceptions.JukeException;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 30.01.12
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class MappingException extends JukeException
{
    public MappingException(String message)
    {
        super(message);
    }
}
