import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Person {

    private String name;

    private String surname;

    private Date birthDate;

    private Boolean anotherCompanyOwner;

    private Boolean pensioner;

    private Boolean publicServer;

    private float salary;

    public Person(String name, String surname, Date birthDate, Boolean anotherCompanyOwner,
                  Boolean pensioner, Boolean publicServer, float salary) {
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.birthDate = birthDate;
        this.name = name;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
        this.salary = salary;
        this.surname = surname;
    }

    public String fullName() {
        return "%s %s".formatted(name, surname);
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    public boolean isMEI() {
        return calculateYearlySalary() < 130_000.0
                && getAge() > 18
                && !anotherCompanyOwner
                && !pensioner
                && !publicServer;
    }

    private long getAge() {
        LocalDate now = LocalDate.now();
        LocalDate birth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(birth, now);
    }
}