public class Run {
    public static void main(String[] args) {
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        std1.setGrade(20);
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        std2.setGrade(20);
        Student std3 = new Student("Ali", "Moghadam", "9031056");
        std3.setGrade(9);
        Student std4 = new Student("Davood", "Khodadoost", "9031055");
        std4.setGrade(21);
        Student std5 = new Student("Ahmad", "Asadi", "9031054");
        std5.setGrade(20);


        Lab lab1 = new Lab(3, "Friday");
        Lab lab2 = new Lab(2, "Friday");

        lab1.enrollStudent(std1);
        lab1.enrollStudent(std2);
        lab2.enrollStudent(std3);
        lab2.enrollStudent(std4);
        lab1.enrollStudent(std5);

        Faculty faculty = new Faculty(2);

        faculty.addLabs(lab1);
        faculty.addLabs(lab2);

        faculty.printAll();
        faculty.printSingle(1);
        faculty.calculateAvg();
        System.out.println("Faculty Average: " + faculty.getAvg());


    }
}