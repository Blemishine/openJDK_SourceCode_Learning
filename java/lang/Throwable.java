package java.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Throwable implements Serializable {

    private static final long serialVersionUID = -3042686055658047285L;
    private transient Object backtrace;
    private String detailMessage;

    private static class SentinelHolder {
        public static final StackTraceElement STACK_TRACE_ELEMENT_SENTINEL =
                new StackTraceElement("", "", null, Integer.MIN_VALUE);

        public static final StackTraceElement[] STACK_TRACE_SENTINEL =
                new StackTraceElement[]{STACK_TRACE_ELEMENT_SENTINEL};
    }

    private static final StackTraceElement[] UNASSIGNED_STACK = new StackTraceElement[0];

    private Throwable cause = this;

    private StackTraceElement[] stackTrace = UNASSIGNED_STACK;

    private static final List<Throwable> SUPPRESSED_SENTINEL = Collections.unmodifiableList(new ArrayList<Throwable>(0));

    private List<Throwable> suppressedExceptions = SUPPRESSED_SENTINEL;

    private static final String NULL_CAUSE_MESSAGE = "Cannot suppress a null exception.";

    private static final String SELF_SUPPRESSION_MESSAGE = "Self-suppression not permitted.";

    private static final String CAUSE_CAPTION = "Caused by: ";

    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    public Throwable() {
        fillInStackTrace();
    }

    public Throwable(String message) {
        fillInStackTrace();
        detailMessage = message;
    }

    public Throwable(String message, Throwable cause) {
        fillInStackTrace();
        detailMessage = message;
        this.cause = cause;
    }

    public Throwable(Throwable cause) {
        fillInStackTrace();
        detailMessage = (cause == null ? null : cause.toString());
        this.cause = cause;
    }

    public synchronized Throwable fillInStackTrace() {
        if (stackTrace != null || backtrace != null) {
            fillInStackTrace(0);
            stackTrace = UNASSIGNED_STACK;
        }
        return this;
    }

    private native Throwable fillInStackTrace(int dummy);

    public String getMessage() {
        return detailMessage;
    }

    public String getLocalizedMessage() {
        return getMessage();
    }

    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return (message != null) ? (s + ": " + message) : s;
    }
}
