package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAnnotations {
    List<EdmAnnotationElement> getAnnotationElements();

    EdmAnnotationElement getAnnotationElement(String var1, String var2);

    List<EdmAnnotationAttribute> getAnnotationAttributes();

    EdmAnnotationAttribute getAnnotationAttribute(String var1, String var2);
}
