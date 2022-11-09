package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmEntitySet extends EdmMappable, EdmNamed, EdmAnnotatable {
    EdmEntityType getEntityType() throws EdmException;

    EdmEntitySet getRelatedEntitySet(EdmNavigationProperty var1) throws EdmException;

    EdmEntityContainer getEntityContainer() throws EdmException;
}