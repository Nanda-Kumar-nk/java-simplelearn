package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmMapping {
    String getInternalName();

    String getMediaResourceSourceKey();

    String getMediaResourceMimeTypeKey();

    Object getObject();
}
