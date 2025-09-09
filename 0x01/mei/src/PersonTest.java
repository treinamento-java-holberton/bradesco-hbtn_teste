import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    public static final float DEFAULT_SALARY = 1200.0F;
    public static final float EXPECTED_YEARLY_SALARY = 14400.0F;
    private Person person;
    private final Date birthdate = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();

    @BeforeEach
    public void setup() {

        this.person = new Person(
                "Paul", "McCartney", birthdate,
                Boolean.TRUE, Boolean.TRUE,Boolean.TRUE, DEFAULT_SALARY);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(EXPECTED_YEARLY_SALARY, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        person = new Person(
                "Paul", "McCartney", birthdate,
                Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, DEFAULT_SALARY);

        assertTrue(person.isMEI());
    }
}