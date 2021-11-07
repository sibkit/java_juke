package juke.net.mapping;

import juke.common.ReflectionUtils;

public abstract class BaseMessageMapper<T> implements MessageMapper<T>
{
    private Class messageClass;

    public Class<T> getMessageClass() {
        if (messageClass == null)
        {
            messageClass = ReflectionUtils.getGenericParameterClass(this.getClass(), BaseMessageMapper.class, 0);
        }
        return messageClass;
    }



}

