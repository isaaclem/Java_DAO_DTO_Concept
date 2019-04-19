package person.jdbc;

import java.sql.*;
import java.util.*;
import person.dto.PersonDTO;
/**
 *
 * @author isaaclem
 */
public class DaoPersonJdbc implements DaoPerson {
    private java.sql.Connection userConn;
    private final String SQL_INSERT = "INSERT INTO person(name) VALUES (?)";
    private final String SQL_UPDATE = "UPDATE person SET name=? WHERE id_person=?";
    private final String SQL_DELETE = "DELETE FROM person WHERE id_person=?";
    private final String SQL_SELECT = "SELECT id_person, name FROM person ORDER BY id_person";
    
    public DaoPersonJdbc(){}
    
    public DaoPersonJdbc(Connection conn) {
        this.userConn = conn;
    }
    
    @Override
    public int insert(PersonDTO personDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = (this.userConn != null) ? this.userConn : JConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, personDTO.getName());
            System.out.println("Executing query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Inserted records: " + rows);
        } finally {
            if (this.userConn == null) {
                JConnection.close(conn);
            }
        }
        return rows;
    }
    
    @Override
    public int update(PersonDTO personDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = this.userConn != null ? this.userConn : JConnection.getConnection();
            System.out.println("Executing query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, personDTO.getName());
            stmt.setInt(2, personDTO.getPersonId());
            rows = stmt.executeUpdate();
            System.out.println("Updated records: " + rows);
        } finally {
            if (this.userConn == null) {
                JConnection.close(conn);
            }
        }
        
        return rows;
    }
    
    @Override
    public int delete(PersonDTO personDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = this.userConn != null ? this.userConn : JConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, personDTO.getPersonId());
            rows = stmt.executeUpdate();
            System.out.println("Delete records: " + rows);
        } finally {
            if (this.userConn == null) {
                JConnection.close(conn);
            }
        }
        return rows;
    }
    
    @Override
    public List<PersonDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonDTO person = null;
        List<PersonDTO> persons = new ArrayList<>();
        try {
            conn = this.userConn != null ? this.userConn : JConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_person = rs.getInt(1);
                String name = rs.getString(2);
                person = new PersonDTO();
                person.setIdPerson(id_person);
                person.setName(name);
                persons.add(person);
            }
        } finally {
            if (this.userConn == null) {
                JConnection.close(conn);
            }
        }
        return persons;
    }
}
