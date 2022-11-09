package wrapperserialize.olingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public abstract class MessageReference {
    protected final String key;
    protected List<Object> content;

    private MessageReference(String key) {
        this(key, (List)null);
    }

    private MessageReference(String key, List<Object> content) {
        this.content = null;
        this.key = key;
        this.content = content;
    }

    public static MessageReference create(Class<? extends ODataException> clazz, String key) {
        return new SimpleMessageReference(clazz.getName() + "." + key);
    }

    public MessageReference create() {
        return new SingleMessageReference(this.key);
    }

    public String getKey() {
        return this.key;
    }

    public MessageReference addContent(Object... content) {
        if (this.content == null) {
            return new SimpleMessageReference(this.key, content);
        } else {
            List<Object> mergedContent = new ArrayList(this.content.size() + content.length);
            mergedContent.addAll(this.content);
            mergedContent.addAll(Arrays.asList(content));
            return new SimpleMessageReference(this.key, mergedContent);
        }
    }

    public List<?> getContent() {
        return this.content == null ? Collections.emptyList() : Collections.unmodifiableList(this.content);
    }

    public int hashCode() {
        boolean prime = true;
        int result = 1;
        result = 31 * result + (this.key == null ? 0 : this.key.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            MessageReference other = (MessageReference)obj;
            if (this.key == null) {
                if (other.key != null) {
                    return false;
                }
            } else if (!this.key.equals(other.key)) {
                return false;
            }

            return true;
        }
    }

    public MessageReference updateContent(List<?> oldContent, Object... newContent) {
        List<Object> mergedContent = new ArrayList();
        if (oldContent != null && !oldContent.isEmpty()) {
            mergedContent.addAll(oldContent);
        }

        mergedContent.addAll(Arrays.asList(newContent));
        return new SimpleMessageReference(this.key, mergedContent);
    }

    private static class SingleMessageReference extends MessageReference {
        public SingleMessageReference(String implKey) {
            super(implKey, null);
        }

        public SingleMessageReference(String implKey, List<Object> content) {

            super(null);
        }

        public SingleMessageReference(String implKey, Object... content) {
            super(null);
        }

        public MessageReference addContent(Object... content) {
            if (this.content == null) {
                this.content = new ArrayList();
            }

            this.content.addAll(Arrays.asList(content));
            return this;
        }
    }

    private static class SimpleMessageReference extends MessageReference {
        public SimpleMessageReference(String implKey) {
            super(implKey, null);
        }

        public SimpleMessageReference(String implKey, List<Object> content) {
            super(null);
        }

        public SimpleMessageReference(String implKey, Object... content) {
            super(null);
        }
    }
}

