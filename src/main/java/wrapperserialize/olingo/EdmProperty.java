package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmProperty extends EdmElement, EdmAnnotatable {
    EdmCustomizableFeedMappings getCustomizableFeedMappings() throws EdmException;

    String getMimeType() throws EdmException;

    boolean isSimple();
}

