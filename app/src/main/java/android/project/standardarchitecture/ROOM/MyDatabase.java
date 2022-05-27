package android.project.standardarchitecture.ROOM;

import static android.project.standardarchitecture.ROOM.MyDatabase.Database_Version;

import android.content.Context;
import android.project.standardarchitecture.ROOM.ENTITY.User;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class},version = Database_Version)
public abstract class MyDatabase extends RoomDatabase {
    public static final int Database_Version = 1;
    public static final String Database_Name = "MyDatabase";
    public abstract UsersDao usersDao();
    private static volatile MyDatabase instanceDatabase;
    private static  int numberOfThread = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(numberOfThread);

    public static MyDatabase getInstanceDatabase(final Context context){
        if(instanceDatabase == null){
            synchronized (MyDatabase.class){
                if(instanceDatabase == null){
                    instanceDatabase =  Room.databaseBuilder(context.getApplicationContext(),
                                        MyDatabase.class,Database_Name)
                                        //.addCallback(mRoomDatabase)
                                        .build();
                }
            }
        }
        return instanceDatabase;
    }

    private static RoomDatabase.Callback mRoomDatabase = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(()->{
                UsersDao dao = instanceDatabase.usersDao();
                dao.deleteAll();
            });
        }
    };
}
