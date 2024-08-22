package ObjectPoolDesignPattern;

public class Main {
    public static void main(String[] args) {
        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();

        DBConnection c1 = dbConnectionPoolManager.getDBConnection();
        DBConnection c2 = dbConnectionPoolManager.getDBConnection();
        DBConnection c3 = dbConnectionPoolManager.getDBConnection();
        DBConnection c4 = dbConnectionPoolManager.getDBConnection();
        DBConnection c5 = dbConnectionPoolManager.getDBConnection();
        DBConnection c6 = dbConnectionPoolManager.getDBConnection();
        DBConnection c7 = dbConnectionPoolManager.getDBConnection();

        dbConnectionPoolManager.releaseDBConnection(c6);
    }
}
