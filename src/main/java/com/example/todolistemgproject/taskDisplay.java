package com.example.todolistemgproject;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class taskDisplay {
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

    public List<task> recuperdept(int token) {

        List<task> task = new ArrayList<task>(); //araylist type departement yaani too many lines atstori a lot of obkects


        try {
            st = con.prepareStatement("select id_task,desc_task,state_task from task where id_user=?;");
            st.setInt(1, token);
            rs = st.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("pas de task");
        }
        try {
            while (rs.next()) {//tant que kayn atched id w nom dyal dept at addih l wahd object w tloho l araylist
                String desc = rs.getString("desc_task");
                int state = rs.getInt("state_task");
                int id = rs.getInt("id_task");
                task dn = new task();
                dn.setState_task(state);
                dn.setDesc_task(desc);
                dn.setId_task(id);
                task.add(dn);
                System.out.println("affichage done ");
                System.out.println(dn.state_task);
                System.out.println(dn.desc_task);
                System.out.println(dn.id_task);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(
                    " there is an issue "
            );
        }
        return task; //return the aray list
    }
    public void updatestate(int state, int id){
       if(state==0){
            int newstate=1;
            try{st=con.prepareStatement("update task set state_task=? where  id_task=? ; ");
                st.setInt(1,newstate);
                st.setInt(2, id);

                st.executeUpdate();




            } catch (SQLException e) {
                throw new RuntimeException(e);}}

        else if (state==1) {
            int newstate=0;
            try{st=con.prepareStatement("update task set state_task=? where  id_task=? ; ");
                st.setInt(1,newstate);
                st.setInt(2, id);

                st.executeUpdate();



            } catch (SQLException e) {
                throw new RuntimeException(e);}
        }
        System.out.println("ya rabi");
    }
    public List<task> displaytaskofmember(int token) {

        List<task> task = new ArrayList<task>(); //araylist type departement yaani too many lines atstori a lot of obkects


        try {
            st = con.prepareStatement("select id_task,desc_task,state_task from task where id_user=?;");
            st.setInt(1, token);
            rs = st.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("pas de task");
        }
        try {
            while (rs.next()) {//tant que kayn atched id w nom dyal dept at addih l wahd object w tloho l araylist
                String desc = rs.getString("desc_task");
                int state = rs.getInt("state_task");
                int id = rs.getInt("id_task");
                task dn = new task();
                dn.setState_task(state);
                dn.setDesc_task(desc);
                dn.setId_task(id);
                task.add(dn);
                System.out.println("affichage done ");
                System.out.println(dn.state_task);
                System.out.println(dn.desc_task);
                System.out.println(dn.id_task);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(
                    " there is an issue "
            );
        }
        return task; //return the aray list
    }
public void ajoutertask(task tsk,int token){
    connecting();
    System.out.println("dkachi ki khdm ");
    try {
        st = con.prepareStatement("insert into task(desc_task,id_user) values(?,?);");

        st.setString(1, tsk.getDesc_task()); //object kanlooh f parametr dyal ajout
        st.setInt(2, token);

        st.executeUpdate();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    public void deletetask(int id){
        connecting();
        try {
            st = con.prepareStatement("delete from task where id_task=? ");


            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }







}