package juke.net;

import java.util.HashMap;
import java.util.Map;

public class TalkCodesManager
{
    private final Map<Short, String> talkCodesMap = new HashMap<>();
    private final Map<String, Short> reverseMap = new HashMap<>();
    private short curIndex = 0;
    public synchronized void registerTalkCode(String talkCode)
    {
        curIndex++;
        talkCodesMap.put(curIndex,talkCode);
        reverseMap.put(talkCode,curIndex);
    }
    public void removeTalkCode(String talkCode)
    {
        Short index = reverseMap.get(talkCode);
        reverseMap.remove(talkCode);
        talkCodesMap.remove(index);
    }

    public Short getTalkCodeIndex(String talkCode)
    {
        return reverseMap.get(talkCode);
    }

    public Map<Short, String> getTalkCodesMap()
    {
        return talkCodesMap;
    }
}
