package java.security;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Policy {

    private static class PolicyInfo {
        final Policy policy;
        final boolean initialized;

        PolicyInfo(Policy policy, boolean initialized) {
            this.policy = policy;
            this.initialized = initialized;
        }
    }

    private static AtomicReference<PolicyInfo> policy = new AtomicReference<>(new PolicyInfo(null, false));

    static boolean isSet() {
        PolicyInfo pi = policy.get();
        return pi.policy != null && pi.initialized == true;
    }
}
