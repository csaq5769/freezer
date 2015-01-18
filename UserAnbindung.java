import java.sql.*;

public class MySQLConnection{
private static Connection con = null;
private static String dbHost = "localhost"; // Hostname
private static String dbPort = "3306";      // Port -- Standard: 3306
private static String dbName = "csaq6174_User";   // Datenbankname

 
private MySQLConnection(){
    try {
        Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.
 
        // Verbindung zur JDBC-Datenbank herstellen.
        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+ dbPort+"/"+dbName+"?");
    } catch (ClassNotFoundException e) {
        System.out.println("Treiber nicht gefunden");
    } catch (SQLException e) {
        System.out.println("Verbindung nicht moglich");
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }
  }

private static Connection getInstance(){
    if(con == null)
        new MySQLConnection();
    return con;
}
 
  //Gebe Tabelle in die Konsole aus
  public static void printNameList(){
      con = getInstance();
 
      if(con != null){
      // Abfrage-Statement erzeugen.
      Statement query;
      try {
          query = con.createStatement();
 
          // Tabelle anzeigen
          String sql =
                "SELECT e-mail, username, password, age, gender, country, isLoggedIn FROM tbl_User";
          ResultSet result = query.executeQuery(sql);
 
        // Ergebnisstabelle durchforsten
          while (result.next()) {
          String e-mail = result.getString("e-mail");
          String username = result.getString("username");
          String password = result.getString("password");
          String age = result.getString("age");
          String gender = result.getString("gender");
          String country = result.getString("country");
          String isLoggedIn = result.getString("isLoggedIn");
          String info = e-mail + ", " + username + ", " + password + ", " + age + ", " + gender + ", " + country + ", " isLoggedIn;
         
          System.out.println(info);
          }
      } catch (SQLException e) {
    	  e.printStackTrace();
      }
    }
  }
}
      }