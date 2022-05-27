package android.project.standardarchitecture.ROOM;

import android.project.standardarchitecture.ROOM.ENTITY.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User... users);
    @Insert
    void insertListUser(List<User> userList);
    @Update
    void updateUserList(List<User> userList);
    @Delete
    void deleteUser(User...users);
    @Query("DELETE FROM users")
    void deleteAll();
    @Query("SELECT*FROM users")
    LiveData<List<User>> getAllUsers();
    @Query("SELECT users.UserAccount AS Uaccount,users.UserPass AS Upass FROM users")
    LiveData<List<LoginAccount>> getLoginAccount();
    @Query("SELECT * FROM users WHERE UserAccount LIKE :searchedName")
    LiveData<List<User>> getAccountSearched(String searchedName);
    @Query("SELECT * FROM users WHERE UserAccount in (:nameList)")
    LiveData<List<User>> getAccountInListName(List<String> nameList);
}
class LoginAccount{
    public String Uaccount;
    public String Upass;
}

