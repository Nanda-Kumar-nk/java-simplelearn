package wrapperserialize.olingo;

import java.util.Collection;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmFunctionImport extends EdmMappable, EdmNamed, EdmAnnotatable {
    EdmParameter getParameter(String var1) throws EdmException;

    Collection<String> getParameterNames() throws EdmException;

    EdmEntitySet getEntitySet() throws EdmException;

    String getHttpMethod() throws EdmException;

    EdmTyped getReturnType() throws EdmException;

    EdmEntityContainer getEntityContainer() throws EdmException;
}

