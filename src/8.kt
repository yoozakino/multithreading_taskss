import kotlinx.coroutines.*
import java.util.concurrent.BlockingDeque
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

suspend fun main()= coroutineScope {
    val queue: BlockingQueue<Int> = ArrayBlockingQueue(10)

    val job_writer = launch {
        for (i in 1..10) {
            queue.put(i)
            delay(1000)
            println("В очередь добавлен элемент $i")
        }
    }

    job_writer.join()

    val job_reader = launch {
        for (i in 1..10) {
            val data = queue.take()
            delay(1000)
            println("Из очереди прочитан элемент $data")
        }
    }

}

