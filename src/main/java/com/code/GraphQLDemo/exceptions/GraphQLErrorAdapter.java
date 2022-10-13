package com.code.GraphQLDemo.exceptions;

import java.util.List;
import java.util.Map;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class GraphQLErrorAdapter implements GraphQLError{
    private GraphQLError error;

    public GraphQLErrorAdapter(GraphQLError error) {
        this.error = error;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return error.getExtensions();
    }

    @Override
    public ErrorClassification getErrorType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
