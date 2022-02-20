package eu.glowacki.utp.assignment03;

import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class HumanResourceStatistics {
	
	private HumanResourceStatistics() {}

	// The best solution is to implement the below features as static methods having a list of Employee as the first input argument.
	// In addition the list of arguments may be augmented with parameters required for the given feature.

	
	// (assignment 03)
	// methods:
	//
	// * search for Employees older than given employee and earning less than him

	public static List<Employee> olderThanAndEarnMore(List<Employee> allEmployees, Employee employee) {
		if (allEmployees.isEmpty()) {
			return null;
		}




		List <Employee> temp = allEmployees
				.stream()
				.filter(e -> e.isOlder(employee) && e.isLess(employee.getSal()))
				.collect(Collectors.toList());

		//for (Employee e:allEmployees) {
		//	if (e.isOlder(employee)) {
		//		temp.add(e);
		//	}
		//}

		return temp;
	}
	
	//
	// * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%

	public static List<Trainee> practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
		if (allEmployees.isEmpty()) {
			return null;
		}


		Predicate<Employee> trainee_search = (e) -> e instanceof Trainee;

		Predicate<Trainee> longerPractice = t -> t.isLonger(daysCount);
		Consumer<Trainee> raising = (t) -> t.set_salary(t.getSal().multiply(new BigDecimal("1.05")));


		List<Trainee> temp = allEmployees
				.stream()
				.filter(trainee_search)
				.map(e -> (Trainee) e)
				.filter(longerPractice)
				.collect(Collectors.toList());


		temp.forEach(raising);

		//for (Employee e: allEmployees) {
		//	if (trainee_search.test(e) && ((Trainee) e).isLonger(daysCount)) {
		//		raising.andThen(adding).accept((Trainee) e);
		//	}
		//}



		return temp;
	}
	
	//
	// * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller

	public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, int monthCount) {
		if (allEmployees.isEmpty()) {
			return null;
		}




		Consumer<Worker> giveBonus = (w) -> w.set_bonus(new BigDecimal("300"));

		Predicate <Employee> isWorker = (e) -> e instanceof Worker;


		Predicate<Worker> isLonger = w -> w.isLongerMonths(monthCount);


		List<Worker> temp = allEmployees
				.stream()
				.filter(isWorker)
				.map(e -> (Worker) e)
				.filter(isLonger)
				.collect(Collectors.toList());

		temp.forEach( w -> {
			if (!w.bonusGreater(new BigDecimal(300))) {
				w.set_bonus(new BigDecimal(300));
			}
		});

		//for (Employee e:allEmployees) {
		//	if (isWorker.test(e) && ((Worker) e).isLongerMonths(monthCount)) {
		//		if (!((Worker) e).bonusGreater(new BigDecimal("300"))) {
		//			giveBonus.accept((Worker) e);
		//		}

		//		adding.accept((Worker) e);
		//	}
		//}

		return temp;
	}
	
	//
	// * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%

	public static List<Worker> seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
		if (allEmployees.isEmpty()) {
			return null;
		}




		Consumer<Worker> raising = (w) -> w.set_salary(w.getSal().multiply(new BigDecimal("1.1")));

		Predicate<Employee> worker_search = (e) -> e instanceof Worker;
		Predicate<Worker> seniority_check = (w) -> w.isLongerYears(0) && !w.isLongerYears(4); //include 1 and 3


		List<Worker> temp = allEmployees
				.stream()
				.filter(worker_search)
				.map(e -> (Worker) e)
				.filter(seniority_check)
				.collect(Collectors.toList());

		temp.forEach(raising);



		//for(Employee e:allEmployees) {
		//	if (worker_search.test(e)) {
		//		if (seniority_check.test((Worker) e)) {
		//			raising.andThen(adding).accept((Worker) e);
		//		}
		//	}
		//}

		return temp;
	}
	
	//
	// * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee

	public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, Employee employee) {
		if (allEmployees.isEmpty()) {
			return null;
		}

		if (!(employee instanceof Worker)) {
			return null; //if employee is not instance of Worker, we can't check seniority
		}




		Consumer<Worker> align = (w) -> w.set_salary(employee.getSal());

		Predicate<Employee> worker_search = (e) -> e instanceof Worker;

		Predicate<Worker> longerSeniority = (w) -> w.greaterDate(((Worker) employee));
		Predicate<Worker> lessSal = (w) -> w.isLess(employee.getSal());

		List<Worker> temp = allEmployees
			.stream()
			.filter(worker_search)
			.map(e -> (Worker) e)
			.filter(longerSeniority.and(lessSal))
			.collect(Collectors.toList());


		temp.forEach(align);


		//for (Employee e: allEmployees) {
		//	if (worker_search.test(e)) {
		//		if (longerSeniority.and(lessSal).test((Worker) e)) {
		//			align.andThen(adding).accept((Worker) e);
		//		}
		//	}
		//}


		return temp;
	}
	
	//
	// * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years

	public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
		if (allEmployees.isEmpty()) {
			return null;
		}



		Predicate<Employee> worker_search = (e) -> e instanceof Worker;

		Predicate<Worker> seniority_check = (w) -> w.isLongerYears(1) && !w.isLongerYears(5);
		Predicate<Worker> checkAge = (w) -> w.ageCompare((short) age) > 0;



		List<Worker> temp = allEmployees
				.stream()
				.filter(worker_search)
				.map(e -> (Worker) e)
				.filter(seniority_check.and(checkAge))
				.collect(Collectors.toList());




		//for(Employee e: allEmployees) {
		//	if (worker_search.test(e)) {
		//		if (seniority_check.and(checkAge).test((Worker) e)) {
		//			adding.accept((Worker) e);
		//		}
		//	}
		//}

		return temp;
	}
}