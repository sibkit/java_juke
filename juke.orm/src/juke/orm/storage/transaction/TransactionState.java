/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.orm.storage.transaction;

/**
 *
 * @author chelovek
 */
public enum TransactionState
{
    OPENED,
    COMMITTED,
    ABORTED,
    CLOSED
}
