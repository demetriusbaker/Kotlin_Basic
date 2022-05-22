import java.util.Calendar
import java.util.GregorianCalendar

class University {
    private val students = ArrayList<Student>()

    fun addStudent(student: Student){
        students.add(student)
    }

    fun printInfo(){
        for (s in students)
            println(s)
    }

    fun findListByFaculty(faculty: String){
        for (s in students)
            if (faculty == s.faculty)
                println(s)
    }

    fun findListByFacultyAndCourse(faculty: String, courses: Int){
        for (s in students)
            if (faculty == s.faculty && courses == s.courses)
                println(s)
    }

    fun findListByGroup(group: String){
        for (s in students)
            if (group == s.group)
                println(s)
    }

    fun findListByYear(year: GregorianCalendar){
        for (s in students)
            if (s.dateBirth.get(Calendar.YEAR) > year.get(Calendar.YEAR))
                println(s)
    }
}

data class Student (
    val id: Int, val courses: Int, val surname: String,
    val name: String, val patronymic: String, val address: String,
    val phone: String, val faculty: String, val group: String,
    val dateBirth: GregorianCalendar)
{
    private val stringDateBirth = "${dateBirth.get(Calendar.DAY_OF_MONTH)}" +
            "${dateBirth.get(Calendar.MONTH)}${dateBirth.get(Calendar.YEAR)}"
    override fun toString(): String =
        """
            ID $id;
            Фамилия $surname;
            Имя $name
            Отчество $patronymic;
            Дата рождения $stringDateBirth
            Адрес $address;
            Телефон $phone;
            Факультет $faculty;
            Курс $courses;
            Группа $group;
        """.trimIndent()
}