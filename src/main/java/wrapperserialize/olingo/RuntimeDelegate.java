package wrapperserialize.olingo;

import java.io.InputStream;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public abstract class RuntimeDelegate {
    private static final String IMPLEMENTATION = "org.apache.olingo.odata2.core.rt.RuntimeDelegateImpl";

    public RuntimeDelegate() {
    }


    public static ExpandSelectTreeNode.ExpandSelectTreeNodeBuilder createExpandSelectTreeNodeBuilder() {
        return null;
    }
}

