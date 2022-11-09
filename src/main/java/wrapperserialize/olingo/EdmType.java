package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmType extends EdmNamed {
    String getNamespace() throws EdmException;

    EdmTypeKind getKind();
}