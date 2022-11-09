package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmCustomizableFeedMappings {
    Boolean isFcKeepInContent();

    EdmContentKind getFcContentKind();

    String getFcNsPrefix();

    String getFcNsUri();

    String getFcSourcePath();

    String getFcTargetPath();
}
