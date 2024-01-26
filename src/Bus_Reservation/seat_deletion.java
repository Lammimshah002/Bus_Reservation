/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author User
 */
public class seat_deletion extends javax.swing.JFrame {

    /**
     * Creates new form seat_deletion
     */
    public seat_deletion() {
        initComponents();
        connect();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ResultSet rs4;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    PreparedStatement pst5;
    
    ResultSet rs2;
    
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //update the bus_schedule 
    public void update_schedule()
    {
        try{
            int st=0;
            DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
            int selected=jTable1.getSelectedRow();
            String bus_route=table.getValueAt(selected,1).toString();
            String user_date=table.getValueAt(selected,6).toString();
            String time=table.getValueAt(selected,7).toString();
            
            pst2=con.prepareStatement("select seats_available from bus_schedule where busno=? and date=? and time=?");
            pst2.setString(1,bus_route); 
            pst2.setString(2,user_date);
            pst2.setString(3,time);
            rs2=pst2.executeQuery();
            while(rs2.next())
            {
                st=rs2.getInt(1);
            }
            st=st+1;
            pst3=con.prepareStatement("update bus_schedule set seats_available=? where busno=? and date=? and time=?");
            pst3.setInt(1,st);
            pst3.setString(2,bus_route); 
            pst3.setString(3,user_date);
            pst3.setString(4,time);
            pst3.executeUpdate();
               
        }catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void requestload()
    {
        try {
            int count=0;
            JTableHeader table=jTable2.getTableHeader();
            JTableHeader table2=jTable1.getTableHeader();
            Font header=new Font("Times New Roman",Font.PLAIN,18);
            table.setFont(header);
            table2.setFont(header);
            
            pst=con.prepareStatement("select user,email,busno,seat,date,time,mobile,operator,card_number from ticket_cancel");
            rs=pst.executeQuery();
            
            DefaultTableModel tab=(DefaultTableModel)jTable2.getModel();
            tab.setRowCount(0);
            
            while(rs.next())
            {
                count++;
                Vector v=new Vector();
                v.add("Request : "+count);
                v.add(rs.getString("user"));
                v.add(rs.getString("email"));
                v.add(rs.getString("busno"));
                v.add(rs.getString("seat"));
                v.add(rs.getString("date"));
                v.add(rs.getString("time"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("operator"));
                v.add(rs.getString("card_number"));
                tab.addRow(v);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    //load_function for multiple call
    public void load(String email,String bus_route,String user_date,String time)
    {
       try {
           
            pst=con.prepareStatement("SELECT seats.seat,seats.busno,seats.price,seats.status,seats.date,seats.time,busbook.customer,busbook.mobile,busbook.email,busbook.payment_via,busbook.card_number from seats Left JOIN busbook ON seats.busno=busbook.busno AND seats.seat=busbook.seat AND seats.date=busbook.date AND seats.time=busbook.time  where busbook.email=? and busbook.busno=? and busbook.date=? and busbook.time=?");
            pst.setString(1,email);
            pst.setString(2,bus_route); 
            pst.setString(3,user_date);
            pst.setString(4,time);
            rs=pst.executeQuery();
            
           
            DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
            d1.setRowCount(0);
            while(rs.next())
            {
                Vector v2=new Vector();
                
                    v2.add(rs.getString("seat"));
                    v2.add(rs.getString("busno"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("customer"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("time"));
                    v2.add(rs.getString("payment_via"));
                    v2.add(rs.getString("card_number"));
                    v2.add(rs.getString("price")); 
                
                d1.addRow(v2);
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        Details = new javax.swing.JButton();
        decline = new javax.swing.JButton();
        approve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 55)); // NOI18N
        jLabel1.setText("    Deletion of Information");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Seat", "Busno", "Status", "Customer", "Mobile No", "Email", "Date", "Time", "Payment Via", "Card number", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(10);
        }

        delete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cancellation Requests");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customer Details");

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Request_No", "User", "Email", "Busno", "Seat", "Date", "Time", "Mobile", "Operator", "Card Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("Back");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Details.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Details.setText("See Details");
        Details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DetailsMouseExited(evt);
            }
        });
        Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsActionPerformed(evt);
            }
        });

        decline.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        decline.setText("Decline");
        decline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                declineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                declineMouseExited(evt);
            }
        });
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });

        approve.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        approve.setText("Approve");
        approve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                approveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                approveMouseExited(evt);
            }
        });
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                                .addComponent(Details)
                                .addGap(304, 304, 304)
                                .addComponent(decline, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(approve, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Details, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decline, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(approve, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

   //delete_function
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            // TODO add your handling code here:
            DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
            int selected=jTable1.getSelectedRow();
            String seat_delete=table.getValueAt(selected,0).toString();
            String bus_route1=table.getValueAt(selected,1).toString();
            String user_date1=table.getValueAt(selected,6).toString();
            String time1=table.getValueAt(selected,7).toString();
            String email=table.getValueAt(selected, 5).toString();
            
            pst=con.prepareStatement("delete from busbook where seat=? and busno=? and date=? and time=?");
            pst.setString(1,seat_delete);  
            pst.setString(2,bus_route1); 
            pst.setString(3,user_date1);
            pst.setString(4,time1);
            pst.executeUpdate();
            
            pst1=con.prepareStatement("update seats set status=? where seat=? and busno=? and date=? and time=?");
            pst1.setString(1,"Unbooked");
            pst1.setString(2, seat_delete);
            pst1.setString(3,bus_route1); 
            pst1.setString(4,user_date1);
            pst1.setString(5,time1);
            
            pst1.executeUpdate();
            update_schedule();
            load(email,bus_route1,user_date1,time1);
            JOptionPane.showMessageDialog(this,"Seat Successfully Deleted.");
            
                    
            } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Seat_Reservation sr=new Seat_Reservation();
        sr.setVisible(true);
        sr.load();
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailsActionPerformed
        // TODO add your handling code here:
            DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
            int selected=jTable2.getSelectedRow();
           
            String bus_route1=table2.getValueAt(selected,3).toString();
            String user_date1=table2.getValueAt(selected,5).toString();
            String time1=table2.getValueAt(selected,6).toString();
            String email=table2.getValueAt(selected, 2).toString();
            load(email,bus_route1,user_date1,time1); 
    }//GEN-LAST:event_DetailsActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        try {
            // TODO add your handling code here:
            DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
            int selected=jTable2.getSelectedRow();
            
            String email=table2.getValueAt(selected, 2).toString();
            String busno=table2.getValueAt(selected, 3).toString();
            String date=table2.getValueAt(selected, 5).toString();
            String time=table2.getValueAt(selected, 6).toString();
            
            pst=con.prepareStatement("delete from ticket_cancel where email=? and busno=? and date=? and time=?");
            pst.setString(1,email);
            pst.setString(2,busno );
            pst.setString(3, date);
            pst.setString(4, time);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Declined");
            requestload();
            
            pst2=con.prepareStatement("update account_comments set comments=? where email=?");
            pst2.setString(1,"Your cancellation request for "+busno+" Date: "+date+" Time:"+time+" has been declined.");
            pst2.setString(2,email );
            pst2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_declineActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
            int selected=jTable2.getSelectedRow();
            
            String email=table2.getValueAt(selected, 2).toString();
            String busno=table2.getValueAt(selected, 3).toString();
            String date=table2.getValueAt(selected, 5).toString();
            String time=table2.getValueAt(selected, 6).toString();
            String seat=table2.getValueAt(selected, 4).toString();
            
            pst=con.prepareStatement("delete from ticket_cancel where email=? and busno=? and date=? and time=? and seat=?");
            pst.setString(1,email);
            pst.setString(2,busno );
            pst.setString(3, date);
            pst.setString(4, time);
            pst.setString(5,seat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Approved");
            requestload();
            
            pst2=con.prepareStatement("update account_comments set comments=? where email=?");
            pst2.setString(1,"Your cancellation request for "+busno+" Date: "+date+" Time:"+time+" has been approved.");
            pst2.setString(2,email );
            pst2.executeUpdate();
            
            //Updating the seat numbers
            String seatno[]=new String[10];
            String total_seat="S :";
            int count=0;
            pst3=con.prepareStatement("select seat from busbook where email=? and busno=? and date=? and time=?");
            pst3.setString(1,email);
            pst3.setString(2,busno );
            pst3.setString(3, date);
            pst3.setString(4, time);
            rs=pst3.executeQuery();
            while(rs.next())
            {
                count++;
                seatno[count]=Integer.toString(rs.getInt(1));
            }
            if(count==0)
            {
                //removing receipts for no longer seats
                pst5=con.prepareStatement("delete from my_receipt where email=? and busno=? and date=? and time=?");
                
                pst5.setString(1,email);
                pst5.setString(2,busno );
                pst5.setString(3,date);
                pst5.setString(4,time);
                pst5.executeUpdate();
                
            }
            else
            {
                //updating receipts for available seats
                for(int i=1;i<=count;i++)
                {
                    if(i==count)
                    {
                       total_seat=total_seat+" "+seatno[i]; 
                    }
                    else
                    {
                      total_seat=total_seat+" "+seatno[i]+",";  
                    }   
                }

                pst4=con.prepareStatement("update my_receipt set seatno=? where email=? and busno=? and date=? and time=?");
                pst4.setString(1,total_seat);
                pst4.setString(2,email);
                pst4.setString(3,busno );
                pst4.setString(4, date);
                pst4.setString(5, time);
                pst4.executeUpdate();
                
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(seat_deletion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_approveActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton3MouseExited

    private void DetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseEntered
        // TODO add your handling code here:
        Details.setForeground(Color.BLUE);
    }//GEN-LAST:event_DetailsMouseEntered

    private void DetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseExited
        // TODO add your handling code here:
        Details.setForeground(Color.BLACK);
    }//GEN-LAST:event_DetailsMouseExited

    private void declineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_declineMouseEntered
        // TODO add your handling code here:
        decline.setForeground(Color.BLUE);
    }//GEN-LAST:event_declineMouseEntered

    private void approveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveMouseExited
        // TODO add your handling code here:
        approve.setForeground(Color.BLACK);
    }//GEN-LAST:event_approveMouseExited

    private void declineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_declineMouseExited
        // TODO add your handling code here:
        decline.setForeground(Color.BLACK);
    }//GEN-LAST:event_declineMouseExited

    private void approveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveMouseEntered
        // TODO add your handling code here:
        approve.setForeground(Color.BLUE);
    }//GEN-LAST:event_approveMouseEntered

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setForeground(Color.BLUE);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setForeground(Color.BLACK);
    }//GEN-LAST:event_deleteMouseExited

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
            java.util.logging.Logger.getLogger(seat_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seat_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seat_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seat_deletion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new seat_deletion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Details;
    private javax.swing.JButton approve;
    private javax.swing.JButton decline;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
