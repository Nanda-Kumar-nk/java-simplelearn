package trygeneric;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SapGenericTableOutputData implements Serializable {

    /**
     * Default serialVersionUID value.
     */

    private static final long serialVersionUID = 1L;

    /**
     * <i>Generated property</i> for <code>SapGenericTableOutputData.items</code> property defined at extension <code>philipslightingoutboundservices</code>.
     */

    private Map<Integer, List<SapGenericTableOutputLine>> items;

    public SapGenericTableOutputData() {
        // default constructor
    }

    public Map<Integer, List<SapGenericTableOutputLine>> getItems() {
        return items;
    }

    public void setItems(final Map<Integer, List<SapGenericTableOutputLine>> items) {
        this.items = items;
    }


}