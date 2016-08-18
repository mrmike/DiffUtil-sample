package com.moczul.diffutilsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActorRepository {

    private ActorRepository() {
        // nop
    }

    private static List<Actor> getOriginalActorList() {
        final List<Actor> actors = new ArrayList<>();

        actors.add(new Actor(1, "Jack Nicholson", 10, 1937));
        actors.add(new Actor(2, "Marlon Brando", 9, 1924));
        actors.add(new Actor(3, "Robert De Niro", 8, 1943));
        actors.add(new Actor(4, "Al Pacino", 7, 1940));
        actors.add(new Actor(5, "Daniel Day-Lewis", 6, 1957));
        actors.add(new Actor(6, "Dustin Hoffman", 5, 1937));
        actors.add(new Actor(7, "Tom Hanks", 4, 1956));
        actors.add(new Actor(8, "Anthony Hopkins", 3, 1937));
        actors.add(new Actor(9, "Paul Newman", 2, 1925));
        actors.add(new Actor(10, "Denzel Washington", 1, 1954));

        return actors;
    }

    public static List<Actor> getActorListSortedByRating() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                // Descending order
                return a2.getRating() - a1.getRating();
            }
        });

        return actorList;
    }

    public static List<Actor> getActorListSortedByName() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

        return actorList;
    }

    public static List<Actor> getActorListSortedByYearOfBirth() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                return a1.getYearOfBirth() - a2.getYearOfBirth();
            }
        });

        return actorList;
    }
}
