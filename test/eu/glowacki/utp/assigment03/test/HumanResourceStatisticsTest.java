package assigment03.test;

import eu.glowacki.utp.assignment03.HumanResourceStatistics;
import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Manager;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanResourceStatisticsTest {

    private List<Employee> _allEmployees;
    // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)


    @Before
    public void before (){
        _allEmployees = new ArrayList<>();

        List<Employee> level1 = new ArrayList<>();


        Manager director = new Manager("Artemii","Fedorchenko", LocalDate.of(1973,12,22),new BigDecimal(9000),
                null, LocalDate.of(1992,6,6),new BigDecimal(100),level1);
        _allEmployees.add(director);

        List<Employee> level2m1 = new ArrayList<>();


        Manager manager1 = new Manager("Alina","Solopova", LocalDate.of(1980,5,11),new BigDecimal(8500),
                director,LocalDate.of(2000,2,21),new BigDecimal(700),level2m1);
        level1.add(manager1);
        _allEmployees.add(manager1);

        Worker w1m1 = new Worker("Anna","Ivanova",LocalDate.of(1979,12,5),new BigDecimal(1900),
                manager1,LocalDate.of(1999,9,21),new BigDecimal(100));
        _allEmployees.add(w1m1);

        Worker w2m1 = new Worker("Denis","Alihanov",LocalDate.of(1990,8,10),new BigDecimal(1000),
                manager1,LocalDate.of(2007,11,1),new BigDecimal(150));
        _allEmployees.add(w2m1);

        Trainee t1m1 = new Trainee("Mariia","Serova",LocalDate.of(2000,12,3),new BigDecimal(500),
                manager1,LocalDate.of(2013,11,1), 350);
        _allEmployees.add(t1m1);

        Trainee t2m1 = new Trainee("Sergei","Baranov",LocalDate.of(2002,8,13),new BigDecimal(600),
                manager1,LocalDate.of(2020,1,13), 200);
        _allEmployees.add(t2m1);

        level2m1.add(w1m1);
        level2m1.add(w2m1);
        level2m1.add(t1m1);
        level2m1.add(t2m1);              //1 person with surname A......

        List<Employee> level2m2 = new ArrayList<>();

        Manager manager2 = new Manager("Anastasia","Osokina", LocalDate.of(1991,2,4),new BigDecimal(7000),
                director,LocalDate.of(2014,2,1),new BigDecimal(1500),level2m2);
        level1.add(manager2);
        _allEmployees.add(manager2);

        Worker w1m2 = new Worker("Vasiliy","Livanov",LocalDate.of(2000,9,21),new BigDecimal(2500),
                manager2,LocalDate.of(2020,2,13),new BigDecimal(120));
        _allEmployees.add(w1m2);

        Worker w2m2 = new Worker("Alisa","Klimenko",LocalDate.of(1980,2,2),new BigDecimal(800),
                manager2,LocalDate.of(2006,6,28),new BigDecimal(100));
        _allEmployees.add(w2m2);

        Worker w3m2 = new Worker("Alexandr","Antropov",LocalDate.of(1990,5,2),new BigDecimal(700),
                manager2,LocalDate.of(2021,1,19),new BigDecimal(100));
        _allEmployees.add(w3m2);

        Trainee t1m2 = new Trainee("Viktoriia","Solntceva",LocalDate.of(2001,8,2),new BigDecimal(600),
                manager2,LocalDate.of(2007,11,1), 120);
        _allEmployees.add(t1m2);

        Trainee t2m2 = new Trainee("Viktor","Cherepanov",LocalDate.of(2000,4,2),new BigDecimal(200),
                manager2,LocalDate.of(2021,2,2), 230);
        _allEmployees.add(t2m2);

        Trainee t3m2 = new Trainee("Lev","Malinovski",LocalDate.of(1998,12,14),new BigDecimal(500),
                manager2,LocalDate.of(2020,2,1), 250);
        _allEmployees.add(t3m2);

        level2m2.add(w1m2);
        level2m2.add(w2m2);
        level2m2.add(w3m2);
        level2m2.add(t1m2);
        level2m2.add(t2m2);
        level2m2.add(t3m2); //1 person with surname A......

        List<Employee> level2m3 = new ArrayList<>();

        Manager manager3 = new Manager("Kseniia","Smirnova", LocalDate.of(1977,6,12),new BigDecimal(7000),
                director,LocalDate.of(2019,3,4),new BigDecimal(100),level2m3);
        level1.add(manager3);
        _allEmployees.add(manager3);

        Worker w1m3 = new Worker("Sofiia","Lisitsina",LocalDate.of(2001,9,11),new BigDecimal(2000),
                manager3,LocalDate.of(2020,6,13),new BigDecimal(100));
        _allEmployees.add(w1m3);

        Worker w2m3 = new Worker("Ekaterina","Romanovna",LocalDate.of(2002,2,12),new BigDecimal(1000),
                manager3,LocalDate.of(2021,6,17),new BigDecimal(100));
        _allEmployees.add(w2m3);

        //SENIOR
        Worker w3m3 = new Worker("Boris","Voronin",LocalDate.of(1980,1,5),new BigDecimal(900),
                manager3,LocalDate.of(2000,12,9),new BigDecimal(100));
        _allEmployees.add(w3m3);

        Trainee t1m3 = new Trainee("Vasilisa","Karpova",LocalDate.of(1996,12,21),new BigDecimal(650),
                manager3,LocalDate.of(2020,2,1), 450);
        _allEmployees.add(t1m3);

        Trainee t2m3 = new Trainee("Ruslan","Dolgov",LocalDate.of(1970,8,3),new BigDecimal(100),
                manager3,LocalDate.of(2013,6,13), 500);
        _allEmployees.add(t2m3);

        Trainee t3m3 = new Trainee("Yurii","Gagarin",LocalDate.of(2008,6,7),new BigDecimal(300),
                manager3,LocalDate.of(2021,10,3), 190);
        _allEmployees.add(t3m3);


        level2m3.add(w1m3);
        level2m3.add(w2m3);
        level2m3.add(w3m3);
        level2m3.add(t1m3);
        level2m3.add(t2m3);
        level2m3.add(t3m3);    //0 person with surname A......
    }

    @Test
    public void olderThanAndEarnMore() {
        Employee emp = _allEmployees.get(3); //sal = 1000
        List<Employee> temp = HumanResourceStatistics.olderThanAndEarnMore(_allEmployees, emp);


        Assert.assertEquals("Alisa", temp.get(0).getFirstName());
        Assert.assertEquals(3, temp.size());

    }

    @Test
    public void practiceLengthLongerThan() {
        List<Trainee> temp = HumanResourceStatistics.practiceLengthLongerThan(_allEmployees, 150);

        Assert.assertEquals("Mariia", temp.get(0).getFirstName());
        Assert.assertEquals(new BigDecimal(315), temp.get(temp.size()-1).getSal().setScale(0));
        Assert.assertEquals(7, temp.size());
    }

    @Test
    public void seniorityLongerThan() {
        List<Worker> temp = HumanResourceStatistics.seniorityLongerThan(_allEmployees, 48);

        Assert.assertEquals(new BigDecimal(300), temp.get(0).get_bonus());
        Assert.assertEquals(new BigDecimal(700), temp.get(1).get_bonus());
        Assert.assertEquals(7, temp.size());

    }

    @Test
    public void seniorityBetweenOneAndThreeYears() {
        List<Worker> temp = HumanResourceStatistics.seniorityBetweenOneAndThreeYears(_allEmployees);
        Assert.assertEquals(3, temp.size());
        Assert.assertEquals(new BigDecimal(2750), temp.get(0).getSal().setScale(0));


    }

    @Test
    public void testSeniorityLongerThan() {
        Employee emp = _allEmployees.get(3);
        List<Worker> temp = HumanResourceStatistics.seniorityLongerThan(_allEmployees, emp);

        Assert.assertEquals(temp.get(0).getSal(), emp.getSal());
        Assert.assertEquals("Alisa", temp.get(0).getFirstName());
    }

    @Test
    public void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan() {
        List<Worker> temp = HumanResourceStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(_allEmployees, 18);

        Assert.assertEquals("Kseniia", temp.get(0).getFirstName());
    }
}