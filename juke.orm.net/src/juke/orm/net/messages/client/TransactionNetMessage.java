package juke.orm.net.messages.client;

import juke.net.messages.NetMessage;

public class TransactionNetMessage extends NetMessage
{
    public static final String key = "Transaction";

    private TransactionCommand command;
    public TransactionNetMessage(int number, TransactionCommand command)
    {
        super(number, key);
        this.command = command;
    }

    public TransactionCommand getCommand()
    {
        return command;
    }
}
