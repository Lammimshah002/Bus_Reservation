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
public class Seat_Reservation extends javax.swing.JFrame {
    /**
     * Creates new form Seat_Reservation
     */
    public Seat_Reservation() {
        initComponents();
        connect();
    }
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    PreparedStatement pst5;
    PreparedStatement pst6;
    PreparedStatement pst7;
    ResultSet rs2;
    ResultSet rs4;
    
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
    public void load()
    {
       try {
           JTableHeader header=jTable1.getTableHeader();
           Font headerfont=new Font("Times New Roman",Font.PLAIN,18);
           header.setFont(headerfont);
            
            pst4=con.prepareStatement("SELECT busno,date,time,price,seats_available from bus_schedule");
            
            rs4=pst4.executeQuery();
            DefaultTableModel d= (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            while(rs4.next())
            {
                Vector v2=new Vector();
                
                    v2.add(rs4.getString("busno"));
                    v2.add(rs4.getString("date"));
                    v2.add(rs4.getString("time"));
                    v2.add(rs4.getString("price"));
                    v2.add(rs4.getString("seats_available"));
                
                d.addRow(v2);
            }   
            
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
        jLabel5 = new javax.swing.JLabel();
        txtbus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        SR_time = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        seat_add = new javax.swing.JButton();
        cus_rec = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        set_price = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        sch_del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        del_acc = new javax.swing.JButton();
        list = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setText("      WELCOME ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(89, 43, 75));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setText("Bus No:");

        txtbus.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        txtbus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinajpur-Rangpur", "Dinajpur-Bogra", "Dinajpur-Panchagarh", " ", " " }));
        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Time:");

        SR_time.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        SR_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9AM", "12PM", "3PM" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setText("Date:");

        seat_add.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        seat_add.setText("Seat Add");
        seat_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seat_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seat_addMouseExited(evt);
            }
        });
        seat_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat_addActionPerformed(evt);
            }
        });

        cus_rec.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        cus_rec.setText("Customer Record ");
        cus_rec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cus_recMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cus_recMouseExited(evt);
            }
        });
        cus_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_recActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton1.setText("Log Out");
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

        set_price.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        set_price.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "200", "500", "800" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setText("Set Price:");

        sch_del.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        sch_del.setText("Schedule Delete");
        sch_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sch_delMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sch_delMouseExited(evt);
            }
        });
        sch_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sch_delActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Busno", "Date", "Time", "Price", "Seats_available"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        del_acc.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        del_acc.setText("Deleted Accounts");
        del_acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                del_accMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                del_accMouseExited(evt);
            }
        });
        del_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_accActionPerformed(evt);
            }
        });

        list.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        list.setText("List of Customers");
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listMouseExited(evt);
            }
        });
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(del_acc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cus_rec)
                        .addGap(82, 82, 82)
                        .addComponent(sch_del, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(set_price, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SR_time, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seat_add, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sch_del)
                    .addComponent(cus_rec)
                    .addComponent(del_acc)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SR_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(set_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_add)
                    .addComponent(list))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       Bus_Reservation b = new Bus_Reservation();
       b.setVisible(true);
       JOptionPane.showMessageDialog(null,"Log out Successfully");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void seat_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat_addActionPerformed
       
        SimpleDateFormat Date_Format= new SimpleDateFormat("yyyy-MM-dd");
        String Date = Date_Format.format(txtdate.getDate());
        
        String busno = txtbus.getSelectedItem().toString();
        String time = SR_time.getSelectedItem().toString();
        String price=set_price.getSelectedItem().toString();
        
        for(int i=1; i<=40; i++)
        {
            try {
                int seats = i;
                String status = "Unbooked";
                
                pst= con.prepareStatement("insert into seats(busno,seat,price,date,time,status)values(?,?,?,?,?,?)");
                
                pst.setString(1,busno);
                pst.setInt(2,seats);
                pst.setString(3,price);
                pst.setString(4,Date);
                pst.setString(5,time);
                pst.setString(6,status);
                pst.executeUpdate(); 
            } catch (SQLException ex) {
                Logger.getLogger(Seat_Reservation.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        //entering data into bus_schedule database
        try {
                
                pst1= con.prepareStatement("insert into bus_schedule(busno,date,time,price,seats_available)values(?,?,?,?,?)");
                
                pst1.setString(1,busno);
                pst1.setString(2,Date);
                pst1.setString(3,time);
                pst1.setString(4,price);
                pst1.setInt(5,40);
                pst1.executeUpdate(); 
                load();
            } catch (SQLException ex) {
                Logger.getLogger(Seat_Reservation.class.getName()).log(Level.SEVERE, null, ex);
            }  
        JOptionPane.showMessageDialog(this,"Seat Adding Successfully");
        
    }//GEN-LAST:event_seat_addActionPerformed

    private void cus_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_recActionPerformed
        // TODO add your handling code here:
        seat_deletion sd=new seat_deletion();
        sd.requestload();
        sd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cus_recActionPerformed

    private void sch_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sch_delActionPerformed
        // TODO add your handling code here:
            try {
                DefaultTableModel d3=(DefaultTableModel)jTable1.getModel();
            
                int selected = jTable1.getSelectedRow();
                String busno_del =d3.getValueAt(selected, 0).toString();
                String date_del =d3.getValueAt(selected, 1).toString();
                String time_del =d3.getValueAt(selected, 2).toString();
            
                pst5=con.prepareStatement("delete from bus_schedule where  busno=? and date=? and time=?");
                
                pst5.setString(1,busno_del); 
                pst5.setString(2,date_del);
                pst5.setString(3,time_del);
                pst5.executeUpdate();
                load();
                
                pst6=con.prepareStatement("delete from seats where  busno=? and date=? and time=?");
                
                pst6.setString(1,busno_del); 
                pst6.setString(2,date_del);
                pst6.setString(3,time_del);
                pst6.executeUpdate();
                
                pst7=con.prepareStatement("delete from busbook where  busno=? and date=? and time=?");
                
                pst7.setString(1,busno_del); 
                pst7.setString(2,date_del);
                pst7.setString(3,time_del);
                pst7.executeUpdate();
                }catch (SQLException ex) {
                Logger.getLogger(Seat_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_sch_delActionPerformed

    private void del_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_accActionPerformed
        // TODO add your handling code here:
        remove_accounts ra=new remove_accounts();
        ra.load();
        ra.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_del_accActionPerformed

    private void del_accMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_del_accMouseEntered
        // TODO add your handling code here:
        del_acc.setForeground(Color.BLUE);
    }//GEN-LAST:event_del_accMouseEntered

    private void del_accMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_del_accMouseExited
        // TODO add your handling code here:
         del_acc.setForeground(Color.BLACK);
    }//GEN-LAST:event_del_accMouseExited

    private void cus_recMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cus_recMouseEntered
        // TODO add your handling code here:
         cus_rec.setForeground(Color.BLUE);
    }//GEN-LAST:event_cus_recMouseEntered

    private void cus_recMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cus_recMouseExited
        // TODO add your handling code here:
         cus_rec.setForeground(Color.BLACK);
    }//GEN-LAST:event_cus_recMouseExited

    private void sch_delMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sch_delMouseEntered
        // TODO add your handling code here:
         sch_del.setForeground(Color.BLUE);
    }//GEN-LAST:event_sch_delMouseEntered

    private void sch_delMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sch_delMouseExited
        // TODO add your handling code here:
         sch_del.setForeground(Color.BLACK);
    }//GEN-LAST:event_sch_delMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
         jButton1.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
         jButton1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton1MouseExited

    private void seat_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat_addMouseEntered
        // TODO add your handling code here:
         seat_add.setForeground(Color.BLUE);
    }//GEN-LAST:event_seat_addMouseEntered

    private void seat_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat_addMouseExited
        // TODO add your handling code here:
        seat_add.setForeground(Color.BLACK);
    }//GEN-LAST:event_seat_addMouseExited

    private void listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listMouseEntered

    private void listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_listMouseExited

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat Date_Format= new SimpleDateFormat("yyyy-MM-dd");
        String Date = Date_Format.format(txtdate.getDate());
        
        String busno = txtbus.getSelectedItem().toString();
        String time = SR_time.getSelectedItem().toString();
        
        customer_list cl=new customer_list();
        cl.buscl=busno;
        cl.datecl=Date;
        cl.timecl=time;
        cl.load();
        cl.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_listActionPerformed

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
            java.util.logging.Logger.getLogger(Seat_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seat_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seat_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seat_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seat_Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> SR_time;
    private javax.swing.JButton cus_rec;
    private javax.swing.JButton del_acc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton list;
    private javax.swing.JButton sch_del;
    private javax.swing.JButton seat_add;
    public javax.swing.JComboBox<String> set_price;
    private javax.swing.JComboBox<String> txtbus;
    private com.toedter.calendar.JDateChooser txtdate;
    // End of variables declaration//GEN-END:variables
}
