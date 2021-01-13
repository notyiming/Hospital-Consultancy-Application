//Yi Ming Tan
import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person {
    private ArrayList<Visit> visitArrayList;
    private String illness;
    enum Severity {
        MILD,
        MODERATE,
        SERIOUS,
        DANGER,
        SEVERE
    }
    private Severity level;

    public Patient(String firstname, String lastname, String id, String email, String illness, Severity level) {
        super(firstname, lastname, id, email);
        this.illness = illness;
        this.visitArrayList = new ArrayList<>();
        this.level = level;
    }

    public void addVisit (Visit visit) {
        visitArrayList.add(visit);
    }

    public void addPatientVisit(LocalDate date, String note) {
        Visit visit = new Visit(date, note);
        addVisit(visit);
    }

    public void showAllVisits() {
        for (Visit v:visitArrayList){
            System.out.println(v);
        }
    }

    public ArrayList<Visit> getVisitArrayList() {
        return visitArrayList;
    }

    public void setVisitArrayList(ArrayList<Visit> visitArrayList) {
        this.visitArrayList = visitArrayList;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Severity getLevel() {
        return level;
    }

    public void setLevel(Severity level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name.getFirstname() + " " + name.getLastname()+
                "\nPatient ID: " + id +
                "\nIllness: " + illness +
                "\nSeverity: " + level +
                "\nemail: " + email + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;

        if (!visitArrayList.equals(patient.visitArrayList)) return false;
        if (!illness.equals(patient.illness)) return false;
        return level == patient.level;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + visitArrayList.hashCode();
        result = 31 * result + illness.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }
}
