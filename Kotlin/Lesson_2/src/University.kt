import java.util.*

class University {
    private val students = ArrayList<Student>()
    fun AddStudent(student: Student) {
        students.add(student)
    }

    fun Print_Info() {
        for (s in students) println(s)
    }

    fun Find_List_By_Faculty(faculty: String) {
        for (s in students) if (s != null && faculty.equals(s.Get_Faculty(), ignoreCase = true)) println(s)
    }

    fun Find_List_By_Faculty_And_Course(faculty: String, course: Int) {
        for (s in students) if (s != null && faculty.equals(
                s.Get_Faculty(),
                ignoreCase = true
            ) && s.Get_Course() == course
        ) println(s)
    }

    fun Find_List_By_Group(group: String) {
        for (s in students) if (s != null && group.equals(s.Get_Group(), ignoreCase = true)) println(s)
    }

    fun Find_List_By_Year(year: GregorianCalendar) {
        for (s in students) if (s != null && s.Get_Date_Birth()[Calendar.YEAR] > year[Calendar.YEAR]) println(s)
    }
}