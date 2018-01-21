package com.moczul.diffutilsample

class ActorRepository {

    private val actors = listOf(
        Actor(1, "Jack Nicholson", 10, 1937),
        Actor(2, "Marlon Brando", 9, 1924),
        Actor(3, "Robert De Niro", 8, 1943),
        Actor(4, "Al Pacino", 7, 1940),
        Actor(5, "Daniel Day-Lewis", 6, 1957),
        Actor(6, "Dustin Hoffman", 5, 1937),
        Actor(7, "Tom Hanks", 4, 1956),
        Actor(8, "Anthony Hopkins", 3, 1937),
        Actor(9, "Paul Newman", 2, 1925),
        Actor(10, "Denzel Washington", 1, 1954)
    )

    val actorsSortedByRating: List<Actor>
        get() = actors.sortedByDescending { it.rating }

    val actorsSortedByName: List<Actor>
        get() = actors.sortedBy { it.name }

    val actorsSortedByYearOfBirth: List<Actor>
        get() = actors.sortedBy { it.yearOfBirth }

}