package juke.orm.querying.fields;

import juke.common.ChargingList;
import juke.orm.querying.QueryElementList;
import juke.orm.querying.QueryElementType;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 09.10.12
 * Time: 5:34
 * To change this template use File | Settings | File Templates.
 */
public class FunctionField extends Field
{
	private FunctionField thisField = this;
	private FunctionType functionType;
	private List<Field> nestedFields = new QueryElementList<>(this);

	public FunctionField(FunctionType functionType)
	{
		this.functionType = functionType;
	}
	public FunctionField(FunctionType functionType, Field... argumentField)
	{
		this.functionType = functionType;
        nestedFields.addAll(Arrays.asList(argumentField));
	}

	public List<Field> getNestedFields()
	{
		return nestedFields;
	}

	@Override
	public QueryElementType getElementType()
	{
		return QueryElementType.FUNCTION_FIELD;
	}

	public FunctionType getFunctionType()
	{
		return functionType;
	}
	public void setFunctionType(FunctionType functionType)
	{
		this.functionType = functionType;
	}
}
