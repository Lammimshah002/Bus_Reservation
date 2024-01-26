/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Reservation;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Ticket_Booking extends javax.swing.JFrame {
   
    /**
     * Creates new form Ticket_Booking
     */
    public Ticket_Booking() {
        initComponents();
        connect();      
    }
    String seats[]=new String[10000];
    String gmailtb;
    String usernametb;
    int count=0;
    int sent=0;
    Connection con;
    Connection con1;
    PreparedStatement pst;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs7;
    ResultSet rs8;
    ResultSet rs9;
    ResultSet rs10;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    PreparedStatement pst5;
    PreparedStatement pst6;
    PreparedStatement pst7;
    PreparedStatement pst8;
    PreparedStatement pst9;
    PreparedStatement pst10;
    
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/terminal","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int randomCode;
    String code;
    
    Timer tm;
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
           message.setContent("Hello "+usernametb+"."+msg, "text/plain");  
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(gmailtb));  

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
        
        tm=new Timer();
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
                    tm.cancel();
                    sendotp.setEnabled(true);
                    otp.setText("");
                }

            }
        };
        tm.scheduleAtFixedRate(task,0,1000);  
          
    }
    public void reset_seats()
    {
        for(int i=1;i<=count;i++)
        {
            if(seats[i]=="1")
            {
                seat1.setBackground(Color.white);
                enable_seats(1);
                
            }
            if(seats[i]=="2")
            {
                seat2.setBackground(Color.white);
                enable_seats(2);
                
            }
            if(seats[i]=="3")
            {
                seat3.setBackground(Color.white);
                enable_seats(3);
            }
            if(seats[i]=="4")
            {
                seat4.setBackground(Color.white);
                enable_seats(4);
            }
            if(seats[i]=="5")
            {
                seat5.setBackground(Color.white);
                enable_seats(5);
            }
            if(seats[i]=="6")
            {
                seat6.setBackground(Color.white);
                enable_seats(6);
                
            }
            if(seats[i]=="7")
            {
                seat7.setBackground(Color.white);
                enable_seats(7);
                
            }
            if(seats[i]=="8")
            {
                seat8.setBackground(Color.white);
                enable_seats(8);
                
            }
            if(seats[i]=="9")
            {
                seat9.setBackground(Color.white);
                enable_seats(9);
                
            }
            if(seats[i]=="10")
            {
                seat10.setBackground(Color.white);
                enable_seats(10);
                
            }
            
             if(seats[i]=="11")
            {
                seat11.setBackground(Color.white);
                enable_seats(11);
                
            }
            if(seats[i]=="12")
            {
                seat12.setBackground(Color.white);
                enable_seats(12);
            }
            if(seats[i]=="13")
            {
                seat13.setBackground(Color.white);
                enable_seats(13);
            }
            if(seats[i]=="14")
            {
                seat14.setBackground(Color.white);
                enable_seats(14);
            }
            if(seats[i]=="15")
            {
                seat15.setBackground(Color.white);
                enable_seats(15);
            }
            if(seats[i]=="16")
            {
                seat16.setBackground(Color.white);
                enable_seats(16);
            }
            if(seats[i]=="17")
            {
                seat17.setBackground(Color.white);
                enable_seats(17);
            }
            if(seats[i]=="18")
            {
                seat18.setBackground(Color.white);
                enable_seats(18);
            }
            if(seats[i]=="19")
            {
                seat19.setBackground(Color.white);
                enable_seats(19);
            }
            if(seats[i]=="20")
            {
                seat20.setBackground(Color.white);
                enable_seats(20);
            }
            
             if(seats[i]=="21")
            {
                seat21.setBackground(Color.white);
                enable_seats(21);
            }
            if(seats[i]=="22")
            {
                seat22.setBackground(Color.white);
                enable_seats(22);
            }
            if(seats[i]=="23")
            {
                seat23.setBackground(Color.white);
                enable_seats(23);
            }
            if(seats[i]=="24")
            {
                seat24.setBackground(Color.white);
                enable_seats(24);
            }
            if(seats[i]=="25")
            {
                seat25.setBackground(Color.white);
                enable_seats(25);
            }
            if(seats[i]=="26")
            {
                seat26.setBackground(Color.white);
                enable_seats(26);
            }
            if(seats[i]=="27")
            {
                seat27.setBackground(Color.white);
                enable_seats(27);
            }
            if(seats[i]=="28")
            {
                seat28.setBackground(Color.white);
                enable_seats(28);
            }
            if(seats[i]=="29")
            {
                seat29.setBackground(Color.white);
                enable_seats(29);
            }
            if(seats[i]=="30")
            {
                seat30.setBackground(Color.white);
                enable_seats(30);
            }
            
             if(seats[i]=="31")
            {
                seat31.setBackground(Color.white);
                enable_seats(31);
            }
            if(seats[i]=="32")
            {
                seat32.setBackground(Color.white);
                enable_seats(32);
            }
            if(seats[i]=="33")
            {
                seat33.setBackground(Color.white);
                enable_seats(33);
            }
            if(seats[i]=="34")
            {
                seat34.setBackground(Color.white);
                enable_seats(34);
            }
            if(seats[i]=="35")
            {
                seat35.setBackground(Color.white);
                enable_seats(35);
            }
            if(seats[i]=="36")
            {
                seat36.setBackground(Color.white);
                enable_seats(36);
            }
            if(seats[i]=="37")
            {
                seat37.setBackground(Color.white);
                enable_seats(37);
            }
            if(seats[i]=="38")
            {
                seat38.setBackground(Color.white);
                enable_seats(38);
            }
            if(seats[i]=="39")
            {
                seat39.setBackground(Color.white);
                enable_seats(39);
            }
            if(seats[i]=="40")
            {
                seat40.setBackground(Color.white);
                enable_seats(40);
            }
        }
        
        count=0;
        seat_price.setText("");
        seat_no.setText("");
    }
    public void setname(String G)
    {
        try {
            String username="";
            pst=con.prepareStatement("select user from customer_account where email=?");
            pst.setString(1, G);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                username=rs.getString(1);
            }
            name.setText(username);       
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void temp_disable_seats(int i)
    {
        try {
            String bus_route=bus_num.getText();
            String date=date_no.getText();
            String time=dept_time.getText();
            pst=con.prepareStatement("update seats set status=? where busno=? and seat=? and date=? and time=? ");
            pst.setString(1,"Seat_Reserved");
            pst.setString(2,bus_route);
            pst.setInt(3,i);
            pst.setString(4,date);
            pst.setString(5,time);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enable_seats(int i)
    {
        try {
            String bus_route=bus_num.getText();
            String date=date_no.getText();
            String time=dept_time.getText();
            pst=con.prepareStatement("update seats set status=? where busno=? and seat=? and date=? and time=? ");
            pst.setString(1,"Unbooked");
            pst.setString(2,bus_route);
            pst.setInt(3,i);
            pst.setString(4,date);
            pst.setString(5,time);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setlocation(String G)
    {
       try {
            String loc="";
            pst=con.prepareStatement("select location from customer_account where email=?");
            pst.setString(1, G);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                loc=rs.getString(1);
            }
            address_no.setText(loc);       
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }             
            
    }
    public void load()
    {
       try {
            String bus_route=bus_num.getText();
            String date=date_no.getText();
            String time=dept_time.getText();
            pst=con.prepareStatement("SELECT seat,price,status,date,time from seats where seats.busno=? and seats.date=? and seats.time=?");
            pst.setString(1,bus_route);
            pst.setString(2,date);
            pst.setString(3,time);
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
            DefaultTableModel d= (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            while(rs.next())
            {
                Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {
                    
                    v2.add(rs.getString("seat"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("time"));
                }
                d.addRow(v2);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public String seat_return(String seat)
    {
        String update="unbooked";
        try {
            String bus_route=bus_num.getText();
            String date=date_no.getText();
            String time=dept_time.getText();
            
            pst2=con.prepareStatement("select status from seats where seat=? and busno=? and date=? and time=?");
            pst2.setString(1,seat);
            pst2.setString(2, bus_route);
            pst2.setString(3, date);
            pst2.setString(4, time);
            rs2=pst2.executeQuery();

            while(rs2.next())
            {
                update=rs2.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return update;
    }
    public void seat_check()
    {
            String seat_1=seat1.getText();
            String s1=seat_return(seat_1);
            if(s1.equals("Seat_Reserved"))
            {
                seat1.setBackground(Color.gray);
            }
            
            String seat_2=seat2.getText();
            String s2=seat_return(seat_2);
            if(s2.equals("Seat_Reserved"))
            {
                seat2.setBackground(Color.gray);
            }
            
            String seat_3=seat3.getText();
            String s3=seat_return(seat_3);
            if(s3.equals("Seat_Reserved"))
            {
                seat3.setBackground(Color.gray);
            }
            
            String seat_4=seat4.getText();
            String s4=seat_return(seat_4);
            if(s4.equals("Seat_Reserved"))
            {
                seat4.setBackground(Color.gray);
            }
            
            String seat_5=seat5.getText();
            String s5=seat_return(seat_5);
            if(s5.equals("Seat_Reserved"))
            {
                seat5.setBackground(Color.gray);
            }
            
            String seat_6=seat6.getText();
            String s6=seat_return(seat_6);
            if(s6.equals("Seat_Reserved"))
            {
                seat6.setBackground(Color.gray);
            }
            
            String seat_7=seat7.getText();
            String s7=seat_return(seat_7);
            if(s7.equals("Seat_Reserved"))
            {
                seat7.setBackground(Color.gray);
            }
            
            String seat_8=seat8.getText();
            String s8=seat_return(seat_8);
            if(s8.equals("Seat_Reserved"))
            {
                seat8.setBackground(Color.gray);
            }
            
            String seat_9=seat9.getText();
            String s9=seat_return(seat_9);
            if(s9.equals("Seat_Reserved"))
            {
                seat9.setBackground(Color.gray);
            }
            
            String seat_10=seat10.getText();
            String s10=seat_return(seat_10);
            if(s10.equals("Seat_Reserved"))
            {
                seat10.setBackground(Color.gray);
            }
            
            String seat_11=seat11.getText();
            String s11=seat_return(seat_11);
            if(s11.equals("Seat_Reserved"))
            {
                seat11.setBackground(Color.gray);
            }
            
            String seat_12=seat12.getText();
            String s12=seat_return(seat_12);
            if(s12.equals("Seat_Reserved"))
            {
                seat12.setBackground(Color.gray);
            }
            
            String seat_13=seat13.getText();
            String s13=seat_return(seat_13);
            if(s13.equals("Seat_Reserved"))
            {
                seat13.setBackground(Color.gray);
            }
            
            String seat_14=seat14.getText();
            String s14=seat_return(seat_14);
            if(s14.equals("Seat_Reserved"))
            {
                seat14.setBackground(Color.gray);
            }
            
            String seat_15=seat15.getText();
            String s15=seat_return(seat_15);
            if(s15.equals("Seat_Reserved"))
            {
                seat15.setBackground(Color.gray);
            }
            
            String seat_16=seat16.getText();
            String s16=seat_return(seat_16);
            if(s16.equals("Seat_Reserved"))
            {
                seat16.setBackground(Color.gray);
            }
            
            String seat_17=seat17.getText();
            String s17=seat_return(seat_17);
            if(s17.equals("Seat_Reserved"))
            {
                seat17.setBackground(Color.gray);
            }
            
            String seat_18=seat18.getText();
            String s18=seat_return(seat_18);
            if(s18.equals("Seat_Reserved"))
            {
                seat18.setBackground(Color.gray);
            }
            String seat_19=seat19.getText();
            String s19=seat_return(seat_19);
            if(s19.equals("Seat_Reserved"))
            {
                seat19.setBackground(Color.gray);
            }
            String seat_20=seat20.getText();
            String s20=seat_return(seat_20);
            if(s20.equals("Seat_Reserved"))
            {
                seat20.setBackground(Color.gray);
            }
            
            String seat_21=seat21.getText();
            String s21=seat_return(seat_21);
            if(s21.equals("Seat_Reserved"))
            {
                seat21.setBackground(Color.gray);
            }
            String seat_22=seat22.getText();
            String s22=seat_return(seat_22);
            if(s22.equals("Seat_Reserved"))
            {
                seat22.setBackground(Color.gray);
            }
            String seat_23=seat23.getText();
            String s23=seat_return(seat_23);
            if(s23.equals("Seat_Reserved"))
            {
                seat23.setBackground(Color.gray);
            }
            String seat_24=seat24.getText();
            String s24=seat_return(seat_24);
            if(s24.equals("Seat_Reserved"))
            {
                seat24.setBackground(Color.gray);
            }
            String seat_25=seat25.getText();
            String s25=seat_return(seat_25);
            if(s25.equals("Seat_Reserved"))
            {
                seat25.setBackground(Color.gray);
            }
            String seat_26=seat26.getText();
            String s26=seat_return(seat_26);
            if(s26.equals("Seat_Reserved"))
            {
                seat26.setBackground(Color.gray);
            }
            String seat_27=seat27.getText();
            String s27=seat_return(seat_27);
            if(s27.equals("Seat_Reserved"))
            {
                seat27.setBackground(Color.gray);
            }
            String seat_28=seat28.getText();
            String s28=seat_return(seat_28);
            if(s28.equals("Seat_Reserved"))
            {
                seat28.setBackground(Color.gray);
            }
            String seat_29=seat29.getText();
            String s29=seat_return(seat_29);
            if(s29.equals("Seat_Reserved"))
            {
                seat29.setBackground(Color.gray);
            }
            String seat_30=seat30.getText();
            String s30=seat_return(seat_30);
            if(s30.equals("Seat_Reserved"))
            {
                seat30.setBackground(Color.gray);
            }
            String seat_31=seat31.getText();
            String s31=seat_return(seat_31);
            if(s31.equals("Seat_Reserved"))
            {
                seat31.setBackground(Color.gray);
            }
            String seat_32=seat32.getText();
            String s32=seat_return(seat_32);
            if(s32.equals("Seat_Reserved"))
            {
                seat32.setBackground(Color.gray);
            }
            String seat_33=seat33.getText();
            String s33=seat_return(seat_33);
            if(s33.equals("Seat_Reserved"))
            {
                seat33.setBackground(Color.gray);
            }
            String seat_34=seat34.getText();
            String s34=seat_return(seat_34);
            if(s34.equals("Seat_Reserved"))
            {
                seat34.setBackground(Color.gray);
            }
            String seat_35=seat35.getText();
            String s35=seat_return(seat_35);
            if(s35.equals("Seat_Reserved"))
            {
                seat35.setBackground(Color.gray);
            }
            String seat_36=seat36.getText();
            String s36=seat_return(seat_36);
            if(s36.equals("Seat_Reserved"))
            {
                seat36.setBackground(Color.gray);
            }
            String seat_37=seat37.getText();
            String s37=seat_return(seat_37);
            if(s37.equals("Seat_Reserved"))
            {
                seat37.setBackground(Color.gray);
            }
            String seat_38=seat38.getText();
            String s38=seat_return(seat_38);
            if(s38.equals("Seat_Reserved"))
            {
                seat38.setBackground(Color.gray);
            }
            String seat_39=seat39.getText();
            String s39=seat_return(seat_39);
            if(s39.equals("Seat_Reserved"))
            {
                seat39.setBackground(Color.gray);
            }
            
            String seat_40=seat40.getText();
            String s40=seat_return(seat_40);
            if(s40.equals("Seat_Reserved"))
            {
                seat40.setBackground(Color.gray);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        seat_no = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        mob_no = new javax.swing.JTextField();
        address_no = new javax.swing.JTextField();
        payment_via = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        seat_price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        date_no = new javax.swing.JTextField();
        dept_time = new javax.swing.JTextField();
        acc_no = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        sendotp = new javax.swing.JButton();
        timer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        seat4 = new javax.swing.JButton();
        seat3 = new javax.swing.JButton();
        seat1 = new javax.swing.JButton();
        seat2 = new javax.swing.JButton();
        seat5 = new javax.swing.JButton();
        seat6 = new javax.swing.JButton();
        seat7 = new javax.swing.JButton();
        seat8 = new javax.swing.JButton();
        seat9 = new javax.swing.JButton();
        seat10 = new javax.swing.JButton();
        seat11 = new javax.swing.JButton();
        seat12 = new javax.swing.JButton();
        seat13 = new javax.swing.JButton();
        seat14 = new javax.swing.JButton();
        seat15 = new javax.swing.JButton();
        seat16 = new javax.swing.JButton();
        seat17 = new javax.swing.JButton();
        seat18 = new javax.swing.JButton();
        seat19 = new javax.swing.JButton();
        seat20 = new javax.swing.JButton();
        seat21 = new javax.swing.JButton();
        seat22 = new javax.swing.JButton();
        seat23 = new javax.swing.JButton();
        seat24 = new javax.swing.JButton();
        seat25 = new javax.swing.JButton();
        seat26 = new javax.swing.JButton();
        seat27 = new javax.swing.JButton();
        seat28 = new javax.swing.JButton();
        seat29 = new javax.swing.JButton();
        seat30 = new javax.swing.JButton();
        seat31 = new javax.swing.JButton();
        seat32 = new javax.swing.JButton();
        seat33 = new javax.swing.JButton();
        seat34 = new javax.swing.JButton();
        seat35 = new javax.swing.JButton();
        seat36 = new javax.swing.JButton();
        seat37 = new javax.swing.JButton();
        seat38 = new javax.swing.JButton();
        seat39 = new javax.swing.JButton();
        seat40 = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        Confirm_Seats1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bus_num = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        money_transacted = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setText("We are promised to make your journey hasslefree.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel2.setText("Customer Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel3.setText("        Mobile No:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel4.setText("            Seat No:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel5.setText("            Address:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel6.setText("Departure Time:");

        seat_no.setEditable(false);
        seat_no.setBackground(new java.awt.Color(255, 255, 255));
        seat_no.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        name.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        mob_no.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        address_no.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        payment_via.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        payment_via.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bkash", "Rocket", "Nagad", "Master card", "Atm card" }));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel10.setText("Payment Via:");

        seat_price.setEditable(false);
        seat_price.setBackground(new java.awt.Color(255, 255, 255));
        seat_price.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel8.setText("Date:");

        date_no.setEditable(false);
        date_no.setBackground(new java.awt.Color(255, 255, 255));
        date_no.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        dept_time.setEditable(false);
        dept_time.setBackground(new java.awt.Color(255, 255, 255));
        dept_time.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        acc_no.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        acc_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                acc_noKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setText("Bank Account/Card Number");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel11.setText("  Total Price:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel15.setText("Last Activity of your A/C:");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash In", "Cash Out", "Send Money", "Pay Bill", "Reset Pin", "No Transaction", " " }));

        sendotp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sendotp.setText("Send Otp");
        sendotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendotpActionPerformed(evt);
            }
        });

        timer.setEditable(false);
        timer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(296, 296, 296))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seat_price))
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acc_no)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_no, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel6)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(seat_no, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                    .addComponent(mob_no)
                                    .addComponent(address_no)
                                    .addComponent(name)
                                    .addComponent(dept_time))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(payment_via, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendotp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(12, 12, 12)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mob_no, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_no, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dept_time, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(date_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment_via, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendotp)
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat", "Price", "Status", "Date", "Time"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("Entrance");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setIcon(new javax.swing.ImageIcon("G:\\Level_3,1\\Software Project\\pics\\download (1).png")); // NOI18N

        seat4.setBackground(new java.awt.Color(255, 255, 255));
        seat4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat4.setText("4");
        seat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat4MouseClicked(evt);
            }
        });

        seat3.setBackground(new java.awt.Color(255, 255, 255));
        seat3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat3.setText("3");
        seat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat3MouseClicked(evt);
            }
        });

        seat1.setBackground(new java.awt.Color(255, 255, 255));
        seat1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat1.setText("1");
        seat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat1MouseClicked(evt);
            }
        });

        seat2.setBackground(new java.awt.Color(255, 255, 255));
        seat2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat2.setText("2");
        seat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat2MouseClicked(evt);
            }
        });

        seat5.setBackground(new java.awt.Color(255, 255, 255));
        seat5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat5.setText("5");
        seat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat5MouseClicked(evt);
            }
        });

        seat6.setBackground(new java.awt.Color(255, 255, 255));
        seat6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat6.setText("6");
        seat6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat6MouseClicked(evt);
            }
        });

        seat7.setBackground(new java.awt.Color(255, 255, 255));
        seat7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat7.setText("7");
        seat7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat7MouseClicked(evt);
            }
        });

        seat8.setBackground(new java.awt.Color(255, 255, 255));
        seat8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat8.setText("8");
        seat8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat8MouseClicked(evt);
            }
        });

        seat9.setBackground(new java.awt.Color(255, 255, 255));
        seat9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat9.setText("9");
        seat9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat9MouseClicked(evt);
            }
        });

        seat10.setBackground(new java.awt.Color(255, 255, 255));
        seat10.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat10.setText("10");
        seat10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat10MouseClicked(evt);
            }
        });

        seat11.setBackground(new java.awt.Color(255, 255, 255));
        seat11.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat11.setText("11");
        seat11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat11MouseClicked(evt);
            }
        });

        seat12.setBackground(new java.awt.Color(255, 255, 255));
        seat12.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat12.setText("12");
        seat12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat12MouseClicked(evt);
            }
        });

        seat13.setBackground(new java.awt.Color(255, 255, 255));
        seat13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat13.setText("13");
        seat13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat13MouseClicked(evt);
            }
        });
        seat13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat13ActionPerformed(evt);
            }
        });

        seat14.setBackground(new java.awt.Color(255, 255, 255));
        seat14.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat14.setText("14");
        seat14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat14MouseClicked(evt);
            }
        });

        seat15.setBackground(new java.awt.Color(255, 255, 255));
        seat15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat15.setText("15");
        seat15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat15MouseClicked(evt);
            }
        });

        seat16.setBackground(new java.awt.Color(255, 255, 255));
        seat16.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat16.setText("16");
        seat16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat16MouseClicked(evt);
            }
        });

        seat17.setBackground(new java.awt.Color(255, 255, 255));
        seat17.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat17.setText("17");
        seat17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat17MouseClicked(evt);
            }
        });

        seat18.setBackground(new java.awt.Color(255, 255, 255));
        seat18.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat18.setText("18");
        seat18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat18MouseClicked(evt);
            }
        });

        seat19.setBackground(new java.awt.Color(255, 255, 255));
        seat19.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat19.setText("19");
        seat19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat19MouseClicked(evt);
            }
        });

        seat20.setBackground(new java.awt.Color(255, 255, 255));
        seat20.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat20.setText("20");
        seat20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat20MouseClicked(evt);
            }
        });

        seat21.setBackground(new java.awt.Color(255, 255, 255));
        seat21.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat21.setText("21");
        seat21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat21MouseClicked(evt);
            }
        });

        seat22.setBackground(new java.awt.Color(255, 255, 255));
        seat22.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat22.setText("22");
        seat22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat22MouseClicked(evt);
            }
        });

        seat23.setBackground(new java.awt.Color(255, 255, 255));
        seat23.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat23.setText("23");
        seat23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat23MouseClicked(evt);
            }
        });

        seat24.setBackground(new java.awt.Color(255, 255, 255));
        seat24.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat24.setText("24");
        seat24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat24MouseClicked(evt);
            }
        });

        seat25.setBackground(new java.awt.Color(255, 255, 255));
        seat25.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat25.setText("25");
        seat25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat25MouseClicked(evt);
            }
        });

        seat26.setBackground(new java.awt.Color(255, 255, 255));
        seat26.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat26.setText("26");
        seat26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat26MouseClicked(evt);
            }
        });

        seat27.setBackground(new java.awt.Color(255, 255, 255));
        seat27.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat27.setText("27");
        seat27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat27MouseClicked(evt);
            }
        });

        seat28.setBackground(new java.awt.Color(255, 255, 255));
        seat28.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat28.setText("28");
        seat28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat28MouseClicked(evt);
            }
        });

        seat29.setBackground(new java.awt.Color(255, 255, 255));
        seat29.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat29.setText("29");
        seat29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat29MouseClicked(evt);
            }
        });

        seat30.setBackground(new java.awt.Color(255, 255, 255));
        seat30.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat30.setText("30");
        seat30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat30MouseClicked(evt);
            }
        });

        seat31.setBackground(new java.awt.Color(255, 255, 255));
        seat31.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat31.setText("31");
        seat31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat31MouseClicked(evt);
            }
        });

        seat32.setBackground(new java.awt.Color(255, 255, 255));
        seat32.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat32.setText("32");
        seat32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat32MouseClicked(evt);
            }
        });

        seat33.setBackground(new java.awt.Color(255, 255, 255));
        seat33.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat33.setText("33");
        seat33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat33MouseClicked(evt);
            }
        });

        seat34.setBackground(new java.awt.Color(255, 255, 255));
        seat34.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat34.setText("34");
        seat34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat34MouseClicked(evt);
            }
        });

        seat35.setBackground(new java.awt.Color(255, 255, 255));
        seat35.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat35.setText("35");
        seat35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat35MouseClicked(evt);
            }
        });

        seat36.setBackground(new java.awt.Color(255, 255, 255));
        seat36.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat36.setText("36");
        seat36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat36MouseClicked(evt);
            }
        });

        seat37.setBackground(new java.awt.Color(255, 255, 255));
        seat37.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat37.setText("37");
        seat37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat37MouseClicked(evt);
            }
        });

        seat38.setBackground(new java.awt.Color(255, 255, 255));
        seat38.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat38.setText("38");
        seat38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat38MouseClicked(evt);
            }
        });

        seat39.setBackground(new java.awt.Color(255, 255, 255));
        seat39.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat39.setText("39");
        seat39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat39MouseClicked(evt);
            }
        });

        seat40.setBackground(new java.awt.Color(255, 255, 255));
        seat40.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        seat40.setText("40");
        seat40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat40MouseClicked(evt);
            }
        });

        reset.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        reset.setText("Reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        Confirm_Seats1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Confirm_Seats1.setText("Confirm Seats");
        Confirm_Seats1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Confirm_Seats1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Confirm_Seats1MouseExited(evt);
            }
        });
        Confirm_Seats1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_Seats1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(seat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(seat3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(seat37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seat39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seat40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Confirm_Seats1)
                        .addGap(47, 47, 47))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat4)
                    .addComponent(seat3)
                    .addComponent(seat2)
                    .addComponent(seat1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat8)
                    .addComponent(seat7)
                    .addComponent(seat6)
                    .addComponent(seat5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat12)
                    .addComponent(seat11)
                    .addComponent(seat10)
                    .addComponent(seat9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat16)
                    .addComponent(seat15)
                    .addComponent(seat14)
                    .addComponent(seat13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat20)
                    .addComponent(seat19)
                    .addComponent(seat18)
                    .addComponent(seat17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat24)
                    .addComponent(seat23)
                    .addComponent(seat22)
                    .addComponent(seat21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat28)
                    .addComponent(seat27)
                    .addComponent(seat26)
                    .addComponent(seat25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat32)
                    .addComponent(seat31)
                    .addComponent(seat30)
                    .addComponent(seat29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat36)
                    .addComponent(seat35)
                    .addComponent(seat34)
                    .addComponent(seat33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat40)
                    .addComponent(seat39)
                    .addComponent(seat38)
                    .addComponent(seat37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Confirm_Seats1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("CHOOSE YOUR SEAT");

        bus_num.setEditable(false);
        bus_num.setBackground(new java.awt.Color(255, 255, 255));
        bus_num.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bus_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bus_numActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel9.setText("      Bus Number:");

        jButton3.setBackground(java.awt.Color.gray);
        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton3.setText("Reserved");
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

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel16.setText("Give Your OTP Below");

        otp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpActionPerformed(evt);
            }
        });
        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
        });

        money_transacted.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(16, 16, 16)
                        .addComponent(bus_num, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(otp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(money_transacted, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2871, 2871, 2871))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bus_num, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(money_transacted, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i=1;i<=count;i++)
        {
         for(int j=1;j<=40;j++)
         {
             if(seats[i].equals(Integer.toString(j)))
             {
                 enable_seats(j);
             }
         }
        }
        this.setVisible(false);
        Customer_choice cch=new Customer_choice();
        cch.setVisible(true);
        cch.username_cch=usernametb;
        cch.gmail_cch=gmailtb;
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void bus_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bus_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bus_numActionPerformed

    private void seat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat1MouseClicked
            String seat_1=seat1.getText();
            String update=seat_return(seat_1);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_1; 
                    seat1.setBackground(Color.yellow);
                    temp_disable_seats(1);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }   
    }//GEN-LAST:event_seat1MouseClicked

    private void seat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat2MouseClicked
        // TODO add your handling code here:
            String seat_2=seat2.getText();
            String update=seat_return(seat_2);
            if(update.equals("Seat_Reserved"))
            {
               
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
              if(count<=3)
                {
                    count++;
                    seats[count]=seat_2; 
                    seat2.setBackground(Color.yellow);
                    temp_disable_seats(2);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }  
            }
    }//GEN-LAST:event_seat2MouseClicked

    private void seat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat3MouseClicked
        // TODO add your handling code here:
            String seat_3=seat3.getText();
            String update=seat_return(seat_3);  
            if(update.equals("Seat_Reserved"))
            {
                
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_3; 
                    seat3.setBackground(Color.yellow);
                    temp_disable_seats(3);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat3MouseClicked

    private void seat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat4MouseClicked
        // TODO add your handling code here:
            String seat_4=seat4.getText();
            String update=seat_return(seat_4);
            if(update.equals("Seat_Reserved"))
            {
                
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
               if(count<=3)
                {
                    count++;
                    seats[count]=seat_4; 
                    seat4.setBackground(Color.yellow);
                    temp_disable_seats(4);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }  
            }
    }//GEN-LAST:event_seat4MouseClicked

    private void seat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat5MouseClicked
        // TODO add your handling code here:
            String seat_5=seat5.getText();
            String update=seat_return(seat_5);
            
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_5; 
                    seat5.setBackground(Color.yellow);
                    temp_disable_seats(5);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat5MouseClicked

    private void seat6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat6MouseClicked
        // TODO add your handling code here:
            String seat_6=seat6.getText();
            String update=seat_return(seat_6);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_6; 
                    seat6.setBackground(Color.yellow);
                    temp_disable_seats(6);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat6MouseClicked

    private void seat7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat7MouseClicked
        // TODO add your handling code here:
            String seat_7=seat7.getText();
            String update=seat_return(seat_7);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_7; 
                    seat7.setBackground(Color.yellow);
                    temp_disable_seats(7);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat7MouseClicked

    private void seat8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat8MouseClicked
        // TODO add your handling code here:
        String seat_8=seat8.getText();
            String update=seat_return(seat_8);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_8; 
                    seat8.setBackground(Color.yellow);
                    temp_disable_seats(8);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat8MouseClicked

    private void seat9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat9MouseClicked
        // TODO add your handling code here:
            String seat_9=seat9.getText();
            String update=seat_return(seat_9);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_9; 
                    seat9.setBackground(Color.yellow);
                    temp_disable_seats(9);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat9MouseClicked

    private void seat10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat10MouseClicked
        // TODO add your handling code here:
            String seat_10=seat10.getText();
            String update=seat_return(seat_10);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_10; 
                    seat10.setBackground(Color.yellow);
                    temp_disable_seats(10);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat10MouseClicked

    private void seat11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat11MouseClicked
        // TODO add your handling code here:
        String seat_11=seat11.getText();
            String update=seat_return(seat_11);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_11; 
                    seat11.setBackground(Color.yellow);
                    temp_disable_seats(11);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat11MouseClicked

    private void seat12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat12MouseClicked
        // TODO add your handling code here:
            String seat_12=seat12.getText();
            String update=seat_return(seat_12);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_12; 
                    seat12.setBackground(Color.yellow);
                    temp_disable_seats(12);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat12MouseClicked

    private void seat13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat13MouseClicked
        // TODO add your handling code here:
            String seat_13=seat13.getText();
            String update=seat_return(seat_13);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_13; 
                    seat13.setBackground(Color.yellow);
                    temp_disable_seats(13);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat13MouseClicked

    private void seat14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat14MouseClicked
        // TODO add your handling code here:
            String seat_14=seat14.getText();
            String update=seat_return(seat_14);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
               if(count<=3)
                {
                    count++;
                    seats[count]=seat_14; 
                    seat14.setBackground(Color.yellow);
                    temp_disable_seats(14);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat14MouseClicked

    private void seat15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat15MouseClicked
        // TODO add your handling code here:
            String seat_15=seat15.getText();
            String update=seat_return(seat_15);
            if(update.equals("Seat_Reserved"))
            {
                
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_15; 
                    seat15.setBackground(Color.yellow);
                    temp_disable_seats(15);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat15MouseClicked

    private void seat16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat16MouseClicked
        // TODO add your handling code here:
            String seat_16=seat16.getText();
            String update=seat_return(seat_16);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_16; 
                    seat16.setBackground(Color.yellow);
                    temp_disable_seats(16);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat16MouseClicked

    private void seat17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat17MouseClicked
        // TODO add your handling code here:
            String seat_17=seat17.getText();
            String update=seat_return(seat_17);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
               if(count<=3)
                {
                    count++;
                    seats[count]=seat_17; 
                    seat17.setBackground(Color.yellow);
                    temp_disable_seats(17);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat17MouseClicked

    private void seat18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat18MouseClicked
        // TODO add your handling code here:
            String seat_18=seat18.getText();
            String update=seat_return(seat_18);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_18; 
                    seat18.setBackground(Color.yellow);
                    temp_disable_seats(18);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat18MouseClicked

    private void seat19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat19MouseClicked
        // TODO add your handling code here:
            String seat_19=seat19.getText();
            String update=seat_return(seat_19);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_19; 
                    seat19.setBackground(Color.yellow);
                    temp_disable_seats(19);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat19MouseClicked

    private void seat20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat20MouseClicked
        // TODO add your handling code here:
            String seat_20=seat20.getText();
            String update=seat_return(seat_20);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_20; 
                    seat20.setBackground(Color.yellow);
                    temp_disable_seats(20);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat20MouseClicked

    private void seat21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat21MouseClicked
        // TODO add your handling code here:
            String seat_21=seat21.getText();
            String update=seat_return(seat_21);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_21; 
                    seat21.setBackground(Color.yellow);
                    temp_disable_seats(21);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat21MouseClicked

    private void seat22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat22MouseClicked
        // TODO add your handling code here:
            String seat_22=seat22.getText();
            String update=seat_return(seat_22);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_22; 
                    seat22.setBackground(Color.yellow);
                    temp_disable_seats(22);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat22MouseClicked

    private void seat23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat23MouseClicked
        // TODO add your handling code here:
            String seat_23=seat23.getText();
            String update=seat_return(seat_23);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_23; 
                    seat23.setBackground(Color.yellow);
                    temp_disable_seats(23);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat23MouseClicked

    private void seat24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat24MouseClicked
        // TODO add your handling code here:
            String seat_24=seat24.getText();
            String update=seat_return(seat_24);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_24; 
                    seat24.setBackground(Color.yellow);
                    temp_disable_seats(24);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat24MouseClicked

    private void seat25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat25MouseClicked
        // TODO add your handling code here:
        String seat_25=seat25.getText();
            String update=seat_return(seat_25);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_25; 
                    seat25.setBackground(Color.yellow);
                    temp_disable_seats(25);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat25MouseClicked

    private void seat26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat26MouseClicked
        // TODO add your handling code here:
            String seat_26=seat26.getText();
            String update=seat_return(seat_26);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_26; 
                    seat26.setBackground(Color.yellow);
                    temp_disable_seats(26);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat26MouseClicked

    private void seat27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat27MouseClicked
        // TODO add your handling code here:
            String seat_27=seat27.getText();
            String update=seat_return(seat_27);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_27; 
                    seat27.setBackground(Color.yellow);
                    temp_disable_seats(27);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat27MouseClicked

    private void seat28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat28MouseClicked
        // TODO add your handling code here:
            String seat_28=seat28.getText();
            String update=seat_return(seat_28);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_28; 
                    seat28.setBackground(Color.yellow);
                    temp_disable_seats(28);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat28MouseClicked

    private void seat29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat29MouseClicked
        // TODO add your handling code here:
            String seat_29=seat29.getText();
            String update=seat_return(seat_29);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_29; 
                    seat29.setBackground(Color.yellow);
                    temp_disable_seats(29);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat29MouseClicked

    private void seat30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat30MouseClicked
        // TODO add your handling code here:
            String seat_30=seat30.getText();
            String update=seat_return(seat_30);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_30; 
                    seat30.setBackground(Color.yellow);
                    temp_disable_seats(30);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                } 
            }
    }//GEN-LAST:event_seat30MouseClicked

    private void seat31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat31MouseClicked
        // TODO add your handling code here:
            String seat_31=seat31.getText();
            String update=seat_return(seat_31);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_31; 
                    seat31.setBackground(Color.yellow);
                    temp_disable_seats(31);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat31MouseClicked

    private void seat32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat32MouseClicked
        // TODO add your handling code here:
            String seat_32=seat32.getText();
            String update=seat_return(seat_32);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_32; 
                    seat32.setBackground(Color.yellow);
                    temp_disable_seats(32);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat32MouseClicked

    private void seat33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat33MouseClicked
        // TODO add your handling code here:
            String seat_33=seat33.getText();
            String update=seat_return(seat_33);
            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_33; 
                    seat33.setBackground(Color.yellow);
                    temp_disable_seats(33);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat33MouseClicked

    private void seat34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat34MouseClicked
        // TODO add your handling code here:
            String seat_34=seat34.getText();
            String update=seat_return(seat_34);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_34; 
                    seat34.setBackground(Color.yellow);
                    temp_disable_seats(34);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat34MouseClicked

    private void seat35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat35MouseClicked
        // TODO add your handling code here:
            String seat_35=seat35.getText();
            String update=seat_return(seat_35);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_35; 
                    seat35.setBackground(Color.yellow);
                    temp_disable_seats(35);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat35MouseClicked

    private void seat36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat36MouseClicked
        // TODO add your handling code here:
            String seat_36=seat36.getText();
            String update=seat_return(seat_36);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_36; 
                    seat36.setBackground(Color.yellow);
                    temp_disable_seats(36);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat36MouseClicked

    private void seat37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat37MouseClicked
        // TODO add your handling code here:
            String seat_37=seat37.getText();
            String update=seat_return(seat_37);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_37; 
                    seat37.setBackground(Color.yellow);
                    temp_disable_seats(37);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat37MouseClicked

    private void seat38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat38MouseClicked
            
            String seat_38=seat38.getText();
            String update=seat_return(seat_38);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_38; 
                    seat38.setBackground(Color.yellow);
                    temp_disable_seats(38);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat38MouseClicked

    private void seat39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat39MouseClicked
        // TODO add your handling code here:
            String seat_39=seat39.getText();
            String update=seat_return(seat_39);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_39; 
                    seat39.setBackground(Color.yellow);
                    temp_disable_seats(39);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat39MouseClicked

    private void seat40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat40MouseClicked
        // TODO add your handling code here:
            String seat_40=seat40.getText();
            String update=seat_return(seat_40);

            if(update.equals("Seat_Reserved"))
            {
                JOptionPane.showMessageDialog(this,"Sorry! Seat Alraedy Reserved.");
            }
            else
            {
                if(count<=3)
                {
                    count++;
                    seats[count]=seat_40; 
                    seat40.setBackground(Color.yellow);
                    temp_disable_seats(40);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sorry! You can not reserve more than 4 seats!");
                }
            }
    }//GEN-LAST:event_seat40MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(sent==0)
        {
          JOptionPane.showMessageDialog(this,"Seats are Unable to Reserved..... Make sure Money Send is Successful");  
        }
        else
        {
            try {
            receipt rc=new receipt();
            String cusname= name.getText();
            rc.receip_cus.setText(cusname);
            
            String mob= mob_no.getText();
            rc.receip_mob.setText(mob);
            
            String address= address_no.getText();
            String price=seat_price.getText();
            String pay_via=payment_via.getSelectedItem().toString();
            rc.receip_pay.setText(pay_via);
            
            String account_no=acc_no.getText();
            
            String bus_route=bus_num.getText();
            rc.receip_route.setText(bus_route);
            
            String date=date_no.getText();
            rc.receip_date.setText(date);
            
            String time=dept_time.getText();
            rc.receip_time.setText(time);
            
            String seat=seat_no.getText();
            rc.receip_seat.setText(seat);
            
            rc.username_receipt=usernametb;
            rc.gmail_receipt=gmailtb;
            

            if(seat.isEmpty()|| cusname.isEmpty() || price.isEmpty() || mob.isEmpty()|| address.isEmpty()|| pay_via.isEmpty()|| account_no.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Make sure that you have filled all information");
            }
            else
            {
                for(int i=1;i<=count;i++)
                {
                    pst= con.prepareStatement("insert into busbook(busno,seat,customer,email,mobile,address,date,time,payment_via,card_number,price)values(?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1,bus_route);
                    pst.setString(2,seats[i]);
                    pst.setString(3,cusname);
                    pst.setString(4,gmailtb);
                    pst.setString(5,mob);
                    pst.setString(6,address);
                    pst.setString(7,date);
                    pst.setString(8,time);
                    pst.setString(9,pay_via);
                    pst.setString(10,account_no);
                    pst.setString(11,price);
                    pst.executeUpdate();

                    
                }
                
                //updating the seats_available value of bus_schedule table
                int x=0;
                pst4=con.prepareStatement("select seats_available from bus_schedule where busno=? and date=? and time=?");
                pst4.setString(1,bus_route);
                pst4.setString(2,date);
                pst4.setString(3,time);
                rs4=pst4.executeQuery();
                while(rs4.next())
                {
                  x=rs4.getInt(1);  
                }
                int seats_available=x-count;
                pst5=con.prepareStatement("update bus_schedule set seats_available=? where busno=? and date=? and time=?");
                pst5.setInt(1,seats_available);
                pst5.setString(2,bus_route);
                pst5.setString(3,date);
                pst5.setString(4,time);
                pst5.executeUpdate();
                
                String x_email="";
                
                pst7=con.prepareStatement("select email from my_receipt where busno=? and date=? and time=?");
                pst7.setString(1,bus_route);
                pst7.setString(2,date);
                pst7.setString(3,time);
                rs7=pst7.executeQuery();
                while(rs7.next())
                {
                    x_email=rs7.getString(1);
                }
                if(x_email.equals(gmailtb))
                {
                    pst8=con.prepareStatement("select seatno from my_receipt where email=?");
                    pst8.setString(1,gmailtb);
                    rs8=pst8.executeQuery();
                    String seats_rep="";
                    while(rs8.next())
                    {
                        seats_rep=rs8.getString(1);
                    }
                    String replace=seat.replace("S :", "");
                    
                    seats_rep=seats_rep+","+replace;
                    pst9=con.prepareStatement("update my_receipt set seatno=? where email=? and busno=? and date=? and time=?");
                    pst9.setString(1,seats_rep);
                    pst9.setString(2,gmailtb);
                    pst9.setString(3,bus_route);
                    pst9.setString(4,date);
                    pst9.setString(5,time);
                    pst9.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Seat Successfully Reserved, Thank You.");
                    load();
                    this.setVisible(false);
                    rc.setVisible(true);
                }
                else
                {
                    //update my_receipt table
                    pst6=con.prepareStatement("insert into my_receipt(email,busno,seatno,date,time,pay_method,mobile)values(?,?,?,?,?,?,?)");
                    pst6.setString(1,gmailtb);
                    pst6.setString(2,bus_route);
                    pst6.setString(3,seat);
                    pst6.setString(4,date);
                    pst6.setString(5,time);
                    pst6.setString(6,pay_via);
                    pst6.setString(7,mob);
                    pst6.executeUpdate();

                    JOptionPane.showMessageDialog(this,"Seat Successfully Reserved, Thank You.");
                    load();
                    this.setVisible(false);
                    rc.setVisible(true);
                    
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        jButton3.setBackground(Color.gray);
        reset_seats();    
    }//GEN-LAST:event_resetActionPerformed

    private void Confirm_Seats1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_Seats1ActionPerformed
        // TODO add your handling code here:
        String bus_route=bus_num.getText();
        String date=date_no.getText();
        String time=dept_time.getText();
         try {
            pst10=con.prepareStatement("select seat from busbook where busno=? and date=? and time=? and email=?");
            pst10.setString(1, bus_route);
            pst10.setString(2, date);
            pst10.setString(3, time);
            pst10.setString(4, gmailtb);
            rs10=pst10.executeQuery();
            int seat_count=0;

            while(rs10.next())
            {
                seat_count++;
            }
            if((count+seat_count)<5)
            {
                String another="S :";
                for(int i=1;i<=count;i++)
                {
                    if(i==count)
                    {
                       another=another+" "+seats[i]; 
                    }
                    else
                    {
                        another=another+" "+seats[i]+",";
                    }

                }
                seat_no.setText(another);
                //get price for specific route
                try {
                    // TODO add your handling code here:

                    pst3=con.prepareStatement("select price from seats where busno=? and date=? and time=?");

                    pst3.setString(1, bus_route);
                    pst3.setString(2, date);
                    pst3.setString(3, time);
                    rs3=pst3.executeQuery();
                    String Pp="Unavailable Selection";

                    while(rs3.next())
                    {
                        Pp=rs3.getString(1);

                    }
                    int a=Integer.parseInt(Pp);
                    int multi=a*count;
                    String final_price=String.valueOf(multi);
                    seat_price.setText(final_price);    
                } catch (SQLException ex) {
                    Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            
            else
            {
                JOptionPane.showMessageDialog(this,"You can not reserved more than 4 seats");
                reset_seats();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket_Booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }//GEN-LAST:event_Confirm_Seats1ActionPerformed
  
    private void acc_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acc_noKeyPressed

    }//GEN-LAST:event_acc_noKeyPressed

    private void Confirm_Seats1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Confirm_Seats1MouseEntered
        // TODO add your handling code here:
        Confirm_Seats1.setForeground(Color.BLUE);
    }//GEN-LAST:event_Confirm_Seats1MouseEntered

    private void Confirm_Seats1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Confirm_Seats1MouseExited
        // TODO add your handling code here:
        Confirm_Seats1.setForeground(Color.BLACK);
    }//GEN-LAST:event_Confirm_Seats1MouseExited

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        reset.setForeground(Color.BLUE);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_resetMouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLUE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton2MouseExited

    private void sendotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendotpActionPerformed
        // TODO add your handling code here:
        String Seat=seat_no.getText();
        String ac =acc_no.getText();
        String phn=mob_no.getText();
        String pay_method=payment_via.getSelectedItem().toString();
        String card=acc_no.getText();
        if(Seat.isEmpty() || ac.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Check Your Seats & Account Number");
        }
        else
        {
            if(pay_method.equals("Bkash") ||pay_method.equals("Nagad") || pay_method.equals("Rocket"))
            {
                if(card.length()==11 && phn.length()==11)
                {
                    send_otp();
                    sendotp.setEnabled(false);
                    
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Check Your Mobile and Card Number Properly");
                    
                }
            }
            else
            {
                if(card.length()==16 && phn.length()==11)
                {
                    send_otp();
                    sendotp.setEnabled(false);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Check Your Mobile and Card Number Properly");
                    
                }
            }
            
        }
    }//GEN-LAST:event_sendotpActionPerformed

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        // TODO add your handling code here:
        String getotp=otp.getText();
        if(getotp.equals(code))
        {
            tm.cancel();
            jButton3.setBackground(Color.white);
            sent=1;
            money_transacted.setText("Money Transmitted");
            otp.setEditable(false);
        }
        
           
    }//GEN-LAST:event_otpKeyReleased

    private void otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otpActionPerformed

    private void seat13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seat13ActionPerformed

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
            java.util.logging.Logger.getLogger(Ticket_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm_Seats1;
    private javax.swing.JTextField acc_no;
    private javax.swing.JTextField address_no;
    public javax.swing.JTextField bus_num;
    public javax.swing.JTextField date_no;
    public javax.swing.JTextField dept_time;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField mob_no;
    private javax.swing.JLabel money_transacted;
    private javax.swing.JTextField name;
    private javax.swing.JTextField otp;
    private javax.swing.JComboBox<String> payment_via;
    private javax.swing.JButton reset;
    private javax.swing.JButton seat1;
    private javax.swing.JButton seat10;
    private javax.swing.JButton seat11;
    private javax.swing.JButton seat12;
    private javax.swing.JButton seat13;
    private javax.swing.JButton seat14;
    private javax.swing.JButton seat15;
    private javax.swing.JButton seat16;
    private javax.swing.JButton seat17;
    private javax.swing.JButton seat18;
    private javax.swing.JButton seat19;
    private javax.swing.JButton seat2;
    private javax.swing.JButton seat20;
    private javax.swing.JButton seat21;
    private javax.swing.JButton seat22;
    private javax.swing.JButton seat23;
    private javax.swing.JButton seat24;
    private javax.swing.JButton seat25;
    private javax.swing.JButton seat26;
    private javax.swing.JButton seat27;
    private javax.swing.JButton seat28;
    private javax.swing.JButton seat29;
    private javax.swing.JButton seat3;
    private javax.swing.JButton seat30;
    private javax.swing.JButton seat31;
    private javax.swing.JButton seat32;
    private javax.swing.JButton seat33;
    private javax.swing.JButton seat34;
    private javax.swing.JButton seat35;
    private javax.swing.JButton seat36;
    private javax.swing.JButton seat37;
    private javax.swing.JButton seat38;
    private javax.swing.JButton seat39;
    private javax.swing.JButton seat4;
    private javax.swing.JButton seat40;
    private javax.swing.JButton seat5;
    private javax.swing.JButton seat6;
    private javax.swing.JButton seat7;
    private javax.swing.JButton seat8;
    private javax.swing.JButton seat9;
    private javax.swing.JTextField seat_no;
    public javax.swing.JTextField seat_price;
    private javax.swing.JButton sendotp;
    private javax.swing.JTextField timer;
    // End of variables declaration//GEN-END:variables
}
