package dao;

import model.Database;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

/**
 * This class inherits the database class Contains the crud from the Users table
 *
 * @author Anthony
 * @Date 20/02/2019
 */
public class Users_crud {

    // Define the variables of my objects
    Users users;
    Configuration configuration;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;

    // -------------------------------------------------------------------------
    //             CONSTRUCTOR (As soon as the class is called)
    // -------------------------------------------------------------------------
    public Users_crud() throws SQLException {
        users = new Users();
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    // -------------------------------------------------------------------------
    //                      METHODS (CRUD)
    // CREATE                           : insert a user 
    // READ RETURN LIST                 : recovery a user list (display all)
    // READ RETURN OBJECT VIA ID        : recovery a user via id (edit)
    // READ RETURN OBJECT VIA EMAIL     : recovery a user via email (login)
    // UPDATE VIA ID                    : update a user via id
    // DELETE VIA ID                    : delete user via id
    // -------------------------------------------------------------------------
    public void create(Users users) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public List<Users> read() throws SQLException {
        List<Users> list = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            list = session.createCriteria(Users.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public Users readById(Users users) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            users = (Users) session.get(Users.class, users.getId());
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

   /* public int login(String email, String password) throws SQLException {
        session = sessionFactory.openSession();
        int count = 0;
        count = (int) session.createCriteria("select count(*) from users WHERE email = " + email + " AND password = " + password).uniqueResult();
        return count;
    }*/

    public Users getLogin(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection con = (Connection) Database.getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            users.setId(rs.getInt("id"));
        }
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            users = (Users) session.get(Users.class, users.getId());
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    public void update(Users users) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(users);
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void delete(Users users) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(users);
            transaction.commit();
        } catch (HibernateException e) {
            e.getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

}
