//Yi Ming Tan
import java.time.LocalDate;

public class Visit {
    private LocalDate dateOfVisit;
    private String notes;

    public Visit(LocalDate dateOfVisit, String notes) {
        this.dateOfVisit = dateOfVisit;
        this.notes = notes;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Date of Visit: " + dateOfVisit +
                "\nNotes: " + notes + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (!dateOfVisit.equals(visit.dateOfVisit)) return false;
        return notes.equals(visit.notes);
    }

    @Override
    public int hashCode() {
        int result = dateOfVisit.hashCode();
        result = 31 * result + notes.hashCode();
        return result;
    }
}
