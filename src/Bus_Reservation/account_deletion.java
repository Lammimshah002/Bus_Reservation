/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class account_deletion extends javax.swing.JFrame {

    /**
     * Creates new form account_deletion
     */
    public account_deletion() {
        initComponents();
        connect();
    }
    String username_ad;
    String gmail_ad;
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    ResultSet rs;
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int randomCode;
    String code;
    
    Timer t;
    TimerTask task;
    
    
    public void send_otp()
    {
        try{
            
            Random rand = new Random();

            randomCode=rand.nextInt(999999);
            code=Integer.toString(randomCode);

            String host = "smtp.gmail.com";

            String user ="zuhaernoman@gmail.com";

            String pass="rarhqsjvxgjovnqs";
            String subject="Verification Code ";

            String msg ="Your verification code is :"+randomCode;

            boolean sessionDebug = false;

            Properties props = new Properties();  
            props.setProperty("mail.transport.protocol", "smtp");     
            props.setProperty("mail.host", "smtp.gmail.com");  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.smtp.port", "465");  
            props.put("mail.debug", "true");  
            props.put("mail.smtp.socketFactory.port", "465");  
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
            props.put("mail.smtp.socketFactory.fallback", "false");  
            Session session = Session.getDefaultInstance(props,  
            new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {  
               return new PasswordAuthentication(user,pass);  
           }  
           });  

           //session.setDebug(true);  
           Transport transport = session.getTransport();  
           InternetAddress addressFrom = new InternetAddress("user");  

           MimeMessage message = new MimeMessage(session);  
           message.setSender(addressFrom);  
           message.setSubject(subject);  
           message.setContent("Hello "+username_ad+"."+msg, "text/plain");  
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(gmail_ad));  

           transport.connect();  
           Transport.send(message); 
           
           transport.close();
           timer();
           JOptionPane.showMessageDialog(this, "Message sent");
           
           
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Check Wi-Fi or Invalid Address! Go back & Check your Email");
            ex.printStackTrace();}  
 }
    
    int count;
    int timeup;
    
    public void timer()
    {
        count=0;
        timeup=0;
        
        t=new Timer();
        task=new TimerTask()
        {
            @Override
            public void run() {
                count++;
                if(count<61)
                {
                   timer.setText(Integer.toString(count)); 
                }
                else
                {
                    timeup=1;
                    t.cancel();
                    resendotp.setEnabled(true);
                    otp.setEditable(false);
                    otp.setText("");
                    account_deletion ad=new account_deletion();
                    JOptionPane.showMessageDialog(ad,"Time UP! Press Re-Send to get another code");

                }

            }
        }; 
        t.scheduleAtFixedRate(task,0,1000);   
    }
    String password;
    public void getpass()
    {
        try {
            pst=con.prepareStatement("select password from customer_account where email=?");
            pst.setString(1,gmail_ad);
            rs=pst.executeQuery();
            while (rs.next())
            {
                password=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(account_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String mobile;
    public void mobileno()
    {
        try {
            pst=con.prepareStatement("select mobile from customer_account where email=?");
            pst.setString(1, gmail_ad);
            rs=pst.executeQuery();
            while (rs.next())
            {
                mobile=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(account_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        getotp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        del_acc = new javax.swing.JButton();
        otp = new javax.swing.JTextField();
        label_pass = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        label_otp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timer = new javax.swing.JTextField();
        resendotp = new javax.swing.JButton();
        verify = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        getotp.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getotp.setText("Get OTP");
        getotp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                getotpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                getotpMouseExited(evt);
            }
        });
        getotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getotpActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        del_acc.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        del_acc.setText("Delete Account");
        del_acc.setEnabled(false);
        del_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_accActionPerformed(evt);
            }
        });

        otp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        otp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        otp.setEnabled(false);
        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
        });

        label_pass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setEnabled(false);
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });

        label_otp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Timer");

        timer.setEditable(false);
        timer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        resendotp.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        resendotp.setText("Resend OTP");
        resendotp.setEnabled(false);
        resendotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendotpActionPerformed(evt);
            }
        });

        verify.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(267, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(del_acc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_otp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(otp)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resendotp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(getotp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getotp)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_otp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(otp, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resendotp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(label_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(del_acc))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getotpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getotpMouseEntered
        // TODO add your handling code here:
        getotp.setForeground(Color.BLUE);
    }//GEN-LAST:event_getotpMouseEntered

    private void getotpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getotpMouseExited
        // TODO add your handling code here:
        getotp.setForeground(Color.BLACK);
    }//GEN-LAST:event_getotpMouseExited

    private void getotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getotpActionPerformed
        // TODO add your handling code here:
        label_otp.setText("write down the OTP code within 1 minute");
        otp.setEnabled(true);
        send_otp();
    }//GEN-LAST:event_getotpActionPerformed

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        // TODO add your handling code here:
        String x=otp.getText();
        if(x.equals(code))
        {
            t.cancel();
            verify.setText("Verified");
            otp.setEditable(false);
            label_pass.setText("Your Password");
            pass.setEnabled(true);
        }
        else
        {
           verify.setText("OTP Not Matched!");
           label_pass.setText("");
           pass.setEnabled(false);
        }
    }//GEN-LAST:event_otpKeyReleased

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        // TODO add your handling code here:
        String p=pass.getText();
        if(p.equals(password))
        {
            del_acc.setEnabled(true);
        }
        else
        {
            del_acc.setEnabled(false);
        }
    }//GEN-LAST:event_passKeyReleased

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dashboard db=new dashboard();
        db.set_intro(username_ad, gmail_ad);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void del_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_accActionPerformed
        try {
            // TODO add your handling code here:
            
            pst=con.prepareStatement("delete from customer_account where email=?");
            pst.setString(1,gmail_ad);
            pst.executeUpdate();
            
            pst1=con.prepareStatement("delete from account_comments where email=?");
            pst1.setString(1,gmail_ad);
            pst1.executeUpdate();
            
            pst2=con.prepareStatement("insert into deleted_accounts(user,email,mobile)values(?,?,?)");
            pst2.setString(1,username_ad);
            pst2.setString(2,gmail_ad);
            pst2.setString(3,mobile);
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Account Successfully Deleted");
            
            Bus_Reservation br=new Bus_Reservation();
            br.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(account_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_del_accActionPerformed

    private void resendotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendotpActionPerformed
        // TODO add your handling code here:
        t.cancel();
        send_otp();
        otp.setEditable(true);
        resendotp.setEnabled(false);
    }//GEN-LAST:event_resendotpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(account_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(account_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(account_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(account_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new account_deletion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton del_acc;
    private javax.swing.JButton getotp;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_otp;
    private javax.swing.JLabel label_pass;
    private javax.swing.JTextField otp;
    private javax.swing.JTextField pass;
    private javax.swing.JButton resendotp;
    private javax.swing.JTextField timer;
    private javax.swing.JLabel verify;
    // End of variables declaration//GEN-END:variables
}
