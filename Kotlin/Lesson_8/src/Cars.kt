enum class EDiraction { LEFT, RIGHT }

interface Car{
    fun move()
    fun stop()
    fun turn(dir: EDiraction)
}

class MyCar : Car {
    var isMoving = false
        private set(value) {
            field = value
            println("Is moving = $field")
        }

    private fun turnLeft() = println("Turned left")
    private fun turnRight() = println("Turned right")

    override fun move() {
        isMoving = true
    }

    override fun stop() {
        isMoving = false
    }

    override fun turn(dir: EDiraction) {
        when (dir){
            EDiraction.LEFT -> turnLeft()
            EDiraction.RIGHT -> turnRight()
        }
    }
}

class DelegationCar : Car {
    private val myCar = MyCar()

    override fun move() {
        myCar.move()
    }

    override fun stop() {
        myCar.stop()
    }

    override fun turn(dir: EDiraction) {
        if (myCar.isMoving) myCar.turn(dir)
        else println("Car is stopped")
    }
}

class DelegationCar2(private val myCar: MyCar = MyCar()) : Car by myCar {
    override fun turn(dir: EDiraction) {
        if (myCar.isMoving) myCar.turn(dir)
        else println("Car is stopped")
    }
}