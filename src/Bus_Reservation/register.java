/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class register extends javax.swing.JFrame {

    String BD;
    
    public register() {
        initComponents();
        connect();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
     public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Seat_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Seat_Reservation.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        f_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        l_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        next1 = new javax.swing.JButton();
        profession = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bd = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        phn = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setText("REGISTRATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("First Name");

        f_name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        f_name.setForeground(new java.awt.Color(51, 51, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Last Name");

        l_name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        l_name.setForeground(new java.awt.Color(51, 51, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Birth Date");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("NID No");

        nid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nid.setForeground(new java.awt.Color(51, 51, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Address ");

        location.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        location.setForeground(new java.awt.Color(51, 51, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Gender");

        gender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("E-mail");

        next.setBackground(java.awt.Color.gray);
        next.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        next.setText("NEXT");
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(51, 51, 255));
        jCheckBox1.setText("I agree to your terms and conditions");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        next1.setBackground(new java.awt.Color(255, 255, 255));
        next1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        next1.setText("CANCEL");
        next1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                next1MouseExited(evt);
            }
        });
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });

        profession.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        profession.setForeground(new java.awt.Color(51, 51, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Profession");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Phone");

        phn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        phn.setForeground(new java.awt.Color(51, 51, 255));

        email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_name)
                                    .addComponent(l_name)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox1)
                                        .addGap(78, 78, 78))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(email))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(location, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nid, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bd, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(next1)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(55, 55, 55)
                        .addComponent(phn)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nid, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\t  Terms and Conditions\n\nOffers and Discounts:\n* No two offers that are live can be combined to be \nredeemed.\n* Any offer published by bus ticket reservation or \nits partners can be changed without prior notice.\n* Each offer can have its own terms and conditions. \nPlease refer to the offers page.\n* Offers and Discounts are not applicable on ticket \nbookings made in State Run Transport Corporations \nlike UPSRTC,etc.\n* By acknowledging, I accept to receive promotional \nSMS, calls and emails from bus ticket.com\n\nCancellation Terms:\n* Operators may change their cancellation policy \nat any time.\n* Service tax amount,Operator Service Charge \namount and eTravelSmart Service Charge amount \nwont be refunded back to the customers.\n* Please read the cancellation terms provided \nwhile booking the ticket against each travel operator.\n* If the customer cancels the bus booking, \nbus ticket authority will refund the purchase price \nafter \ndeducting the discount amount, and any other \napplicable bank and cancellation charges / penalty.\n* Refunds processed for cancelled tickets will be \ntransferred to the passenger's bank account, \ndebit / credit card.\n* Any refunds can happen within 3 to 7 working days.\n* Please note that the cancellation fee and \ncancellation period may differ from one bus operator\n to another.\n* No refund will be processed for \nNo-Show Passengers (Passenger who do not report at \nthe boarding point on time).\n\n\nFailed Transaction:\n* A transaction might fail for several reasons and \nyour account/card might be debited without generating a \nticket.\n* If the amount is deducted from your account/card, \nwe request you to call our customer care number \n(+91 86888 34567) or \nmail to customersupportbus_ticket.com to \nre-confirm the failed transaction before \nproceeding with a fresh transaction/booking.\n* Transactions such as these are refunded back to \ncustomer. Please read the Cancellation and refund \npolicy.\n\nPartial Payment:\ncustomers who opt for this option are required to pay\n up the balance 80% share with in the suggested \nexpiry timelines, failing which there will be ZERO \nrefund. The same case applies even incase of \ncancellations before the expiry timeline.\n\nTravel Recharge:\n* Minimum amount to recharge through web application \nis Rs.300.\n* Minimum amount to recharge through mobile app is \nRs.600.\n* Bank transaction charges will be deducted along \nwith the recharge amount.\n* Travel Recharge amount can not be transferred back \nto their respective bank account.\nDiscounts may vary from operator to operator as the \ncommission %ages are dynamic and you are requested \nto refer to Operators List for knowing the average \ndiscounts you get wrt each operator.\nNOTE:\n1.No Promotional Coupon's will be applicable.\n2. Transaction fee of 2% will be collected towards \npayment gateway charges.\n\nReward Points:\nReward points will be reversed in case of Ticket \ncancellations by customers/ service cancellations \nby the operators.\nAll the reward points will be reset to 0 on 31st \nMarch every year,if not redeemed.\n\nInsurance:\n* The Group Travel Insurance - Domestic Policy is \nvalid only for the customers of eTravelSmart.com \nwho book bus tickets through them\n* The Group Travel Insurance - Domestic Policy \n(the \"Policy\") has been underwritten by ICICI \nLombard General Insurance Company Limited \n(the \"Insurer\").\n* Each party shall be liable and responsible only \ntowards the services rendered by it.\n* Money will not be refunded if ticket cancelled or \nservice cancelled.\n\nThanks for your patience. Good Day!");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        
        if(jCheckBox1.isSelected())
        {
            next.setBackground(Color.WHITE);
        }
        else
        {
            next.setBackground(Color.GRAY);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
           setPassword sp=new setPassword();
           String name1=f_name.getText();
           sp.fname=name1;
           String name2=l_name.getText();
           sp.lname=name2;
           String N=name1+" "+name2;
           sp.Name=N;
           
           String W=profession.getText();
           sp.Work=W;
           
           SimpleDateFormat dff=new SimpleDateFormat("yyyy-MM-dd");
           String Bd=dff.format(bd.getDate());
           sp.Birth_date=Bd;
           
           String Ni=nid.getText();
           sp.Nid=Ni;
           
           String add=location.getText();
           sp.Address=add;
           
           String Email=email.getText();
           sp.Mail=Email;
           
           String G=gender.getSelectedItem().toString();
           sp.Gender=G;
           
           String phone=phn.getText();
           sp.Mobile=phone;
           
           if(phone.length()==11)
           {
               try {
                    pst=con.prepareStatement("select email from customer_account");
                    rs=pst.executeQuery();
                    int count=0;
                    while(rs.next())
                    {
                        String mail_value=rs.getString(1);
                        if(mail_value.equals(Email))
                        {
                            JOptionPane.showMessageDialog(this,"This Email is currently in used");
                            count++;
                            break;
                        }
                    }
                    if(count==0)
                    {
                       sp.send_otp();
                       sp.setVisible(true);
                       this.setVisible(false);
                    }    
                } catch (SQLException ex) {
                    Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                }
               
           }
           else
           {
               JOptionPane.showMessageDialog(this,"Check you mobile number");
           }
           
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"You must be agreed to our terms and conditions");
        }
        
    }//GEN-LAST:event_nextActionPerformed

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
        // TODO add your handling code here:
        Bus_Reservation brr=new Bus_Reservation();
        brr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_next1ActionPerformed

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        // TODO add your handling code here:
        next.setForeground(Color.BLUE);
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        // TODO add your handling code here:
        next.setForeground(Color.BLACK);
    }//GEN-LAST:event_nextMouseExited

    private void next1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseEntered
        // TODO add your handling code here:
         next1.setForeground(Color.BLUE);
    }//GEN-LAST:event_next1MouseEntered

    private void next1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseExited
        // TODO add your handling code here:
        next1.setForeground(Color.BLACK);
    }//GEN-LAST:event_next1MouseExited

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser bd;
    private javax.swing.JTextField email;
    public javax.swing.JTextField f_name;
    public javax.swing.JComboBox<String> gender;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField l_name;
    public javax.swing.JTextField location;
    private javax.swing.JButton next;
    private javax.swing.JButton next1;
    public javax.swing.JTextField nid;
    public javax.swing.JTextField phn;
    public javax.swing.JTextField profession;
    // End of variables declaration//GEN-END:variables
}
