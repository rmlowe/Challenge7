package academy.learnprogramming.challenge7

fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    val people = listOf(joe, jane, mary, john, jean).associate { it.lastName to it }
    println("Number of people with last name staring with 'S' is ${people.count { it.key.startsWith('S') }}")

    println("List of pairs: ${people.map { it.value.firstName to it.key }}")

    // also()
    // Joe is 45 years old
    // Jane is 12 years old
    // etc.
    people.also {
        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
    }


    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName, age = $age")

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 15, 22, 101)
    println("intersection is ${list1.filter { it in list2 }}")

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper

}


class Person(val firstName: String, val lastName: String, val age: Int) {

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age

}


class Box<out T> {

}

open class Paper {

}

class Regular: Paper() {

}

class Premium: Paper() {

}