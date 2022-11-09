package wrapperserialize.olingo;

import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface ODataEntry {
    Map<String, Object> getProperties();

    MediaMetadata getMediaMetadata();

    EntryMetadata getMetadata();

    boolean containsInlineEntry();

    ExpandSelectTreeNode getExpandSelectTree();
}