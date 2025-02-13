// Задача 4.

import kotlinx.coroutines.*

suspend fun main()= coroutineScope {
    val account1 = "Account1"
    var account1Balance = 5000
    val account2 = "Account2"
    var account2Balance = 15000
    val account3 = "Account3"
    var account3Balance = 60000

    val lock = Object()

    val job1 = launch {
        synchronized(lock) {
            remittance(account1, account2, account1Balance, account2Balance, 3000)
        }
    }

    val job2 = launch {
        synchronized(lock) {
            remittance(account3, account1, account3Balance, account1Balance, 13000)
        }
    }
}

fun remittance(sender:String, recipient:String, senderBalance:Int, recipientBalance:Int, amount: Int) {
    val newSenderBalance = senderBalance - amount
    val newRecipientBalance = recipientBalance + amount

    println("Средства были успешно переведены с аккаунта $sender на аккаунт $recipient");
    println("Баланс отправителя $sender: $newSenderBalance | Баланс получателя $recipient: $newRecipientBalance")
}