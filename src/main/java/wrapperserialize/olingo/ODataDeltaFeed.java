package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface ODataDeltaFeed extends ODataFeed {
    List<DeletedEntryMetadata> getDeletedEntries();
}

