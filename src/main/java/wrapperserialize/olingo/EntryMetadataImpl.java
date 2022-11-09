package wrapperserialize.olingo;

import java.util.*;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public class EntryMetadataImpl implements EntryMetadata {
    private String id;
    private String etag;
    private String uri;
    private Map<String, List<String>> associationUris = new HashMap<String, List<String>>();

    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String getEtag() {
        return etag;
    }

    public void setEtag(final String etag) {
        this.etag = etag;
    }

    @Override
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @Override
    public List<String> getAssociationUris(final String navigationPropertyName) {
        final List<String> uris = associationUris.get(navigationPropertyName);
        if (uris == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(uris);
        }
    }

    public void putAssociationUri(final String navigationPropertyName, final String uri) {
        List<String> uris = associationUris.get(navigationPropertyName);
        if (uris == null) {
            uris = new ArrayList<String>();
        }
        uris.add(uri);
        associationUris.put(navigationPropertyName, uris);
    }

    @Override
    public String toString() {
        return "EntryMetadataImpl [id=" + id + ", etag=" + etag + ", uri=" + uri + ", associationUris=" + associationUris
                + "]";
    }
}

