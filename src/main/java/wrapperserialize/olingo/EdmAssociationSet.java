package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAssociationSet extends EdmNamed, EdmAnnotatable {
    EdmAssociation getAssociation() throws EdmException;

    EdmAssociationSetEnd getEnd(String var1) throws EdmException;

    EdmEntityContainer getEntityContainer() throws EdmException;
}