import java.util.Objects;

/**
 * The type Vote.
 */
public class Vote {
    private final Person person;
    private final String date;

    /**
     * Instantiates a new Vote.
     *
     * @param person the person
     * @param date   the date
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * Gets person.
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return person.equals(vote.person) && date.equals(vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }
}
