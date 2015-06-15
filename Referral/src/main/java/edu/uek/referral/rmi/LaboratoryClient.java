package edu.uek.referral.rmi;

import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.logic.util.PropertyHandler;
import edu.uek.referral.model.entity.Examination;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 * Created by ahmed on 09.06.15.
 */
public class LaboratoryClient extends JFrame {

    private long clientID;
    Laboratory lab;
    private List<Examination> examinationList;
    JPanel mainPanel, addReferralPanel, referralListPanel;

    public static void main(String[] args) {
        new LaboratoryClient();
    }

    public LaboratoryClient() {
        super("Placówka medyczna");

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        clientID = generateClientId();

        JPanel clientPanel = new JPanel();
        clientPanel.add(new JLabel("Twoje ID: "));
        JTextField clientIdText = new JTextField(String.valueOf(clientID), 20);
        clientIdText.setEditable(false);
        clientPanel.add(clientIdText);

        mainPanel = new JPanel();


        JButton addReferral = new JButton("Dodaj nowe skierowanie");
        JButton getReferrals = new JButton("Pobierz wyniki badań");

        ButtonListener listener = new ButtonListener();

        addReferral.addActionListener(listener);
        getReferrals.addActionListener(listener);

        mainPanel.add(addReferral);
        mainPanel.add(getReferrals);

        add(clientPanel, BorderLayout.NORTH);

        /*lab = getLaboratory();
        examinationList = resolveExaminationList(lab);*/

        addReferralPanel = new JPanel();
        addReferralPanel.setLayout(new BorderLayout());
        addReferralPanel.add(new JLabel("Dodawanie nowego skierowania"), BorderLayout.NORTH);
        JPanel formPanel = new JPanel()

        referralListPanel = new JPanel();
        referralListPanel.add(new JLabel("Lista wyników badań"));

        add(mainPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LaboratoryClient.this.remove(mainPanel);
            if (actionEvent.getActionCommand().equals("Dodaj nowe skierowanie")) {
                LaboratoryClient.this.add(addReferralPanel, BorderLayout.CENTER);
                LaboratoryClient.this.getContentPane().revalidate();
                LaboratoryClient.this.getContentPane().repaint();
            } else if (actionEvent.getActionCommand().equals("Pobierz wyniki badań")){
                LaboratoryClient.this.add(referralListPanel, BorderLayout.CENTER);
                LaboratoryClient.this.getContentPane().revalidate();
                LaboratoryClient.this.getContentPane().repaint();
            }
        }
    }

    private long generateClientId() {

        return (long) (Math.random() * 200);

    }

    private List<Examination> resolveExaminationList(Laboratory lab) {

        GetExaminationListRequest request = new GetExaminationListRequest();
        request.setClientId(clientID);
        try {
            GetExaminationListResponse response = lab.getExaminationList(request);
            examinationList = response.getExaminationList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return examinationList;
    }

    private Laboratory getLaboratory() {

        Registry registry = null;
        Laboratory laboratory = null;
        try {
            registry = LocateRegistry.getRegistry(PropertyHandler.getProperty("rmi.address"));
            laboratory = (Laboratory) registry.lookup(PropertyHandler.getProperty("rmi.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return laboratory;

    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

}
