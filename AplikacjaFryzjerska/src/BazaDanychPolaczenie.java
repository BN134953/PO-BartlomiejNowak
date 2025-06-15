import java.sql.*;

//Klasa do obsługi połączenia z bazą danych MySQL
public class BazaDanychPolaczenie {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AplikacjaFryzjerska1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection;
    private static Statement statement;

    //Metoda do nawiązywania połączenia z bazą danych
    public static Connection ConnectToDataBase(){

        try{
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    //Wykonuje zapytanie SELECT i zwraca wynik ResultSet
    public static ResultSet Zapytanie(String sql){
        try{
            if(connection == null){
                connection = ConnectToDataBase();
                statement = connection.createStatement();
            }

            return statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Wykonuje zapytanie INSERT, UPDATE lub DELETE
    public static void Polecenie(String sql){
        try{
            if(connection == null){
                connection = ConnectToDataBase();
                statement = connection.createStatement();
            }

            statement.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
