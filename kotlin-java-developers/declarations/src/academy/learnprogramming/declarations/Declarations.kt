package academy.learnprogramming.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    var number: Int
    number = 10
    number = 20

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])

    val employees: EmployeeSet

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    } else {
        employee2 = Employee("Mike Watsom", 150)
    }

    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)
    val employeeFour = employeeTwo

    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)

    println(employeeOne.equals(employeeTwo))
    println(employeeTwo.equals(employeeThree))

    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)
    println(employeeTwo === employeeFour)

    println(employeeFour != employeeFour)
    println(employeeFour !== employeeFour)
    println(employeeTwo != employeeThree)
    println(employeeTwo !== employeeThree)

    println(employee1)

    val change = 4.22
    println("To show the value pf change, we use \$change")
    println($$"To show the value pf change, we use $change")
    println("Your change is $change")

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator/denominator}")

    println("The employee's id is ${employee1.id}")

    val filePath = """c:\somedir1\somedir2"""

    val nurseryRhyme1 = """Humpty Dumpty sat on the wall
        Humpty Dumpty had a great fall
        All the King's horses and all the King's men
        couldn't put Humpty together again.
    """
    println(nurseryRhyme1)

    val nurseryRhyme2 = """Humpty Dumpty sat on the wall
        |Humpty Dumpty had a great fall
        |All the King's horses and all the King's men
        |couldn't put Humpty together again.
    """.trimMargin()
    println(nurseryRhyme2)
}

class Employee(var name: String, val id: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Employee) {
            return name == other.name && id == other.id
        }

        return false
    }

    override fun toString(): String {
        return "Employee(name=$name, id=$id)"
    }
}
