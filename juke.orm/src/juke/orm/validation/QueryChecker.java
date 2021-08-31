package juke.orm.validation;

import juke.orm.MappingData;
import juke.orm.mapping.EntityMapper;
import juke.orm.mapping.FieldMap;
import juke.orm.querying.fields.LinkField;
import juke.orm.querying.queries.EntityQuery;
import juke.orm.querying.queries.Query;

public class QueryChecker
{
    private void checkFields()
    {

    }

    public static void complete(Query query, MappingData md)
    {

        //ENTITY
        //GROUP
        //JOIN
        if(query instanceof EntityQuery)
        {
            EntityQuery eq = (EntityQuery)query;

            if(eq.getFields().size()==0)
            {
                EntityMapper mapper = md.getEntityMapper(eq.getEntityName());
                for(FieldMap fm : mapper.getMap().getFieldMaps())
                {
                    eq.getFields().add(new LinkField(fm.getFieldName()));
                }
            }
        }
    }
}
