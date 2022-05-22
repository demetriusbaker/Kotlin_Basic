package chapter6

import java.awt.event.ActionEvent
import java.lang.IllegalArgumentException
import javax.swing.AbstractAction
import javax.swing.JList

fun strLen(s: String?) : Int? = s?.length
/*
foo?.bar()
1) foo != null -> foo.bar()
2) else null
 */

fun strLenSafe(s: String?) : Int = s?.length ?: 0

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val county: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

/*
fun Person.countryName(): String {
    val county = this.company?.address?.county
    // return if (county != null) county else "Unknown"
    return county ?: "Unknown"
}
 */

fun Person.countryName() = company?.address?.county ?: "Unknown"

//fun foo(s: String?){
//    val t: String = s ?: ""
//}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?:
    throw IllegalArgumentException("No address")
    with(address){
        println(streetAddress)
        println("$zipCode $city $county")
    }
}

/*
foo as? Type
1) foo is Type -> foo as Type
2) else null
 */

class Persona(private val firstName: String, private val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Persona ?: return false

        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

/*
foo!!
1) foo != null -> foo
2) else -> NullPointerException
 */

fun ignoreNulls(s: String?): Int {
    val sNotNull: String = s!!
    return sNotNull.length
}

class CopyRowAction(val list: JList<String>) : AbstractAction() {
    override fun isEnabled(): Boolean = list.selectedValue != null

    override fun actionPerformed(e: ActionEvent?) {
        val value = list.selectedValue!!
    }
}

//fun sendEmailTo(email: String) {/* */}
//val email: String? = null
//sendEmailTo(email!!)
//
//if (email != null) sendEmailTo(email)








