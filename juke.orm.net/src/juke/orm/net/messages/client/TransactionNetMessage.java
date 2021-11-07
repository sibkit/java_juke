package juke.orm.net.messages.client;

public class TransactionNetMessage
{
    private TransactionCommand command;
    public TransactionNetMessage(int number, TransactionCommand command)
    {
        this.command = command;
    }

    public TransactionCommand getCommand()
    {
        return command;
    }
}
