import kotlinx.coroutines.*
import java.util.concurrent.CyclicBarrier

suspend fun main()= coroutineScope {
    val barrier = CyclicBarrier(5) {
        println("Все потоки выполнили свои задачи. Работа возобновлена")
    }

    val job1 = launch {
        println("Первый поток выполняет свою задачу")
        delay(1000)
        barrier.await()
    }

    val job2 = launch {
        println("Второй поток выполняет свою задачу")
        delay(1000)
        barrier.await()
    }

    val job3 = launch {
        println("Третий поток выполняет свою задачу")
        delay(1000)
        barrier.await()
    }

    val job4 = launch {
        println("Четвертый потоквыполняет свою задачу")
        delay(1000)
        barrier.await()
    }

    val job5 = launch {
        println("Пятый поток выполняет свою задачу")
        delay(1000)
        barrier.await()
    }


}