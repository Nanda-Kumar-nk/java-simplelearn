package wrapperserialize.olingo;


import java.util.List;

public class ODataDeltaFeedImpl implements ODataDeltaFeed {

    private  List<ODataEntry> entries;
    private  FeedMetadata feedMetadata;
    private  List<DeletedEntryMetadata> deletedEntries;

    public void setEntries(List<ODataEntry> entries) {
        this.entries = entries;
    }

    public void setFeedMetadata(FeedMetadata feedMetadata) {
        this.feedMetadata = feedMetadata;
    }

    public void setDeletedEntries(List<DeletedEntryMetadata> deletedEntries) {
        this.deletedEntries = deletedEntries;
    }

    public ODataDeltaFeedImpl() {
        this(null, null, null);
    }

    public ODataDeltaFeedImpl(final List<ODataEntry> entries, final FeedMetadata feedMetadata) {
        this(entries, feedMetadata, null);
    }

    public ODataDeltaFeedImpl(final List<ODataEntry> entries, final FeedMetadata feedMetadata,
                              final List<DeletedEntryMetadata> deletedEntries) {
        this.entries = entries;
        this.feedMetadata = feedMetadata;
        this.deletedEntries = deletedEntries;
    }

    @Override
    public List<ODataEntry> getEntries() {
        return entries;
    }

    @Override
    public FeedMetadata getFeedMetadata() {
        return feedMetadata;
    }

    @Override
    public List<DeletedEntryMetadata> getDeletedEntries() {
        return deletedEntries;
    }

}
