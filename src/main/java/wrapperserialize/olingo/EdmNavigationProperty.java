package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmNavigationProperty extends EdmTyped, EdmMappable, EdmAnnotatable {
    EdmAssociation getRelationship() throws EdmException;

    String getFromRole() throws EdmException;

    String getToRole() throws EdmException;
}

