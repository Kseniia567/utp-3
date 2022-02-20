package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Function;

public class Worker extends Employee {

	// (assignment 02)
	// attributes:
	// * employment date
	// * bonus
    // attributes
    // * employment date
    private final LocalDate _employmentDate;
    // * bonus
    private BigDecimal _bonus;


    public LocalDate get_employmentDate() {
        return _employmentDate;
    }

    public BigDecimal get_bonus() {
        return _bonus;
    }



    public Worker(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager, LocalDate empDate, BigDecimal bonus) {
        super(firstName, surname, date, sal, manager);
        _employmentDate = empDate;
        _bonus = bonus;

    }


    // for the highest seniority
    public long workDays() {

        return ChronoUnit.DAYS.between(_employmentDate, LocalDate.now());
    }
	
	// (assignment 03)
	// attributes:
	// * has bonus

    public void set_bonus(BigDecimal _bonus) {
        this._bonus = _bonus;
    }


    //
	// methods:
	// * seniority is longer than given number of years (seniority - sta¿)

    Function<LocalDate, Long> dateToYears = (d) -> ChronoUnit.YEARS.between(d, LocalDate.now());
    Function<LocalDate, Long> dateToMonths = (d) -> ChronoUnit.MONTHS.between(d, LocalDate.now());




    public boolean isLongerYears(long yearNumb) {
        return dateToYears.apply(_employmentDate) > yearNumb;
    }

	// * seniority is longer than given number of months
    public boolean isLongerMonths(long monthNumb) {
        return dateToMonths.apply(_employmentDate) > monthNumb;
    }
	// * has bonus greater than given amount of money
    Comparator<BigDecimal> comparator = BigDecimal::compareTo;
    public boolean bonusGreater (BigDecimal amount) {
        return comparator.compare(_bonus, amount) > 0;
    }


    Comparator<Worker> dateComparing = Comparator.comparing(Worker::get_employmentDate);

    public boolean greaterDate(Worker w2) {
        return dateComparing.compare(this, w2) < 0;
    }
}