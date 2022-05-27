package android.project.standardarchitecture.ROOM;

import android.app.Application;
import android.project.standardarchitecture.ROOM.ENTITY.User;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UsersDao mUsersDao;
    private LiveData<List<User>> getAllUsers;
    private LiveData<List<LoginAccount>> getLoginAccount;
    private LiveData<List<User>> getAccountSearched;

    public UserRepository(Application application){
        MyDatabase myDatabase = MyDatabase.getInstanceDatabase(application);
        mUsersDao = myDatabase.usersDao();
        getAllUsers = mUsersDao.getAllUsers();
        getLoginAccount = mUsersDao.getLoginAccount();
    }

    public LiveData<List<User>> getGetAllUsers() {
        return getAllUsers;
    }

    public LiveData<List<LoginAccount>> getGetLoginAccount() {
        return getLoginAccount;
    }

    public LiveData<List<User>> getGetAccountSearched() {
        return getAccountSearched;
    }

    public void insertUser(User user){
        MyDatabase.databaseWriteExecutor.execute(()-> mUsersDao.insertUser(user));
    }

    public void deleteUser(User user){
        MyDatabase.databaseWriteExecutor.execute(()-> mUsersDao.deleteUser(user));
    }
}
