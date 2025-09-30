package modelo;

import java.util.ArrayList;

public class ManagePersons {
    private ArrayList<Person> persons = new ArrayList<>();
    public void addPerson (Person person){
        persons.add(person);
    }
    public ArrayList<Person> getPersons() {
        return persons;
    }
}
