package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAssociationEnd extends EdmAnnotatable {
    String getRole();

    EdmEntityType getEntityType() throws EdmException;

    EdmMultiplicity getMultiplicity();
}

