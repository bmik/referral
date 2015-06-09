package edu.uek.referral.model.repository;

import edu.uek.referral.model.entity.Referral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by bmik on 2015-06-07.
 */
public class ReferralRepository {

    private final RepositoryManager manager = RepositoryManager.getInstance();

    public void addReferral(Referral referral) {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "INSERT INTO referral (client_id, referral_code, create_date, examination_id, status) " +
                "VALUES (?,?,?,?,?)";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setLong(1, referral.getClientId());
            statement.setString(2, referral.getReferralCode());
            statement.setTimestamp(3, new Timestamp(referral.getCreateDate().getTime()));
            statement.setLong(4, referral.getExamintation().getId());
            statement.setString(5, referral.getStatus().toString());

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
