package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmTyped extends EdmNamed {
    EdmType getType() throws EdmException;

    EdmMultiplicity getMultiplicity() throws EdmException;
}
