package app.exceptions;

import java.util.NoSuchElementException;

/**
 * SchoolExceptions
 */
public class SchoolExceptions extends NoSuchElementException {

    /**
     *
     */
    private static final long serialVersionUID = 7495447142732788553L;

    public SchoolExceptions(String message) {
        super(message);

    }

    public SchoolExceptions(){
        super();

    }
}