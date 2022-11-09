package wrapperserialize.olingo;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmReferentialConstraintRole {
    String getRole();

    List<String> getPropertyRefNames();
}

