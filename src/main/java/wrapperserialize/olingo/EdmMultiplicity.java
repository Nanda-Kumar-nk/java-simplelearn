package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public enum EdmMultiplicity {
    ZERO_TO_ONE("0..1"),
    MANY("*"),
    ONE("1");

    private final String literal;

    private EdmMultiplicity(String literal) {
        this.literal = literal;
    }

    public static EdmMultiplicity fromLiteral(String literal) {
        EdmMultiplicity[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            EdmMultiplicity edmMultiplicity = var1[var3];
            if (edmMultiplicity.toString().equals(literal)) {
                return edmMultiplicity;
            }
        }

        throw new IllegalArgumentException("Invalid literal " + literal);
    }

    public String toString() {
        return this.literal;
    }
}

