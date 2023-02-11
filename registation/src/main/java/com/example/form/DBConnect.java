// package com.example.form;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;

// public class DBConnect {
    
//     public static Connection ConnectDb(){
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/form?useSSL==false","root","password");
//          return conn;
//         } catch (Exception e) {
//             // TODO: handle exception
//             System.out.println("field");
//         }
        
//     }
//     public static ObservableList<Register> getDataregister(){
//         Connection conn = ConnectDb();
//         ObservableList<Register> list = FXCollections.observableArrayList();
//     try {
//         PreparedStatement ps= conn.prepareStatement("select * from forms");
//         ResultSet rs = ps.executeQuery();
//         while(rs.next()){
//          // list.add(new Register(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("college"),rs.getString("email"),rs.getString("phone"),rs.getString("type")));
//          String idtable = String.valueOf(rs.getInt("id"));
//          String nametable = rs.getString("name");
//         String collegetable= rs.getString("college");
//          String emailtable= rs.getString("email");
//         String phonetable= rs.getString("phone");
//         }
//     } catch (Exception e) {
//         // TODO: handle exception
//     }
//     return list;
// }
// }
