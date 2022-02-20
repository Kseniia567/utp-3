package eu.glowacki.utp.assignment03.employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;


public abstract class Person {

	// (assignment 02)
	// attributes:
	// * first name
	// * surname
	// * birth date
	// * age (derived --- computed based on birth date)

    private final String _firstName; // backing field

    private final String _surname;

    private final LocalDate _birthDate;


    protected Person(String firstName, String surname, LocalDate date) {
        _firstName = firstName;
        _surname = surname;
        _birthDate = date;

    }

    public String getFirstName() { // getter
        return _firstName;
    }

    public String get_surname() {
        return _surname;
    }

    public LocalDate getDateOfBirth() {return _birthDate;}


    public short getAge() {

        LocalDate currentDate = LocalDate.now();
        return (short) Period.between(_birthDate, currentDate).getYears();
    }
	
	// (assignment 03)
	// methods:

    //BiPredicate<LocalDate, LocalDate> older = LocalDate::isBefore;
    //BiPredicate<LocalDate, LocalDate> younger = older.negate();



    // * compare ages
    Comparator<Person> compareAge = Comparator.comparing(Person::getAge);

    Comparator<Short> compareAgesWithPerson = Comparator.naturalOrder();

    public int ageCompare(short age) {
        return compareAgesWithPerson.compare(getAge(), age);
    }


    // * is older than other person
   public boolean isOlder(Person p2) {
        return compareAge.compare(this, p2) > 0;
    }


    // * is younger than other person

    public boolean isYounger(Person p2) {
        return compareAge.compare(this,p2) < 0;
    }









}