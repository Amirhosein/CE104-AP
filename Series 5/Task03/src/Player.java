/**
 * The type Player.
 */
public class Player {
    private final int age;
    private final String name;
    private final String ID;

    /**
     * Instantiates a new Player.
     *
     * @param age  the age
     * @param name the name
     * @param ID   the id
     */
    public Player(int age, String name, String ID) {
        this.age = age;
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getID() {
        return ID;
    }
}
