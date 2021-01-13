//Yi Ming Tan
import java.time.LocalDate;

public class Test {
    public static void main (String[] args) {

        Practice practice1 = new Practice(); //creates a practice
        Practice practice2 = new Practice(); //creates a practice


        //create 4 consultants
        Consultant consultant1 = new Consultant("Mark","Robert", "11", "ym@g.com", "Dental");
        Consultant consultant2 = new Consultant("Nick","Polom", "12", "ym@g.com", "Bone");
        Consultant consultant3 = new Consultant("Peach","Tan", "13", "ym@g.com", "Heart");
        Consultant consultant4 = new Consultant("Paul","Murphy", "14", "ym@g.com", "Heart");

        LocalDate dateTime1 = LocalDate.now();
        Visit visit1 = new Visit(dateTime1, "note1");
        Visit visit2 = new Visit(dateTime1, "note2");
        Visit visit3 = new Visit(dateTime1, "note3");


        Patient patient1 = new Patient("Howard","Pole", "1", "ym@g.com", "Coughing", Patient.Severity.MILD);
        patient1.addVisit(visit1);
        Patient patient2 = new Patient("Howie","Lim", "2", "ym@g.com", "Fever", Patient.Severity.SERIOUS);
        patient2.addVisit(visit2);
        patient2.addVisit(visit3);
        Patient patient3 = new Patient("Patrick","Lee", "3", "ym@g.com", "Back Pain", Patient.Severity.SEVERE);

        consultant1.addPatient(patient1);
        consultant2.addPatient(patient2);
        consultant3.addPatient(patient3);


        //add all 4 consultants
        practice1.addConsultant(consultant1);
        practice1.addConsultant(consultant2);
        practice1.addConsultant(consultant3);
        practice1.addConsultant(consultant4);


        System.out.println("p1");
        for (Consultant c : practice1.getConsultantArrayList()) {
            System.out.println(c);
            c.showAllPatientsAndVisits();
        }
        System.out.println("p2");
        for (Consultant c : practice2.getConsultantArrayList()) {
            System.out.println(c);
            c.showAllPatientsAndVisits();
        }
    }
}
