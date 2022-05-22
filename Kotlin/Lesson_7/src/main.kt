fun main(){
    val cars = mapOf("Lada" to Lada(), "KAMaz" to KAMaz(), "Pickup" to Pickup())
    for (car in cars){
        println(car.key)
        car.value.onOffHeadlights(true)
        car.value.ride()
        car.value.honk()
        car.value.getInfo()
    }
}

interface Transport {
    val wheels: Int

    fun ride()
    fun getInfo()
}

abstract class Car : Transport {
    open var capacity: Int = 4
    override val wheels: Int
        get() = 4

    fun onOffHeadlights(onOff: Boolean){
        println("headlights: ${if (onOff) "Yes" else "No"}")
    }
    abstract fun honk()
}

class Lada : Car() {
    override fun honk() {
        println("Lada honk!")
    }

    override fun ride() {
        println("Lada ride!")
    }

    override fun getInfo() {
        println("Capacity: $capacity")
    }
}

class KAMaz : Car() {
    var liftCapacity: Double = 2500.0

    override fun honk() {
        println("KAMaz honk!")
    }

    override fun ride() {
        println("KAMaz ride!")
    }

    override fun getInfo() {
        println("Lifting capacity: $liftCapacity kg")
    }
}

class Pickup : Car() {
    override var capacity: Int = 2
    var liftCapacity: Double = 100.5

    override fun honk() {
        println("Pickup honk!")
    }

    override fun ride() {
        println("Pickup ride!")
    }

    override fun getInfo() {
        println("Capacity: $capacity and lifting capacity: $liftCapacity")
    }
}