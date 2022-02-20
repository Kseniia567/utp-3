package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.BiPredicate;

public class Trainee extends Employee {

	// (assignment 02)
	// attributes:
	// * practice start date
	// * practice length (in days)
    // attributes:
    // * apprenticeship start date
    private final LocalDate _startDate;
    private final int _apprenticeship_length;
    // * apprenticeship length (in days)

    public Trainee(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager, LocalDate startDate, int a_Length) {
        super(firstName, surname, date, sal, manager);
        _startDate = startDate;
        _apprenticeship_length = a_Length;
    }

    public LocalDate get_startDate() {
        return _startDate;
    }


    public int get_apprenticeship_length() {
        return _apprenticeship_length;
    }

	
	// (assignment 03)
	// * practice length is shorter than given number of days
    BiPredicate<Integer, Integer> longer = (p1, p2) -> p1 > p2;
    BiPredicate<Integer, Integer> shorter = longer.negate();


    public boolean isShorter(int length) {
        return shorter.test(_apprenticeship_length, length);
    }

	// * practice length is longer than given number of days
    public boolean isLonger (int length) {
        return longer.test(_apprenticeship_length, length);
    }
}