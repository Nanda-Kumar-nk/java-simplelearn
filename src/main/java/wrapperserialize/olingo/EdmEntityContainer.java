package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmEntityContainer extends EdmNamed, EdmAnnotatable {
    boolean isDefaultEntityContainer();

    EdmEntitySet getEntitySet(String var1) throws EdmException;

    List<EdmEntitySet> getEntitySets() throws EdmException;

    EdmFunctionImport getFunctionImport(String var1) throws EdmException;

    EdmAssociationSet getAssociationSet(EdmEntitySet var1, EdmNavigationProperty var2) throws EdmException;

    List<EdmAssociationSet> getAssociationSets() throws EdmException;
}

