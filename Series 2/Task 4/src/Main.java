
public class Main {
    public static void main(String[] args) {
        person p1 = new person("Ted", "Mosby", "123456");
        p1.express();
        p1.express("Happy");
        p1.print();
    }

    static class person {
        private String firstName;
        private String lastName;
        private String id;

        public person(String firstName, String lastName, String id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public void express() {
            System.out.println("I feel neutral");
        }

        public int express(String state) {
            System.out.println("I feel " + state + " today");
            return 0;
        }

        public void print() {
            System.out.println("person{" +
                    "name='" + firstName + '\'' +
                    ", lname='" + lastName + '\'' +
                    ", id=" + id +
                    '}');
        }
    }
}

