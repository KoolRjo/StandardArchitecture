package android.project.standardarchitecture.ROOM.ENTITY;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User{
    @PrimaryKey
    @ColumnInfo(name = "UserId")
    private int UserId;
    @ColumnInfo(name = "UserName")
    private String UserName;
    @ColumnInfo(name = "UserAccount")
    private String UserAccount;
    @ColumnInfo(name = "UserPass")
    private String UserPass;

    public User() {
    }

    public User(int userId, @NonNull String userName, @NonNull String userAccount, @NonNull String userPass) {
        UserId = userId;
        UserName = userName;
        UserAccount = userAccount;
        UserPass = userPass;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }
}
