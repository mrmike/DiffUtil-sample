package com.moczul.diffutilsample;

public class Actor {

    private final int id;
    private final String name;
    private final int rating;
    private final int yearOfBirth;

    public Actor(int id, String name, int rating, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (id != actor.id) return false;
        if (rating != actor.rating) return false;
        if (yearOfBirth != actor.yearOfBirth) return false;
        return name != null ? name.equals(actor.name) : actor.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + yearOfBirth;
        return result;
    }
}
