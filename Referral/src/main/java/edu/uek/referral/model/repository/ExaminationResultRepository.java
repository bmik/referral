package edu.uek.referral.model.repository;

import edu.uek.referral.model.entity.ExaminationResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ahmed on 09.06.15.
 */
public class ExaminationResultRepository {

    private final RepositoryManager manager = RepositoryManager.getInstance();

    public void addExaminationResult(long referralId, String parameterName, String parameterValue, String parameterUnit,
                                     String comment) {

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO examination_result (referral_id, parameter_name, parameter_value, parameter_unit, comment)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            connection = manager.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setLong(1, referralId);
            statement.setString(2, parameterName);
            statement.setString(3, parameterValue);
            statement.setString(4, parameterUnit);
            statement.setString(5, comment);

            statement.executeUpdate();

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

    }

    public ExaminationResult getExaminationResultByReferralId(long referralId) {

        ExaminationResult examinationResult = null;

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM examination_result WHERE referral_id = ?";

        try {
            connection = manager.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setLong(1, referralId);

            ResultSet results = statement.executeQuery();

            if (results.next()) {
                examinationResult = new ExaminationResult();

                examinationResult.setId(results.getLong("id"));
                examinationResult.setReferralId(results.getLong("referral_id"));
                examinationResult.setParameterName(results.getString("parameter_name"));
                examinationResult.setParameterValue(results.getString("parameter_value"));
                examinationResult.setParameterUnit("parameter_unit");
                examinationResult.setComment(results.getString("comment"));
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

        return examinationResult;

    }

}
