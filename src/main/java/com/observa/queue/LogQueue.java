package com.observa.queue;

import com.observa.model.LogMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.observa.util.AppConstants.LOG_QUEUE_MAX_CAPACITY;

/**
 * Visual Analogy
 * 🧑‍💻 API (Producer)
 * → drops logs into a mailbox (queue)
 *
 * 🧍‍♂️ Consumer (Background Thread)
 * → checks mailbox every second. If empty, waits. If a new letter appears, it processes it.
 *
 * Even if the mailman is napping, you can still drop a letter — and walk away.
 */
@Component
public class LogQueue {

    // Define a blocking queue
    // Blocking Queue is a threadSafe queue that:
    // Blocks the producer when the queue is full: the producer thread goes to WAITING state. Suspended using Object.wait(), will resume only after a consumer removes an item
    // Blocks the consumer when the queue is empty: the consumer thread goes to WAITING state, once producer add an item, it's notified and resumes operation
    // What happens to API when producer thread is in WAITING state. It might cause starvation in high load situations
    // If queue is full, the thread handling your API request is blocked
    // ------ It does not send a response
    // ------ The client will stay loading (waiting for HTTP response)
    // ------ Can cause thread starvation in high load situations
    // For now we will set a Maximum capacity and use queue.offer() which is non blocking for enqueue operation
    private final BlockingQueue<LogMessage> queue = new LinkedBlockingQueue<>(LOG_QUEUE_MAX_CAPACITY);

    // Enqueue operation: Adds a log message to the queue
    public boolean enqueue(LogMessage logMessage) {
        return queue.offer(logMessage);
    }

    //deque operation:
    public LogMessage dequeue() throws InterruptedException {
        return queue.take(); //blocks in consumer thread
    }

    public int size() {
        return queue.size();
    }

    public int remainingCapacity() {
        return queue.remainingCapacity();
    }
}
