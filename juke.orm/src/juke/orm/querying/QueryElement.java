/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juke.orm.querying;

import java.io.Serializable;
import java.util.List;


public abstract class QueryElement  implements Serializable
{
    private QueryElement parentElement;
    public abstract QueryElementType getElementType();

    /*
    protected static void setParentElement(QueryElement childElement, QueryElement parentElement)
    {
        childElement.setParentElement(parentElement);
    }

    private void setParentElement(QueryElement parentElement)
    {
        this.parentElement = parentElement;
    }
    */

    public QueryElement getParentElement()
    {
        return parentElement;
    }

    protected void addChild(QueryElement childElement)
    {
        childElement.parentElement = this;
    }

    protected void removeChild(QueryElement childElement)
    {
        childElement.parentElement = null;
    }

    protected String listToString(List list,String separator)
    {
        String result = "";
        for(Object o: list)
        {
            result+=""+o;
            if(list.indexOf(o)<list.size()-1)
            {
                result+=separator;
            }
        }
        return result;
    }
}
