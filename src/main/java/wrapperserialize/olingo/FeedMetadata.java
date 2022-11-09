package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface FeedMetadata {
    Integer getInlineCount();

    String getNextLink();

    String getDeltaLink();
}
