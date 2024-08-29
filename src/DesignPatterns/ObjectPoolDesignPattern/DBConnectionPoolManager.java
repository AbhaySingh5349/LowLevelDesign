package DesignPatterns.ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private List<DBConnection> freeConnections = new ArrayList<>();
    private List<DBConnection> occupiedConnections = new ArrayList<>();
    private static volatile DBConnectionPoolManager instance = null;
    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;

    private DBConnectionPoolManager(){
        for(int i=0;i<INITIAL_POOL_SIZE;i++){
            freeConnections.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance(){
        if(instance == null){
            synchronized (DBConnectionPoolManager.class){
                if(instance == null){
                    instance = new DBConnectionPoolManager();
                }
            }
        }
        return instance;
    }

    public synchronized DBConnection getDBConnection(){
        if(freeConnections.isEmpty() && occupiedConnections.size() < MAX_POOL_SIZE){
            System.out.println("adding extra connection");
            freeConnections.add(new DBConnection());
        } else if (freeConnections.isEmpty() && occupiedConnections.size() == MAX_POOL_SIZE) {
            return null;
        }

        DBConnection connection = freeConnections.remove(freeConnections.size()-1);
        occupiedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseDBConnection(DBConnection connection){
        if(connection != null){
            occupiedConnections.remove(connection);
            freeConnections.add(connection);
        }
    }
}
