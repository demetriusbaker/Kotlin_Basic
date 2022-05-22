open class Machine

class PassengerCar: Machine()

class Truck: Machine()

//class ServiceStation<out T: Machine>(val list: List<T>){
//    fun get(t: T): T = list.first()
//}
//
//fun fixCars(cars: ServiceStation<Machine>) = cars.list.forEach { println("$it fixed") }
//
//fun fixTruck(cars: ServiceStation<Truck>) = fixCars(cars)
//
//fun fixCars2(cars: ServiceStation<Machine>) = fixTruck(cars)

//class ServiceStation<in T: Machine>(val list: List<T>){
//    fun get(t: T): T = list.first()
//}
//
//fun fixCars(cars: ServiceStation<Machine>) = cars.list.forEach { println("$it fixed") }
//
//fun fixTruck(cars: ServiceStation<Truck>) = fixCars(cars)
//
//fun fixCars2(cars: ServiceStation<Machine>) = fixTruck(cars)