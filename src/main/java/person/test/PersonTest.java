package person.test;

import java.sql.SQLException;
import java.util.List;
import person.dto.PersonDTO;
import person.jdbc.*;
/**
 *
 * @author isaaclem
 */
public class PersonTest {
    public static void main(String[] args) {
        DaoPerson personDao = new DaoPersonJdbc();
        
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("Johnathan");
        try {
            // Insert new person
//          personDao.insert(personDTO);
            
            //Delete person
//          personDao.delete(new PersonDTO(3));
            
            //Update person
//            PersonDTO person2 = new PersonDTO();
//            person2.setIdPerson(2);
//            person2.setName("Jimmy White");
//            personDao.update(person2);
            //Select Records
            List<PersonDTO> persons = personDao.select();
            for (PersonDTO p: persons) {
                System.out.print(p);
                System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Data Layer Exception");
            e.printStackTrace(System.out);
        }
    }
}
