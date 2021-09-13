package juke.orm.net.messages.server;

public class QueryResultNetMessage
{
    private int queryMessageNumber;
    private String resultCode;
    private Object[][] queryResult;

    public Object[][] getQueryResult()
    {
        return queryResult;
    }

    public void setQueryResult(Object[][] queryResult)
    {
        this.queryResult = queryResult;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
}
