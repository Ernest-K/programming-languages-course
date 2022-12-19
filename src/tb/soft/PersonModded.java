package tb.soft;

import java.util.Objects;

public class PersonModded extends Person{
    public PersonModded(Person person) throws PersonException {
        super(person.getFirstName(), person.getLastName());
        this.birthYear = person.getBirthYear();
        this.job = person.getJob();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getBirthYear() == person.getBirthYear() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName());
    }

    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getBirthYear());
    }

    @Override
    public int compareTo(Object o) {

        if (!(o instanceof Person)) return 0;

        Person person = (Person) o;

        if (equals(person))
            return 0;

        if (!getFirstName().equals(person.getFirstName()))
            return getFirstName().compareTo(person.getFirstName());
        else if (!getLastName().equals(person.getLastName()))
            return getLastName().compareTo(person.getLastName());
        else if (getBirthYear() < person.getBirthYear())
            return -1;
        else if (getBirthYear() > person.getBirthYear())
            return 1;
        else
            return getJob().compareTo(person.getJob());
    }
}
