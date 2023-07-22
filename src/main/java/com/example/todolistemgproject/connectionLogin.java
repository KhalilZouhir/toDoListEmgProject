package com.example.todolistemgproject;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class connectionLogin {
    private Connection con;
    private java.sql.PreparedStatement st;
    private java.sql.ResultSet rs;

    public void connecting() {//formulaire connexion c claire we check wach
        //driver available w ki tconnexta la base dedonee mysql li smitha tp_java w fiha 2 class on est juste interesser par
        //departement class
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("driver working");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("pas de driver");
            }
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost:3306/todolistemgproject", "root", "");
            System.out.println("works");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de connexion");
        }
    }
   public boolean authentification(user user){
       connecting();

       try {
           st = con.prepareStatement("select count(1) from user where name_user= ?  and mdp_user = ? ;");

           st.setString(1, user.getName_user()); 
           st.setString(2, user.getMdp_user());

           rs = st.executeQuery();
      
               while (rs.next()) {
                   if (rs.getInt(1) == 1) {return true; }
               
              
                   else{ return false;  }
                 
               }
           } catch (SQLException e) {
           throw new RuntimeException(e);  
      
       }
       return false;
   } 
   public int token(user user) throws SQLException {
int token = 0;
       connecting();
       st = con.prepareStatement("select id_user from user where name_user= ? ;");
       st.setString(1, user.getName_user());
       rs = st.executeQuery();
       while (rs.next()) {
            token = rs.getInt("id_user");
           
       }
       return token;
   }
    public List<user> recupermembers(int token) {

        List<user> user = new ArrayList<user>(); //araylist type departement yaani too many lines atstori a lot of obkects


        try {
            st = con.prepareStatement("select id_user,name_user from user where id_user!=?;");
            st.setInt(1, token);
            rs = st.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("pas de membres");
        }
        try {
            while (rs.next()) {//tant que kayn atched id w nom dyal dept at addih l wahd object w tloho l araylist
                String name = rs.getString("name_user");
                int id=rs.getInt("id_user");

                user dn = new user();
                dn.setName_user(name);
                dn.setId_user(id);
                user.add(dn);
                System.out.println("affichage done ");
                System.out.println(dn.name_user);
                System.out.println(dn.id_user);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(
                    " there is an issue "
            );
        }
        return user; //return the aray list
    }
public void deco(){

    try {
        if (rs != null)
            rs.close();
        System.out.println("deco");
        if (st != null)
            st.close();
        if (con != null)
            con.close();
        System.out.println("deconecté");
    } catch (SQLException e) {
        System.out.println(e);
    }








}

   } 

