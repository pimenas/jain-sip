package gov.nist.javax.sip.stack;

import java.util.Collection;
import java.util.LinkedList;

public class SocketRemovalListeners {

    private static final Collection<Listener> listeners = new LinkedList();

    public static interface Listener {
        void socketRemoved(String channel);
    }

    public static void addListener(Listener listener) {
        listeners.add(listener);
    }

    public static void clear() {
        listeners.clear();
    }

    public static void send(String channel) {
        for (Listener listener: listeners) {
            try {
                listener.socketRemoved(channel);
            } catch (Exception e) {
                System.err.println("Exception caught with message: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
