package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmStructuralType extends EdmMappable, EdmType, EdmAnnotatable {
    EdmTyped getProperty(String var1) throws EdmException;

    List<String> getPropertyNames() throws EdmException;

    EdmStructuralType getBaseType() throws EdmException;
}
