package juke.orm.storage;

import juke.orm.MappingData;
import juke.exceptions.JukeException;

public interface StorageDriver
{
    void initialize(MappingData mappingData);
    Connection createConnection() throws JukeException;
}
