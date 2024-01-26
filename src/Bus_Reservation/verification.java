/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class verification extends javax.swing.JFrame {

    /**
     * Creates new form verification
     */
    public verification() {
        initComponents();
        connect();
    }
    String username_ver;
    String gmail_ver;
    String code;
    
    String f;
    String n;
    String username;
    String prof;
    String bd;
    String Nid;
    String Gender;
    String location;
    String to;
    String mobile_ver;
    
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    
   
    TimerTask task;
    Timer t;
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(verification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(verification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int randomCode;
    
    
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
           message.setContent("Hello "+username_ver+"."+msg, "text/plain");  
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

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
                    resend.setEnabled(true);
                    jTextField1.setEditable(false);
                    jTextField1.setText("");
                    verification ver=new verification();
                    JOptionPane.showMessageDialog(ver,"Time UP! Press Re-Send to get another code");

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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        timer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        resend = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        goback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Give The Verification Code Below");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        timer.setEditable(false);
        timer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Timer:");

        resend.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        resend.setText("Re-Send");
        resend.setEnabled(false);
        resend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resendMouseExited(evt);
            }
        });
        resend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        save.setText("Save");
        save.setEnabled(false);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        goback.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        goback.setText("Go Back");
        goback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gobackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gobackMouseExited(evt);
            }
        });
        goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(goback)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resend)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 130, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resend, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goback, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        // TODO add your handling code here:
        save.setForeground(Color.BLUE);
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        // TODO add your handling code here:
        save.setForeground(Color.BLACK);
    }//GEN-LAST:event_saveMouseExited

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         String verify=jTextField1.getText();
         if(verify.equals(code))
         {
             t.cancel();
             jLabel3.setText("Verified");
             jTextField1.setEditable(false);
             save.setEnabled(true);
         }
         else
         {
             jLabel3.setText("OTP Not Matched");
         }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
         
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setForeground(Color.black);
    }//GEN-LAST:event_jLabel1MouseExited

    private void gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackActionPerformed

        t.cancel();        // TODO add your handling code here:
        edit_info ei=new edit_info();
        ei.username_ei=username_ver;
        ei.gmail_ei=gmail_ver;
        ei.infos();
        ei.setVisible(true);
        this.setVisible(false);
                
    }//GEN-LAST:event_gobackActionPerformed

    private void resendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendActionPerformed
        // TODO add your handling code here:
        
        jTextField1.setEditable(true);
        send_otp();   
        resend.setEnabled(false);
    }//GEN-LAST:event_resendActionPerformed

    private void resendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendMouseEntered
        // TODO add your handling code here:
        resend.setForeground(Color.BLUE);
    }//GEN-LAST:event_resendMouseEntered

    private void resendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendMouseExited
        // TODO add your handling code here:
        resend.setForeground(Color.BLACK);
    }//GEN-LAST:event_resendMouseExited

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        
        
        
        try {
            // TODO add your handling code here:
            String username=f+" "+n;
            pst=con.prepareStatement("update customer_account set fname=?,lname=?,user=?,profession=?,birth_date=?,nid=?,gender=?,email=?,mobile=?,location=? where email=?");
            pst.setString(1,f);
            pst.setString(2,n);
            pst.setString(3,username);
            pst.setString(4,prof);
            pst.setString(5,bd);
            pst.setString(6,Nid);
            pst.setString(7,Gender);
            pst.setString(8,to);
            pst.setString(9,mobile_ver);
            pst.setString(10,location);
            pst.setString(11,gmail_ver);
            pst.executeUpdate();
            
            //updating account_comments table
            pst1=con.prepareStatement("update account_comments set user=?,email=?,comments=? where email=? ");
            pst1.setString(1,username);
            pst1.setString(2, to);
            pst1.setString(3,"Your Account informations has been successfully updated!");
            pst1.setString(4,gmail_ver);
            pst1.executeUpdate();
            
            //updating busbook table
            pst2=con.prepareStatement("update busbook set customer=?,email=?,mobile=? where email=? ");
            pst2.setString(1,username);
            pst2.setString(2, to);
            pst2.setString(3,mobile_ver);
            pst2.setString(4,gmail_ver);
            pst2.executeUpdate();
            
            //updating receipt table
            pst3=con.prepareStatement("update my_receipt set email=?,mobile=? where email=? ");
            
            pst3.setString(1, to);
            pst3.setString(2,mobile_ver);
            pst3.setString(3,gmail_ver);
            
            pst3.executeUpdate();
            
            //updating ticket_cancel
            pst4=con.prepareStatement("update ticket_cancel set user=?,email=?,mobile=? where email=? ");
            pst4.setString(1,username);
            pst4.setString(2, to);
            pst4.setString(3,mobile_ver);
            pst4.setString(4,gmail_ver);
            pst4.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Information Updated");
            exit();   
        } catch (SQLException ex) {
            Logger.getLogger(verification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_saveActionPerformed

    private void gobackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gobackMouseEntered
        // TODO add your handling code here:
        goback.setForeground(Color.BLUE);
    }//GEN-LAST:event_gobackMouseEntered

    private void gobackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gobackMouseExited
        // TODO add your handling code here:
        goback.setForeground(Color.BLACK);
    }//GEN-LAST:event_gobackMouseExited

    public void exit()
    {
        t.cancel();
        username_ver=f+" "+n;
        gmail_ver=to;
        dashboard db=new dashboard();
        db.set_intro(username_ver, gmail_ver);
        db.setVisible(true);
        this.setVisible(false);         
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
            java.util.logging.Logger.getLogger(verification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton resend;
    private javax.swing.JButton save;
    private javax.swing.JTextField timer;
    // End of variables declaration//GEN-END:variables
}
