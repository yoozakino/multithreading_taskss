import kotlinx.coroutines.*
import java.util.concurrent.Semaphore

suspend fun main()= coroutineScope {
    val semaphore = Semaphore(2)

    val job1 = launch {
        semaphore.acquire()
        println("Первый поток получил доступ к ресурсу")
        delay(1000)
        println("Первый поток выполнил задачу и освободил разрешение")
        semaphore.release()
    }

    val job2 = launch {
        semaphore.acquire()
        println("Второй поток получил доступ к ресурсу")
        delay(1000)
        println("Второй поток выполнил задачу и освободил разрешение")
        semaphore.release()
    }

    val job3 = launch {
        semaphore.acquire()
        println("Третий поток получил доступ к ресурсу")
        delay(1000)
        println("Третий поток выполнил задачу и освободил разрешение")
        semaphore.release()
    }

    val job4 = launch {
        semaphore.acquire()
        println("Четвертый поток получил доступ к ресурсу")
        delay(1000)
        println("Четвертый поток выполнил задачу и освободил разрешение")
        semaphore.release()
    }




}