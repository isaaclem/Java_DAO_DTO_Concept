package person.dto;

/**
 *
 * @author isaaclem
 */
public class PersonDTO {
    private int idPerson;
    private String name;
    
    public PersonDTO(){}
    
    public PersonDTO(int personId) {
        this.idPerson = personId;
    }
    
    public int getPersonId() {
        return this.idPerson;
    }
    
    public void setIdPerson(int personId) {
        this.idPerson = personId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "PersonDTO{" + "idPerson=" + idPerson + ", name=" + name + '}';
    }
}
