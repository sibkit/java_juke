package juke.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StreamUtils
{
    public static int readInt(InputStream in) throws IOException
    {
        return ((in.read() & 0xFF) << 24) |
                ((in.read() & 0xFF) << 16) |
                ((in.read() & 0xFF) << 8 ) |
                ((in.read() & 0xFF) << 0);
    }

    public static void writeInt(Integer value, OutputStream out) throws IOException
    {
        out.write(value >>> 24);
        out.write(value >>> 16);
        out.write(value >>> 8);
        out.write(value );
    }

    public static short readShort(InputStream in) throws IOException
    {
        return (short) ((in.read() & 0xff) | (in.read() & 0xff) << 8);
    }


    public static void writeShort(Short value, OutputStream out) throws IOException
    {
        out.write(value & 0xff);
        out.write((value>>8) & 0xff);
    }

    public static String readString(InputStream in) throws IOException
    {
        int length = in.read();
        byte[] textBytes = in.readNBytes(length);
        return new String(textBytes, StandardCharsets.UTF_8);
    }

    public static void writeString(String value, OutputStream out) throws IOException
    {
        byte[] textBytes = value.getBytes(StandardCharsets.UTF_8);
        out.write(textBytes.length);
        out.write(textBytes);
    }
}
