//Yi Ming Tan
public class Person {
    protected Name name;
    protected String id;
    protected String email;

    public Person(String firstname, String lastname, String id, String email) {
        this.name = new Name(firstname, lastname);
        this.id = id;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String phone) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!id.equals(person.id)) return false;
        return email.equals(person.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
