package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public abstract class Employee extends Person {

	// (assignment 02)
	// attributes:
	// * salary
	// * manager (empty if at top of hierarchy)
    private BigDecimal _salary;
    // * salary (use BigDecimal type for representing currency values)
    private final Manager _manager;
    // * manager (empty if at top of hierarchy)


    public BigDecimal getSal() {
        return _salary;
    }

    public Manager get_manager() {
        return _manager;
    }



    protected Employee(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager) {
        super(firstName, surname, date);
        _salary = sal;
        _manager = manager;
    }


    public void set_salary(BigDecimal _salary) {
        this._salary = _salary;
    }



	// (assignment 03)
	// methods:

	// * salary is greater than given amount of money
    Predicate<Integer> greater = (n) -> n > 0;
    Predicate<Integer> less = greater.negate();


    public boolean isGreater (BigDecimal amount) {
        int res = _salary.compareTo(amount);
        return greater.test(res);
    }



	// * salary is less than given amount of money
    public boolean isLess (BigDecimal amount) {
        int res = _salary.compareTo(amount);
        return less.test(res);
    }
	// * compare salary with other employee salary

    Comparator<Employee> compareSal = Comparator.comparing(Employee::getSal);

    public int compareSalEmp(Employee e2) {
        return compareSal.compare(this, e2);
    }
}