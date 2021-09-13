package juke.net.messages;

public abstract class NetMessage
{
    private String key;
    private Integer number;

    public NetMessage(int number, String key)
    {
        this.number = number;
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }
}
