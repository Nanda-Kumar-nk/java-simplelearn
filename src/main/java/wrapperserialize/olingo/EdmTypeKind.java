package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public enum EdmTypeKind {
    UNDEFINED,
    SIMPLE,
    COMPLEX,
    ENTITY,
    NAVIGATION,
    ASSOCIATION,
    SYSTEM;

    private EdmTypeKind() {
    }
}
