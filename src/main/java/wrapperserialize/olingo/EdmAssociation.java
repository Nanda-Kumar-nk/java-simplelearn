package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public interface EdmAssociation extends EdmType, EdmAnnotatable {
    EdmAssociationEnd getEnd(String var1) throws EdmException;

    EdmAssociationEnd getEnd1() throws EdmException;

    EdmAssociationEnd getEnd2() throws EdmException;

    EdmReferentialConstraint getReferentialConstraint() throws EdmException;
}

