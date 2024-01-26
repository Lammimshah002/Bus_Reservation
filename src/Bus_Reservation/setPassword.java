/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class setPassword extends javax.swing.JFrame {

    /**
     * Creates new form setPassword
     */
    public setPassword() {
        initComponents();
        connect();
    }
    String Name;
    String fname;
    String lname;
    String Work;
    String Birth_date;
    String Nid;
    String Gender;
    String Mail;
    String Address;
    String Mobile;
    int count;
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(setPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(setPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert_database()
    {
            
        try {
            String pass=setpass1.getText();
            pst=con.prepareStatement("insert into customer_account(fname,lname,user,profession,birth_date,nid,gender,email,mobile,password,location)values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,fname);
            pst.setString(2,lname);
            pst.setString(3,Name);
            pst.setString(4,Work);
            pst.setString(5,Birth_date);
            pst.setString(6,Nid);
            pst.setString(7,Gender);
            pst.setString(8,Mail);
            pst.setString(9,Mobile);
            pst.setString(10,pass);
            pst.setString(11,Address);
            pst.executeUpdate();
            
            pst2=con.prepareStatement("insert into account_comments(user,email,comments)values(?,?,?)");
            pst2.setString(1, Name);
            pst2.setString(2,Mail);
            pst2.setString(3,"No Incoming Messages");
            pst2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(setPassword.class.getName()).log(Level.SEVERE, null, ex);
        }  
        JOptionPane.showMessageDialog(this,"Account Creation Successfull.");
        
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
           message.setContent("Hello "+Name+"."+msg, "text/plain");  
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
                    resendotp.setEnabled(true);
                    otp.setEditable(false);
                    otp.setText("");
                    setPassword sp=new setPassword();
                    JOptionPane.showMessageDialog(sp,"Time UP! Press Re-Send to get another code");

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
        resendotp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        setpass1 = new javax.swing.JTextField();
        setpass2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Finish = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        pass_confirmation = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timer = new javax.swing.JTextField();
        verify = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Check your mail and submit OTP");

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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Set Password");

        setpass1.setEditable(false);
        setpass1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        setpass1.setEnabled(false);
        setpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setpass1ActionPerformed(evt);
            }
        });
        setpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setpass1KeyReleased(evt);
            }
        });

        setpass2.setEditable(false);
        setpass2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        setpass2.setEnabled(false);
        setpass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setpass2MouseClicked(evt);
            }
        });
        setpass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setpass2KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Retype Password");

        Finish.setBackground(new java.awt.Color(255, 255, 255));
        Finish.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Finish.setText("Finish");
        Finish.setEnabled(false);
        Finish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FinishMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FinishMouseExited(evt);
            }
        });
        Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jCheckBox1.setText("8 Digits Long");
        jCheckBox1.setEnabled(false);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jCheckBox2.setText("Must Contain Special Characters such as $, @, #, %");
        jCheckBox2.setEnabled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jCheckBox3.setText("Must Contain digits, Uppercase and Lowercase Letters");
        jCheckBox3.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel4.setText("Password must contain these following rules:");

        pass_confirmation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass_confirmation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pass_confirmation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Timer");

        timer.setEditable(false);
        timer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        verify.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(51, 51, 255));

        otp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(setpass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(pass_confirmation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resendotp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(Finish, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(resendotp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(setpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(setpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pass_confirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(Finish)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void resendotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendotpActionPerformed
        // TODO add your handling code here:
        
        send_otp();
        otp.setEditable(true);
        resendotp.setEnabled(false);
    }//GEN-LAST:event_resendotpActionPerformed

    private void FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishActionPerformed
        
            insert_database();
            dashboard db=new dashboard();
            db.setVisible(true);
            this.setVisible(false);
            db.username.setText(Name);
            db.email.setText(Mail);
            db.comment.setText("No Incoming Messages!");  
    }//GEN-LAST:event_FinishActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        // TODO add your handling code here:
        register r=new register();
        r.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void setpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setpass1ActionPerformed
        // TODO add your handling code here:
              
    }//GEN-LAST:event_setpass1ActionPerformed

    private void setpass1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setpass1KeyReleased
        // TODO add your handling code here:
        int letter=0;
        int digit=0;
        int special_char=0;
        int uppercase=0;
        int lowercase=0;
        Finish.setEnabled(false);
        String pass=setpass1.getText();
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        setpass2.setEditable(false);
        setpass2.setText("");
        pass_confirmation.setText("");
        
        
        if(pass.length()>=8)
        {
            jCheckBox1.setSelected(true);
            letter=1;
            //checking for special character
            for(int i=0;i<pass.length();i++)
            {
                if(pass.charAt(i)== '#' || pass.charAt(i)== '$' || pass.charAt(i)== '@'|| pass.charAt(i)== '%')
                {
                    jCheckBox2.setSelected(true);
                    special_char=1;
                    break;
                }
            }
            //checking for uppercase
            for(int j=0;j<pass.length();j++)
            {
                for(int i='A';i<='Z';i++)
                {
                    if(pass.charAt(j)==i)
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
            for(int j=0;j<pass.length();j++)
            { 
                for(int i='a';i<='z';i++)
                {
                    if(pass.charAt(j)== i)
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
            for(int j=0;j<pass.length();j++)
            { 
                for(int i='0';i<='9';i++)
                {
                    if(pass.charAt(j)== i)
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
            if(uppercase==1 && lowercase==1 && digit==1)
            {
                jCheckBox3.setSelected(true);  
            }
            if(letter==1 && special_char==1 && uppercase==1 && lowercase==1 && digit==1)
            {
                setpass2.setEnabled(true);
                setpass2.setEditable(true);     
            }
          }
    }//GEN-LAST:event_setpass1KeyReleased

    private void setpass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setpass2KeyReleased
        // TODO add your handling code here:
        String sp1=setpass1.getText();
        String sp2=setpass2.getText();
        if(sp1.equals(sp2))
        {
            pass_confirmation.setText("Password Confirmed");
            Finish.setEnabled(true);
        }
        else
        {
            pass_confirmation.setText("Password Not Confirmed");
            Finish.setEnabled(false);
        }
    }//GEN-LAST:event_setpass2KeyReleased

    private void setpass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setpass2MouseClicked
        // TODO add your handling code here:
        String sp1=setpass1.getText();
        String sp2=setpass2.getText();
        if(sp1.isEmpty() || sp2.isEmpty())
        {
            Finish.setEnabled(false);
        }
        else
        {
            if(sp1.equals(sp2))
            {
                pass_confirmation.setText("Password Confirmed");
                Finish.setEnabled(true);
            }
            else
            {
                pass_confirmation.setText("Password Not Confirmed");
                Finish.setEnabled(false);
            }
            
        }
        
    }//GEN-LAST:event_setpass2MouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        // TODO add your handling code here:
        Back.setForeground(Color.BLUE);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        // TODO add your handling code here:
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseExited

    private void FinishMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinishMouseEntered
        // TODO add your handling code here:
        Finish.setForeground(Color.BLUE);
    }//GEN-LAST:event_FinishMouseEntered

    private void FinishMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinishMouseExited
        // TODO add your handling code here:
        Finish.setForeground(Color.BLACK);
    }//GEN-LAST:event_FinishMouseExited

    private void resendotpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendotpMouseEntered
        // TODO add your handling code here:
        resendotp.setForeground(Color.BLUE);
    }//GEN-LAST:event_resendotpMouseEntered

    private void resendotpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendotpMouseExited
        // TODO add your handling code here:
        resendotp.setForeground(Color.BLACK);
    }//GEN-LAST:event_resendotpMouseExited

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        // TODO add your handling code here:
        String x=otp.getText();
        if(x.equals(code))
        {
            t.cancel();
            verify.setText("Verified");
            otp.setEditable(false);
            setpass1.setEditable(true);
            setpass1.setEnabled(true);
        }
        else
        {
            verify.setText("OTP Not Matched");
        }
    }//GEN-LAST:event_otpKeyReleased

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
            java.util.logging.Logger.getLogger(setPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    public javax.swing.JButton Finish;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField otp;
    private javax.swing.JLabel pass_confirmation;
    private javax.swing.JButton resendotp;
    private javax.swing.JTextField setpass1;
    private javax.swing.JTextField setpass2;
    private javax.swing.JTextField timer;
    private javax.swing.JLabel verify;
    // End of variables declaration//GEN-END:variables
}
