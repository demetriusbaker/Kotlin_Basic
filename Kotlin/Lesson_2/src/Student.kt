import java.util.*

class Student(// id, SNP, date of birth, address, telephone, faculty, course, group
    private val id: Int, private val surname: String, private val name: String, private val patronymic: String,
    private val date_Birth: GregorianCalendar, private val address: String, private val phone: String,
    private val faculty: String, private val course: Int, private val group: String
) {
    fun Get_Id(): Int {
        return id
    }

    fun Get_Surname(): String {
        return surname
    }

    fun Get_Name(): String {
        return name
    }

    fun Get_Patronymic(): String {
        return patronymic
    }

    fun Get_Date_Birth(): GregorianCalendar {
        return date_Birth
    }

    fun Get_Address(): String {
        return address
    }

    fun Get_Phone(): String {
        return phone
    }

    fun Get_Faculty(): String {
        return faculty
    }

    fun Get_Course(): Int {
        return course
    }

    fun Get_Group(): String {
        return group
    }

    override fun toString(): String {
        return """
            ID: ${Get_Id()};
            Фамилия: ${Get_Surname()};
            Имя: ${Get_Name()};
            Отчество: ${Get_Patronymic()};
            Дата рождения: ${Get_Date_Birth()[Calendar.DAY_OF_MONTH]}.${Get_Date_Birth()[Calendar.MONTH]}.${Get_Date_Birth()[Calendar.YEAR]};
            Адрес: ${Get_Address()};
            Телефон: ${Get_Phone()};
            Факультет: ${Get_Faculty()};
            Курс: ${Get_Course()};
            Группа: ${Get_Group()};
            
            """.trimIndent()
    }
}