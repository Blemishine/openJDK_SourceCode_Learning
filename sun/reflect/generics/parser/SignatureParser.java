package sun.reflect.generics.parser;

import sun.reflect.generics.tree.ClassSignature;

import java.lang.reflect.GenericSignatureFormatError;

public class SignatureParser {

    private String input;

    private int index;

    private int mark;

    private static final char EOI = ':';

    private static final boolean DEBUG = false;

    private SignatureParser() {
    }

    private void init(String s) {
        input = s;
        mark = index = 0;
    }

    private char current() {
        assert (index <= input.length());
        return index < input.length() ? input.charAt(index) : EOI;
    }

    private void advance() {
        assert (index <= input.length());
        if (index < input.length()) {
            index++;
        }
    }

    private void mark() {
        mark = index;
    }

    private String remainder() {
        return input.substring(index);
    }

    private String markToCurrent() {
        return input.substring(mark, index);
    }

    private Error error(String errorMsg) {
        return new GenericSignatureFormatError("Signature Parse error: " + errorMsg +
                "\n\tRemaining input: " + remainder());
    }

    private void progress(int startingPosition) {
        if (index <= startingPosition) {
            throw error("Failure to make progress!");
        }
    }

    public static SignatureParser make() {
        return new SignatureParser();
    }

    public ClassSignature parseClassSig(String s) {
        if (DEBUG) System.out.println("Parsing class sig: " + s);
        init(s);
        return parseClassSignature();
    }


}
