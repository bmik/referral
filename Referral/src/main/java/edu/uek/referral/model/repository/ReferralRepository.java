package edu.uek.referral.model.repository;

import edu.uek.referral.api.ReferralStatus;
import edu.uek.referral.model.entity.Examination;
import edu.uek.referral.model.entity.Referral;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            statement.setLong(4, referral.getExamination().getId());
            statement.setString(5, referral.getStatus().toString());

            statement.executeUpdate();


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

    public Referral getReferralByCode(String code) {

        Referral referral = null;

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM referral WHERE referral_code = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, code);

            ResultSet results = statement.executeQuery();

            if (results.next()) {
                referral = new Referral();

                referral.setId(results.getLong("id"));
                referral.setClientId(results.getLong("client_id"));
                referral.setReferralCode(results.getString("referral_code"));
                referral.setCreateDate(results.getDate("create_date"));
                referral.setExaminationDate(results.getDate("examination_date"));

                ExaminationRepository examinationRepository = new ExaminationRepository();
                Examination exam = examinationRepository.getExaminationById(results.getLong("examination_id"));
                referral.setExamination(exam);

                referral.setStatus(ReferralStatus.getByName(results.getString("status")));
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

        return referral;

    }

    public Referral getReferralById(long id) {
        Referral referral = null;

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM referral WHERE id = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet results = statement.executeQuery();

            if (results.next()) {
                referral = new Referral();

                referral.setId(results.getLong("id"));
                referral.setClientId(results.getLong("client_id"));
                referral.setReferralCode(results.getString("referral_code"));
                referral.setCreateDate(results.getDate("create_date"));
                referral.setExaminationDate(results.getDate("examination_date"));

                ExaminationRepository examinationRepository = new ExaminationRepository();
                Examination exam = examinationRepository.getExaminationById(results.getLong("examination_id"));
                referral.setExamination(exam);

                referral.setStatus(ReferralStatus.getByName(results.getString("status")));
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

        return referral;
    }

    public List<Referral> getReadyReferralList() {
        List<Referral> referralList = new ArrayList<Referral>();

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM referral WHERE status = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, ReferralStatus.READY.toString());

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Referral referral = new Referral();

                referral.setId(results.getLong("id"));
                referral.setClientId(results.getLong("client_id"));
                referral.setReferralCode(results.getString("referral_code"));
                referral.setCreateDate(results.getDate("create_date"));
                referral.setExaminationDate(results.getDate("examination_date"));

                ExaminationRepository examinationRepository = new ExaminationRepository();
                Examination exam = examinationRepository.getExaminationById(results.getLong("examination_id"));
                referral.setExamination(exam);

                referral.setStatus(ReferralStatus.getByName(results.getString("status")));

                referralList.add(referral);
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

        return referralList;
    }

    public List<Referral> getAllReadyReferralForClientList(long clientId) {
        List<Referral> referralList = new ArrayList<Referral>();

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM referral WHERE status = ? AND client_id = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, ReferralStatus.READY.toString());
            statement.setLong(2, clientId);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Referral referral = new Referral();

                referral.setId(results.getLong("id"));
                referral.setClientId(results.getLong("client_id"));
                referral.setReferralCode(results.getString("referral_code"));
                referral.setCreateDate(results.getDate("create_date"));
                referral.setExaminationDate(results.getDate("examination_date"));

                ExaminationRepository examinationRepository = new ExaminationRepository();
                Examination exam = examinationRepository.getExaminationById(results.getLong("examination_id"));
                referral.setExamination(exam);

                referral.setStatus(ReferralStatus.getByName(results.getString("status")));

                referralList.add(referral);
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

        return referralList;
    }

    public List<Referral> getAllNewReferralList() {
        List<Referral> referralList = new ArrayList<Referral>();

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM referral WHERE status = ?";

        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, ReferralStatus.NEW.toString());

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Referral referral = new Referral();

                referral.setId(results.getLong("id"));
                referral.setClientId(results.getLong("client_id"));
                referral.setReferralCode(results.getString("referral_code"));
                referral.setCreateDate(results.getDate("create_date"));
                referral.setExaminationDate(results.getDate("examination_date"));

                ExaminationRepository examinationRepository = new ExaminationRepository();
                Examination exam = examinationRepository.getExaminationById(results.getLong("examination_id"));
                referral.setExamination(exam);

                referral.setStatus(ReferralStatus.getByName(results.getString("status")));

                referralList.add(referral);
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

        return referralList;
    }

    public void updateReferral(long id, java.util.Date examinationDate, ReferralStatus status) {

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE referral SET examination_date = ?, status = ? WHERE id = ?";

        try {
            connection = manager.getConnection();

            statement = connection.prepareStatement(sql);
            if (examinationDate != null) {
                statement.setTimestamp(1, new Timestamp(examinationDate.getTime()));
            } else {
                statement.setTimestamp(1, null);
            }
            statement.setString(2, status.toString());
            statement.setLong(3, id);

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

}
