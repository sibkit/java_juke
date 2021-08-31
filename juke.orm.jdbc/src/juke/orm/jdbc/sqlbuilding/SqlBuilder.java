package juke.orm.jdbc.sqlbuilding;

import juke.orm.jdbc.sql.node.QueryNode;
import juke.orm.storage.operation.EntityOperation;
import juke.orm.storage.sequence.SequenceOperation;

public interface SqlBuilder
{
    String build(QueryNode queryNode);
    String build(SequenceOperation operation);
    SqlBuildResult build(EntityOperation operation);
    String buildSetSchemeCommand(String schemeName);
}
