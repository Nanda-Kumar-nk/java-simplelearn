package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAssociationSetEnd extends EdmAnnotatable {
    String getRole();

    EdmEntitySet getEntitySet() throws EdmException;
}

