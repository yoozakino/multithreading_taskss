// Задача 2.

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CopyOnWriteArrayList
import kotlinx.coroutines.*

suspend fun main()= coroutineScope {
    var numbers : CopyOnWriteArrayList<Int> = CopyOnWriteArrayList(listOf(1, 2, 3, 4, 5))

    for (i in 0..10) {
        val lock = Object()
        val job = launch {
            synchronized(lock) {
                for (i in 1..100) {
                    numbers.add(i)
                }
            }
        }

        job.join()
    }

    println(numbers)

}