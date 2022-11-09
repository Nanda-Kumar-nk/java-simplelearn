package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmEntityType extends EdmStructuralType {
    List<String> getKeyPropertyNames() throws EdmException;

    List<EdmProperty> getKeyProperties() throws EdmException;

    boolean hasStream() throws EdmException;

    EdmEntityType getBaseType() throws EdmException;

    EdmCustomizableFeedMappings getCustomizableFeedMappings() throws EdmException;

    List<String> getNavigationPropertyNames() throws EdmException;
}
