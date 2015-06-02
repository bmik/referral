package edu.uek.referral;

import edu.uek.referral.model.repository.RepositoryManager;

/**
 * Created by bmik on 2015-06-02.
 */
public class AppRunTest {

    public static void main(String[] args) {

        RepositoryManager repo = new RepositoryManager();

        repo.getConnection();

    }

}
