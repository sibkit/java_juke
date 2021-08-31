package juke.orm;

import juke.exceptions.JukeException;
import juke.orm.exceptions.MappingException;
import juke.orm.mapping.EntityContent;
import juke.orm.mapping.EntityMapper;
import juke.orm.mapping.FieldMap;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 01.10.12
 * Time: 13:19
 * To change this template use File | Settings | File Templates.
 */
public class EntityBuilder<T>
{
	EntityMapper<T> mapper;
	public EntityBuilder(EntityMapper<T> mapper)
	{
		 this.mapper = mapper;
	}


	public T build(Object[] resultItems) throws JukeException
	{
		EntityContent content = mapper.buildContent(resultItems);
		return build(content);
	}

	public T build(EntityContent content) throws JukeException
	{
		T result = mapper.createNewEntity();
		try
		{
			for(FieldMap fm : mapper.getMap().getFieldMaps())
			{
			    mapper.writeValue(result,content.getFieldValue(fm.getIndex()),fm);
			}
		}
		catch (Exception ex)
		{
			throw new MappingException("Invalid mapping for: "+mapper.getMap().getEntityName()+" entity.");
		}
		return result;
	}
}
