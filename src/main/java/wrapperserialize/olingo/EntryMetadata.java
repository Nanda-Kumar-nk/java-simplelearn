package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EntryMetadata {
    String getUri();

    List<String> getAssociationUris(String var1);

    String getEtag();

    String getId();
}
