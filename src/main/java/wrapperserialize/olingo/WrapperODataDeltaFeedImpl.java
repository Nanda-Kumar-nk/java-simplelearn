package wrapperserialize.olingo;


import java.io.Serializable;
import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public class WrapperODataDeltaFeedImpl extends ODataDeltaFeedImpl implements ODataDeltaFeed, Serializable {


    public WrapperODataDeltaFeedImpl(List<ODataEntry> entries, FeedMetadata feedMetadata) {
        super(entries, feedMetadata);
    }

    public WrapperODataDeltaFeedImpl(List<ODataEntry> entries, FeedMetadata feedMetadata, List<DeletedEntryMetadata> deletedEntries) {
        super(entries, feedMetadata, deletedEntries);
    }

    @Override
    public List<DeletedEntryMetadata> getDeletedEntries() {
        return null;
    }

    @Override
    public List<ODataEntry> getEntries() {
        return null;
    }

    @Override
    public FeedMetadata getFeedMetadata() {
        return null;
    }
}
