//Yi Ming Tan
import java.util.ArrayList;

public class Consultant extends Person {
    private String expertise;
    private ArrayList<Patient> patientArrayList;

    public Consultant(String firstname, String lastname, String id, String email, String expertise) {
        super(firstname, lastname, id, email);
        this.expertise = expertise;
        this.patientArrayList = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patientArrayList.add(patient);
    }


    public void showAllPatients() {
        for (Patient p:patientArrayList){
            System.out.println(p);
        }
    }

    public void showAllPatientsAndVisits() {
        for(Patient p: patientArrayList){
            System.out.println(p);
            p.showAllVisits();
        }
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public ArrayList<Patient> getPatientArrayList() {
        return patientArrayList;
    }

    public void setPatientArrayList(ArrayList<Patient> patientArrayList) {
        this.patientArrayList = patientArrayList;
    }

    @Override
    public String toString() {
        return "Consultant Name: " + name.getFirstname() + " " + name.getLastname()+
                "\nConsultant ID: " + id +
                "\nExpertise: " + getExpertise() +
                "\nemail: " + email + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Consultant that = (Consultant) o;

        if (!expertise.equals(that.expertise)) return false;
        return patientArrayList.equals(that.patientArrayList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + expertise.hashCode();
        result = 31 * result + patientArrayList.hashCode();
        return result;
    }
}
