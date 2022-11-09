package wrapperserialize.olingo;

import java.util.List;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public abstract class ExpandSelectTreeNode {
    public ExpandSelectTreeNode() {
    }

    public abstract boolean isAll();

    public abstract List<EdmProperty> getProperties();

    public abstract Map<String, ExpandSelectTreeNode> getLinks();

    public static ExpandSelectTreeNodeBuilder entitySet(EdmEntitySet entitySet) {
        return ExpandSelectTreeNode.ExpandSelectTreeNodeBuilder.newInstance().entitySet(entitySet);
    }

    public abstract static class ExpandSelectTreeNodeBuilder {
        public ExpandSelectTreeNodeBuilder() {
        }

        private static ExpandSelectTreeNodeBuilder newInstance() {
            return RuntimeDelegate.createExpandSelectTreeNodeBuilder();
        }

        public abstract ExpandSelectTreeNodeBuilder entitySet(EdmEntitySet var1);

        public abstract ExpandSelectTreeNode build() throws EdmException;

        public abstract ExpandSelectTreeNodeBuilder selectedProperties(List<String> var1);

        public abstract ExpandSelectTreeNodeBuilder selectedLinks(List<String> var1);

        public abstract ExpandSelectTreeNodeBuilder customExpandedLink(String var1, ExpandSelectTreeNode var2);

        public abstract ExpandSelectTreeNodeBuilder expandedLinks(List<String> var1);
    }
}

