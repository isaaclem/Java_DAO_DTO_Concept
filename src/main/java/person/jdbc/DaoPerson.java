package person.jdbc;

import java.sql.SQLException;
import java.util.List;
import person.dto.PersonDTO;

/**
 *
 * @author isaaclem
 */
public interface DaoPerson {
    public int insert(PersonDTO p) throws SQLException;
    public int update(PersonDTO p) throws SQLException;
    public int delete(PersonDTO p) throws SQLException;
    public List<PersonDTO> select() throws SQLException;
}
