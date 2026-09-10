import java.util.*;

public class NumberOfRecentCalls {
    Queue<Integer> q;

    public NumberOfRecentCalls() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);

        while (q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}
