package juke.net.messages;

import java.util.HashMap;
import java.util.Map;

public class TalkCodesMessage
{
    private Map<Short,String> messagesMap = new HashMap<>();

    public Map<Short, String> getMessageCodesMap()
    {
        return messagesMap;
    }
}
