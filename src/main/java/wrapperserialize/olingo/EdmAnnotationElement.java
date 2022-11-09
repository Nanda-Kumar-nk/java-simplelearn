package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAnnotationElement {
    String getNamespace();

    String getPrefix();

    String getName();

    String getText();

    List<EdmAnnotationElement> getChildElements();

    List<EdmAnnotationAttribute> getAttributes();
}
