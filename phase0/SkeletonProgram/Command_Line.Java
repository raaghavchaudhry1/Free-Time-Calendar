//import java.beans.DesignMode;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Commandline {
//
//    public static void main(String[] Args) {
//        Scanner in = new Scanner(System.in);
//        boolean LoggedIN = false;
//        StudentManager studM = new StudentManager();
//        LogIn login = new LogIn(studM);
//        CalendarManager calManager = new CalendarManager();
//        String currUsername = new String();
//        Student currStudent = null;
//        while (!LoggedIN) {
//            System.out.println("Choose to Login By entering 0, or Choose to make new account by entering 1");
//            String input = in.nextLine();
//            if (input.equals("0")) {
//                System.out.println("Please Enter your Username: ");
//                String username = in.nextLine();
//                if (login.checkUsername(username)) {
//                    System.out.println("Please Enter your Password: ");
//                    String password = in.nextLine();
//                    if (login.validateLogIn(username, password)) {
//                        currUsername = username;
//                        System.out.println("Successfully Logged In ");
//                        LoggedIN = true;
//
//                    } else {
//                        System.out.println("Invalid Combination");
//                    }
//                }
//                else {
//                    System.out.println("Username not in the System1");
//                }
//
//
//
//            } else if (input.equals("1")) {
//                System.out.println("Please Enter your Username: ");
//                String username = in.nextLine();
//                System.out.println("Please Enter your Password: ");
//                String password = in.nextLine();
//                studM.addNewStudent(username,password);
//
//
//            }
//        }
//
//        System.out.println("Import Calendar 0 Or Manually Create Calendar 1 ");
//        String Decision = in.nextLine();
//
//        boolean valid = false;
//
//        while (!valid) {
//
//            if (Decision.equals("1")) {
//                currStudent = studM.getAllStudents().get(currUsername);
//                System.out.println("Add Recurring event (0) or Add Onetime event (1) or exit (2)");
//                String Calendar_Decision = in.nextLine();
//
//                if (Calendar_Decision.equals("1")) {
//
//                    boolean KeepAdding = true;
//                    ArrayList<OneOffEvent> events = new ArrayList();
//                    EventCreator evenC = new EventCreator();
//                    while(KeepAdding) {
//
//                        System.out.println("Enter In the Event Name");
//                        String eventName = in.nextLine();
//                        System.out.println("Enter in Start Time in the format -- hh.mm");
//                        Float startTime = Float.parseFloat(in.nextLine());
//                        System.out.println("Enter in End Time in the format -- hh.mm");
//                        Float endTime = Float.parseFloat(in.nextLine());
//                        System.out.println("Enter in Date in the format -- mm.dd");
//                        Float date = Float.parseFloat(in.nextLine());
//                        events.add(evenC.createEvent(eventName,startTime,endTime,date));
//                        System.out.println("Add More? Y or N");
//                        if (in.nextLine().equals("N")) {
//                            KeepAdding = false;
//                        }
//                    }
//                    calManager.addSingleEvents(currStudent, events);
//                    System.out.println("Here is your calendar so far");
//                    System.out.println(currStudent.getStudentSchedule().getSingle().toString());
//
//
//                } else if (Calendar_Decision.equals("0")) {
//
//                    boolean KeepAdding = true;
//                    ArrayList<CalendarEvent> events = new ArrayList();
//                    EventCreator evenC = new EventCreator();
//                    while (KeepAdding) {
//
//                        System.out.println("Enter In the Event Name");
//                        String eventName = in.nextLine();
//                        System.out.println("Enter in Start Time in the format -- hh.mm");
//                        Float startTime = Float.parseFloat(in.nextLine());
//                        System.out.println("Enter in End Time in the format -- hh.mm");
//                        Float endTime = Float.parseFloat(in.nextLine());
//                        System.out.println("Enter in Day from the set -- {Monday, Tuesday, Wednesday, Thursday" +
//                                ", Friday, Saturday, Sunday}");
//                        String day = in.nextLine();
//                        events.add(evenC.createEvent(eventName, startTime, endTime, day));
//                        System.out.println("Add More? Y or N");
//                        if (in.nextLine().equals("N")) {
//                            KeepAdding = false;
//                        }
//                    }
//                    calManager.addRecurringEvents(currStudent, events);
//                    System.out.println("Here is your calendar so far");
//                    System.out.println(currStudent.getStudentSchedule().getRecurring().toString());
//
//                } else if(Calendar_Decision.equals("2")){
//                    valid = true;
//                } else {
//                    System.out.println("Invalid Input! ");
//                }
//
//
//            } else if (Decision.equals("0")) {
//
//                System.out.println("Feature not yet created");
//
//            } else {
//                System.out.println("Invaild Input");
//            }
//        }
//
//        System.out.println("Create Group? Y or N");
//        String answer = in.nextLine();
//        if (answer.equals("Y")){
//            GroupManager gr = new GroupManager();
//            ArrayList<Student> temp = new ArrayList<Student>();
//            temp.add(currStudent);
//            System.out.println("Enter In a Group Name");
//            String grName = in.nextLine();
//            gr.CreateGroup(temp, grName);
//            // TODO maybe print the group name
//            System.out.println("Group is created");
//        }
//
//    }
//
//
//}