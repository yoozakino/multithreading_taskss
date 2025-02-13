// Задача 1.

import kotlinx.coroutines.*

suspend fun main()= coroutineScope {
    val lock = Object()
    var counter = 0

    val job1 = launch {
        synchronized(lock) {
            for (i in 0..1000) {
                counter += 1
            }
        }
    }

    val job2 = launch {
        synchronized(lock) {
            for (i in 0..1000) {
                counter += 1
            }
        }
    }

    val job3 = launch {
        synchronized(lock) {
            for (i in 0..1000) {
                counter += 1
            }
        }
    }

    val job4 = launch {
        synchronized(lock) {
            for (i in 0..1000) {
                counter += 1
            }
        }
    }

    val job5 = launch {
        synchronized(lock) {
            for (i in 0..1000) {
                counter += 1
            }
        }
    }

    job1.join()
    job2.join()
    job3.join()
    job4.join()
    job5.join()

    println(counter)
}




