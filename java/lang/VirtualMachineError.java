package java.lang;

public class VirtualMachineError extends Error {

    private static final long serialVersionUID = 4161983926571568670L;

    public VirtualMachineError() {
        super();
    }

    public VirtualMachineError(String message) {
        super(message);
    }

    public VirtualMachineError(String message, Throwable cause) {
        super(message, cause);
    }

    public VirtualMachineError(Throwable cause) {
        super(cause);
    }
}
