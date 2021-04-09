/**
 * The type Person.
 */
public class Person {
    /**
     * The First name.
     */
    private final String firstName;
    /**
     * The Last name.
     */
    private final String lastName;

    /**
     * Instantiates a new Person.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
