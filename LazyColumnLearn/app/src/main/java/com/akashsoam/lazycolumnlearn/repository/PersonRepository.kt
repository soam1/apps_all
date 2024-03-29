package com.akashsoam.lazycolumnlearn.repository

import com.akashsoam.lazycolumnlearn.model.Person

class PersonRepository {

    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "Putin",
                lastName = "Vladimir",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Putin1",
                lastName = "Vladimir1",
                age = 21
            ),
            Person(
                id = 2,
                firstName = "Putin2",
                lastName = "Vladimir2",
                age = 22
            ),
            Person(
                id = 3,
                firstName = "Putin3",
                lastName = "Vladimir3",
                age = 23
            ),
            Person(
                id = 4,
                firstName = "Putin4",
                lastName = "Vladimir4",
                age = 24
            ),
            Person(
                id = 5,
                firstName = "Putin5",
                lastName = "Vladimir5",
                age = 25
            ),
            Person(
                id =6,
                firstName = "Putin6",
                lastName = "Vladimir6",
                age = 26
            ),
            Person(
                id = 7,
                firstName = "Putin7",
                lastName = "Vladimir7",
                age = 27
            ),
            Person(
                id = 8,
                firstName = "Putin8",
                lastName = "Vladimir8",
                age = 28
            ),
            Person(
                id = 9,
                firstName = "Putin9",
                lastName = "Vladimir9",
                age = 29
            ),

            )
    }
}