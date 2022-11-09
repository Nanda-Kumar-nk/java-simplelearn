package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmElement extends EdmMappable, EdmTyped {
    EdmFacets getFacets() throws EdmException;
}
