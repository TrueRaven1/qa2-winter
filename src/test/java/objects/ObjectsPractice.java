package objects;

import org.junit.jupiter.api.Test;

public class ObjectsPractice {
    @Test
    public void workingWithObjects() {
        Student pavel = new Student("Pavel", "Testerovich");
        pavel.setAge(80);
        pavel.setPhone(37211111122L);

        Student nadja = new Student();
        nadja.setFirstName("Nadezhda");
        nadja.setLastName("Fig vam a ne ljubovj");
        nadja.setAge(69);
        nadja.setPhone("911");

        System.out.println("First student: " + nadja.getFirstName() + " " + nadja.getLastName());
        System.out.println("Second student: " + pavel.getFirstName() + " " + pavel.getLastName());

        System.out.println("First student: " + nadja.getFullName());
        System.out.println("Second student: " + pavel.getFullName());
    }
}
