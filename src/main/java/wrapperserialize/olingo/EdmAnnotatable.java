package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAnnotatable {
    EdmAnnotations getAnnotations() throws EdmException;
}

