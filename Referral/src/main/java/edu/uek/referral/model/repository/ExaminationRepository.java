package edu.uek.referral.model.repository;

import edu.uek.referral.model.entity.Examination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmik on 2015-06-07.
 */
public class ExaminationRepository {

    private final RepositoryManager manager = RepositoryManager.getInstance();

    public List<Examination> getExaminationList() {

        List<Examination> examinationList = new ArrayList<Examination>();

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT id,code,name FROM examination";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Examination e = new Examination();
                e.setId(results.getLong("id"));
                e.setCode(results.getString("code"));
                e.setName(results.getString("name"));

                examinationList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return examinationList;
    }

    public Examination getExaminationById(long id) {

        Examination examination = null;

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM examination WHERE id = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet results = statement.executeQuery();

            if (results.first()) {
                examination = new Examination();

                examination.setId(id);
                examination.setName(results.getString("name"));
                examination.setCode(results.getString("code"));
            }

            if (results.next() != false) {
                throw new RuntimeException("Too many results!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return examination;

    }

}
