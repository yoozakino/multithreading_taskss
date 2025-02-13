// Задача 3.

import kotlinx.coroutines.*

import java.util.concurrent.Executors

fun main() {
    val executorService = Executors.newFixedThreadPool(4)

    for (i in 1..20) {
        executorService.submit {
            println("Задача $i выполняется в потоке ${Thread.currentThread().name}")
        }
    }

    executorService.shutdown()
}
