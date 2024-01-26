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
public class change_password extends javax.swing.JFrame {

    /**
     * Creates new form change_password
     */
    public change_password() {
        initComponents();
        connect();
    }
    String username_cp;
    String gmail_cp;
    String my_password;
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(change_password.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(change_password.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void password()
    {
        try {
            pst=con.prepareStatement("select password from customer_account where email=?");
            pst.setString(1,gmail_cp);
            rs=pst.executeQuery();
            while(rs.next())
            {
                my_password=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(change_password.class.getName()).log(Level.SEVERE, null, ex);
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
           message.setContent("Hello "+username_cp+"."+msg, "text/plain");  
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(gmail_cp));  

           transport.connect();  
           Transport.send(message); 
           
           transport.close();
           timer();
           JOptionPane.showMessageDialog(this, "Message sent");
           
           
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Check Wi-Fi or Invalid Address! Go back & Check your Email");
            ex.printStackTrace();}  
 }
    
    int count1;
    int timeup;
    
    public void timer()
    {
        count1=0;
        timeup=0;
        
        t=new Timer();
        task=new TimerTask()
        {
            @Override
            public void run() {
                count1++;
                if(count1<61)
                {
                   timer.setText(Integer.toString(count1)); 
                }
                else
                {
                    timeup=1;
                    t.cancel();
                    resendotp.setEnabled(true);
                    otp.setEditable(false);
                    otp.setText("");
                    change_password cp=new change_password();
                    JOptionPane.showMessageDialog(cp,"Time UP! Press Re-Send to get another code");

                }

            }
        }; 
        t.scheduleAtFixedRate(task,0,1000);   
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
        curr_pass = new javax.swing.JTextField();
        new_pass = new javax.swing.JTextField();
        renew_pass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        timer = new javax.swing.JTextField();
        verify = new javax.swing.JLabel();
        resendotp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        curr_pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        curr_pass.setEnabled(false);
        curr_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                curr_passKeyReleased(evt);
            }
        });

        new_pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_pass.setEnabled(false);

        renew_pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        renew_pass.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("New Password");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Write Down the OTP code");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Retype New Password");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Password should contain 8 digits long with uppercase,lowercase and special characters");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Set Password");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jCheckBox1.setText("Stay Logged In?");
        jCheckBox1.setEnabled(false);

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

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Current Password");

        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Timer");

        timer.setEditable(false);
        timer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        verify.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(51, 51, 255));
        verify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        resendotp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resendotp.setText("Re-Send");
        resendotp.setEnabled(false);
        resendotp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resendotpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resendotpMouseExited(evt);
            }
        });
        resendotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendotpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(curr_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                                .addComponent(new_pass)
                                .addComponent(renew_pass))
                            .addComponent(jCheckBox1)
                            .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(resendotp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resendotp))
                .addGap(4, 4, 4)
                .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(curr_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renew_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
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

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
       
        jButton1.setForeground(Color.blue);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setForeground(Color.black);
    }//GEN-LAST:event_jButton1MouseExited

    private void curr_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_curr_passKeyReleased
        // TODO add your handling code here:
        String cur=curr_pass.getText();
        
        if(cur.equals(my_password))
        {
            new_pass.setEnabled(true);
            renew_pass.setEnabled(true);
            jLabel1.setForeground(Color.blue);
            jLabel3.setForeground(Color.blue);
            jLabel4.setForeground(Color.blue);
            jCheckBox1.setEnabled(true);
            jCheckBox1.setForeground(Color.blue);
        }
        
    }//GEN-LAST:event_curr_passKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String newpass=new_pass.getText();
        String renewpass=renew_pass.getText();
        if(newpass.equals(renewpass))
        {
            int digit=0;
            int uppercase=0;
            int lowercase=0;
            int special_char=0;
            int letter=0;
            if(newpass.length()>=8)
            {
                letter=1;
                //checking for special character
                for(int i=0;i<newpass.length();i++)
                {
                    if(newpass.charAt(i)== '#' || newpass.charAt(i)== '$' || newpass.charAt(i)== '@'|| newpass.charAt(i)== '%')
                    {
                        special_char=1;
                        break;
                    }
                }
                //checking for uppercase
                for(int j=0;j<newpass.length();j++)
                {
                    for(int i='A';i<='Z';i++)
                    {
                        if(newpass.charAt(j)==i)
                        {
                            uppercase=1;
                            break;
                        }
                    }
                    if(uppercase==1)
                    {
                        break;
                    }

                }
                //checking for lowercase
                for(int j=0;j<newpass.length();j++)
                { 
                    for(int i='a';i<='z';i++)
                    {
                        if(newpass.charAt(j)== i)
                        {
                            lowercase=1;
                            break;
                        }
                    }
                    if(lowercase==1)
                    {
                        break;
                    }
                }
                //chceking for digits
                for(int j=0;j<newpass.length();j++)
                { 
                    for(int i='0';i<='9';i++)
                    {
                        if(newpass.charAt(j)== i)
                        {
                            digit=1;
                            break;
                        }
                    }
                    if(digit==1)
                    {
                        break;
                    }
                }
                
                if(letter==1 && special_char==1 && uppercase==1 && lowercase==1 && digit==1)
                {
                    try {
                        pst=con.prepareStatement("update customer_account set password=? where email=?");
                        pst.setString(1,newpass);
                        pst.setString(2,gmail_cp);
                        pst.executeUpdate();
                        
                        pst1=con.prepareStatement("update account_comments set comments=? where email=?");
                        pst1.setString(1,"Password Changed");
                        pst1.setString(2,gmail_cp);
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(this,"Password Updated");
                        exit();
                    } catch (SQLException ex) {
                        Logger.getLogger(change_password.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                  JOptionPane.showMessageDialog(this,"Password donot fills the required conditions");  
                }
              }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"New Password does not match with the retyped password");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        t.cancel();
        dashboard db=new dashboard();
        db.set_intro(username_cp,gmail_cp);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        // TODO add your handling code here:
        String x=otp.getText();
        if(x.equals(code))
        {
            t.cancel();
            verify.setText("Verified");
            otp.setEditable(false);
            curr_pass.setEnabled(true);   
        }
        else
        {
            verify.setText("OTP not matched");
        }
    }//GEN-LAST:event_otpKeyReleased

    private void resendotpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendotpMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_resendotpMouseEntered

    private void resendotpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendotpMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_resendotpMouseExited

    private void resendotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendotpActionPerformed
        // TODO add your handling code here:
        send_otp();
        otp.setText("");
        resendotp.setEnabled(false);
    }//GEN-LAST:event_resendotpActionPerformed

    public void exit()
    {
        if(jCheckBox1.isSelected())
        {
            dashboard db=new dashboard();
            db.set_intro(username_cp,gmail_cp);
            db.setVisible(true);
            this.setVisible(false);
        }
        else
        {
            Bus_Reservation b=new Bus_Reservation();
            b.setVisible(true);
            this.setVisible(false);
        }
    }
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
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new change_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField curr_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField new_pass;
    private javax.swing.JTextField otp;
    private javax.swing.JTextField renew_pass;
    private javax.swing.JButton resendotp;
    private javax.swing.JTextField timer;
    private javax.swing.JLabel verify;
    // End of variables declaration//GEN-END:variables
}
