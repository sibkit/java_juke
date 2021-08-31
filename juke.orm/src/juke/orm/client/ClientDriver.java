package juke.orm.client;

import juke.exceptions.JukeException;
import juke.orm.MappingData;
import juke.orm.storage.Connection;
import juke.orm.storage.StorageDriver;

public class ClientDriver implements StorageDriver
{
    @Override
    public void initialize(MappingData mappingData)
    {

    }

    @Override
    public Connection createConnection() throws JukeException
    {
        return null;
    }


}
