import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main(){
    Thread(MyThread()).start()
    Thread(MyThread2()).start()
    Thread(MyThread3()).start()

    Thread { println("simpler") }.start()

    thread {
        println("simplest")
    }

    sleep(3000)

    thread {
        for (i in 0..5_000_000)
            increment()
        println("thread 1 count = $count")
    }

    thread {
        for (i in 0..5_000_000)
            increment2()
        println("thread 2 count = $count")
    }
}

class MyThread: Runnable {
    override fun run() {
        sleep(2000)
        println("My thread")
    }
}

class MyThread2: Runnable {
    override fun run() {
        println("My thread 2")
    }
}

class MyThread3: Runnable {
    override fun run() {
        println("My thread 3")
    }
}

//@Volatile
var count = AtomicInteger(0)
// val monitor = Any()

fun increment(){
//    synchronized(monitor){
          count.incrementAndGet()
//    }
}

fun increment2(){
//    synchronized(monitor){
          count.incrementAndGet()
//    }
}