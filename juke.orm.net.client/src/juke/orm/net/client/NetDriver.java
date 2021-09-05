package juke.orm.net.client;

import juke.exceptions.JukeException;
import juke.orm.MappingData;
import juke.orm.storage.Connection;
import juke.orm.storage.StorageDriver;

public class NetDriver implements StorageDriver
{
    MappingData mappingData;

    @Override
    public void initialize(MappingData mappingData)
    {
        this.mappingData = mappingData;
    }

    @Override
    public Connection createConnection() throws JukeException
    {
        NetConnection result = new NetConnection();
        return result;
    }


}
