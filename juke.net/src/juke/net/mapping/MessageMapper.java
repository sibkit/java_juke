package juke.net.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface MessageMapper<T>
{
    String getTalkCode();
    Class<T> getMessageClass();
    void bindToStream(T message, OutputStream out) throws IOException;

    void bindToMessage(InputStream in, T message) throws IOException;
    T createMessage();
}