import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// Note that this is a sliding window implementation of a limiter and not a fixed length window
public class Limiter {
    private static final Map<String, Deque<Long>> hashMap = new HashMap<>();
    // how many request you are going allow
    private static final int THRESHOLD = 3;
    // this is the period, if it is 1 it means you are gonna allow 3 request in 1 second
    private static final int PERIOD_IN_SECONDS = 1;

    public boolean request(String userId) {
        Deque<Long> deque = hashMap.get(userId);
        long currentTime = System.currentTimeMillis();
        // first check if this is the first request, if that is the case the deque won't be initialized
        if (deque == null) {
            deque = new ArrayDeque<>();
            deque.addLast(currentTime);
            hashMap.put(userId, deque);
            return true;
        }
        // keep on removing the timestamps that are no longer in the t to (t - 1)s window
        while (!deque.isEmpty() && currentTime - deque.getFirst() > PERIOD_IN_SECONDS * 1000L) {
            deque.removeFirst();
        }
        // if that window has more than the 3 request, drop it
        if (deque.size() >= THRESHOLD) {
            return false;
        }
        // otherwise add it
        deque.addLast(currentTime);
        return true;
    }


    public static void main(String[] args) throws InterruptedException {
        Limiter limiter = new Limiter();
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        Thread.sleep(1000);
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));

    }
}