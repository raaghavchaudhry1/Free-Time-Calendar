import java.util.ArrayList;

class FreeTimeCalculatorTest {
    Calendar freeCalendar;

    @org.junit.jupiter.api.Test
    void setUp() {
        StudentManager studentManager = new StudentManager();
        GroupManager groupManager = new GroupManager();
        EventCreator eventCreator =  new EventCreator();
        CalendarManager calendarManager = new CalendarManager();

        setUpGroup(studentManager, groupManager, eventCreator, calendarManager);

        FreeTimeCalculator freeTimeCalculator = new FreeTimeCalculator();
        freeCalendar = freeTimeCalculator.getFreeCalendar(groupManager, "0");
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(0).getStartTime());
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(0).getEndTime());
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(1).getStartTime());
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(1).getEndTime());
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(2).getStartTime());
        System.out.println(freeCalendar.getRecurring().get("Tuesday").get(2).getEndTime());
    }

    private void setUpGroup(StudentManager studentManager, GroupManager groupManager,
                            EventCreator eventCreator, CalendarManager calendarManager) {
        ArrayList<Student> students= new ArrayList<>();
        Student tim = new Student("tim", "123");
        Student tom = new Student("tom", "234");
        Student tam = new Student("tam", "345");
        Student tem = new Student("tem", "456");

        ArrayList<CalendarEvent> eventsTom = eventsTom(eventCreator);
        ArrayList<CalendarEvent> eventsTam = eventsTam(eventCreator);
        ArrayList<CalendarEvent> eventsTem = eventsTem(eventCreator);
        ArrayList<CalendarEvent> eventsTim = eventsTim(eventCreator);
        calendarManager.addRecurringEvents(tim, eventsTim);
        calendarManager.addRecurringEvents(tom, eventsTom);
        calendarManager.addRecurringEvents(tem, eventsTem);
        calendarManager.addRecurringEvents(tam, eventsTam);
        students.add(tim);
        students.add(tom);
        students.add(tam);
        students.add(tem);
        studentManager.addStudent(tim);
        studentManager.addStudent(tom);
        studentManager.addStudent(tam);
        studentManager.addStudent(tem);
        groupManager.CreateGroup(students, "222");
    }

    private ArrayList<CalendarEvent> eventsTem(EventCreator eventCreator) {
        ArrayList<CalendarEvent> eventsTem = new ArrayList();
        eventsTem.add(eventCreator.createEvent("207", 8.00f, 11.00f, "Thursday"));
        eventsTem.add(eventCreator.createEvent("207", 8.00f, 10.00f, "Wednesday"));
        eventsTem.add(eventCreator.createEvent("207", 8.00f, 12.00f, "Tuesday"));

        return eventsTem;
    }

    private ArrayList<CalendarEvent> eventsTam(EventCreator eventCreator) {
        ArrayList<CalendarEvent> eventsTam = new ArrayList();
        eventsTam.add(eventCreator.createEvent("207", 13.00f, 14.00f, "Tuesday"));
        eventsTam.add(eventCreator.createEvent("207", 10.00f, 12.00f, "Wednesday"));
        eventsTam.add(eventCreator.createEvent("207", 10.00f, 12.00f, "Monday"));
        return eventsTam;
    }

    private ArrayList<CalendarEvent> eventsTom(EventCreator eventCreator) {
        ArrayList<CalendarEvent> eventsTom = new ArrayList();
        eventsTom.add(eventCreator.createEvent("207", 10.00f, 12.00f, "Tuesday"));
        eventsTom.add(eventCreator.createEvent("207", 10.00f, 12.00f, "Thursday"));
        eventsTom.add(eventCreator.createEvent("207", 10.00f, 12.00f, "Friday"));
        return eventsTom;
    }

    private ArrayList<CalendarEvent> eventsTim(EventCreator eventCreator) {
        ArrayList<CalendarEvent> eventsTim = new ArrayList();
        eventsTim.add(eventCreator.createEvent("207", 8.00f, 10.00f, "Monday"));
        eventsTim.add(eventCreator.createEvent("207", 8.00f, 10.00f, "Wednesday"));
        eventsTim.add(eventCreator.createEvent("207", 8.00f, 10.00f, "Friday"));
        return eventsTim;
    }
}