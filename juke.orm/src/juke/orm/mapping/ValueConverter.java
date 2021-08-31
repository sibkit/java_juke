package juke.orm.mapping;

public interface ValueConverter
{
    Object convertToStorage(Object contentValue);
    Object convertToContent(Object storageValue);
}
