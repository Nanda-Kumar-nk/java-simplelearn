package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */

public interface EdmFacets {
    Boolean isNullable();

    String getDefaultValue();

    Integer getMaxLength();

    Boolean isFixedLength();

    Integer getPrecision();

    Integer getScale();

    Boolean isUnicode();

    String getCollation();

    EdmConcurrencyMode getConcurrencyMode();
}
