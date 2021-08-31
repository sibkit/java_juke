/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.presentation;

import juke.orm.Session;

/**
 *
 * @author chelovek
 */
public interface SessionProvider
{
    Session getSession();
}
