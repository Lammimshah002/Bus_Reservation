/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

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
public class forget_pass extends javax.swing.JFrame {

    /**
     * Creates new form forget_pass
     */
    public forget_pass() {
        initComponents();
        connect();
    }
    int button_check=0;
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
            Logger.getLogger(forget_pass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(forget_pass.class.getName()).log(Level.SEVERE, null, ex);
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
            
            String Mail=email.getText();

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
           message.setContent("Hey there, "+msg, "text/plain");  
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(Mail));  

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
                    get_otp.setEnabled(true);
                    otp.setEditable(false);
                    otp.setText("");
                    forget_pass fp=new forget_pass();
                    JOptionPane.showMessageDialog(fp,"Time UP! Press Re-Send to get another code");

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
        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        get_otp = new javax.swing.JButton();
        otp = new javax.swing.JTextField();
        verify = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timer = new javax.swing.JTextField();
        label_pass_contains = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        label_pass1 = new javax.swing.JLabel();
        save_pass = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        email.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Enter Your E-Mail Here");

        get_otp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        get_otp.setText("Get OTP");
        get_otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_otpActionPerformed(evt);
            }
        });

        otp.setEditable(false);
        otp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        otp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
        });

        verify.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(51, 51, 255));
        verify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Timer");

        timer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        label_pass_contains.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_pass_contains.setForeground(new java.awt.Color(51, 51, 255));

        pass.setEditable(false);
        pass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });

        label_pass1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_pass1.setForeground(new java.awt.Color(51, 51, 255));

        save_pass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        save_pass.setText("Save Password");
        save_pass.setEnabled(false);
        save_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_passActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(get_otp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(otp, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(label_pass_contains, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_pass1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_pass)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(get_otp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(label_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_pass_contains, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
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

    private void get_otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_otpActionPerformed
        button_check++;
        String mail=email.getText();
        if(button_check<2)
        {
            try {
                int count=0;
                // TODO add your handling code here:
                pst=con.prepareStatement("select email from customer_account where email =?");
                pst.setString(1,email.getText());
                rs=pst.executeQuery();
                while(rs.next())
                {
                  count++;  
                }
                if(count==0)
                {
                    JOptionPane.showMessageDialog(this,"Email does not belong to our database");
                    Bus_Reservation br=new Bus_Reservation();
                    br.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    send_otp();
                    get_otp.setEnabled(false);
                    otp.setEditable(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(forget_pass.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            t.cancel();
            send_otp();
            get_otp.setEnabled(false);
            otp.setEditable(true);
        }
        
    }//GEN-LAST:event_get_otpActionPerformed

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        // TODO add your handling code here:
        String x=otp.getText();
        if(x.equals(code))
        {
            t.cancel();
            otp.setEditable(false);
            verify.setText("Verified");
            email.setEditable(false);
            label_pass1.setText("Set Password");
            pass.setEditable(true);
            label_pass_contains.setText("Password must contain 8 digits long with numbers, special characters, uppercase & lowercase letters");
            
        }
        else
        {
            verify.setText("OTP Not Matched");
        }
        
    }//GEN-LAST:event_otpKeyReleased

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        // TODO add your handling code here:
        String newpass=pass.getText();
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
                save_pass.setEnabled(true);
            }
            else
            {
                save_pass.setEnabled(false);
            }
        }
        else
        {
            save_pass.setEnabled(false);
        }
        
    }//GEN-LAST:event_passKeyReleased

    private void save_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_passActionPerformed
        // TODO add your handling code here:
        String newpass=pass.getText();
        String mail=email.getText();
        try {
            pst=con.prepareStatement("update customer_account set password=? where email=?");
            pst.setString(1,newpass);
            pst.setString(2,mail);
            pst.executeUpdate();

            pst1=con.prepareStatement("update account_comments set comments=? where email=?");
            pst1.setString(1,"Password Changed");
            pst1.setString(2,mail);
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(this,"Password Updated");
            
            
            Bus_Reservation br=new Bus_Reservation();
            br.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(change_password.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_passActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

                   // TODO add your handling code here:
            Bus_Reservation br=new Bus_Reservation();
            br.setVisible(true);
            this.setVisible(false);
        
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(forget_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forget_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forget_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forget_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forget_pass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField email;
    private javax.swing.JButton get_otp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_pass1;
    private javax.swing.JLabel label_pass_contains;
    private javax.swing.JTextField otp;
    private javax.swing.JTextField pass;
    private javax.swing.JButton save_pass;
    private javax.swing.JTextField timer;
    private javax.swing.JLabel verify;
    // End of variables declaration//GEN-END:variables
}
