import kotlinx.coroutines.*
import java.util.concurrent.*

suspend fun main()= coroutineScope {
    val executor: ExecutorService = Executors.newFixedThreadPool(10)

    val task = Callable {
        factorial(8)
    }

    val future: Future<Long> = executor.submit(task)

    for (i in 1..10) {
        val job = launch {
            val result = future.get()
            delay(1000)
            println("Поток ${Thread.currentThread().name} номер $i выполнил задачу с результатом: $result")
        }
        job.join()

    }

    executor.shutdown()
}

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) {
        1
    } else {
        n * factorial(n - 1)
    }
}