package juke.common;

import juke.exceptions.JukeException;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 01.10.12
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public interface Iterator<T>
{
	boolean hasNext() throws JukeException;
	T next() throws JukeException;
}
