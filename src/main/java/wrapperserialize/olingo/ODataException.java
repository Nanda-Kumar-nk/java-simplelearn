package wrapperserialize.olingo;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public class ODataException extends Exception {
    private static final long serialVersionUID = 1L;

    public ODataException() {
    }

    public ODataException(String msg) {
        super(msg);
    }

    public ODataException(String msg, Throwable e) {
        super(msg, e);
    }

    public ODataException(Throwable e) {
        super(e);
    }



}

