package android.project.standardarchitecture.ROOM;

import android.app.Application;
import android.project.standardarchitecture.ROOM.ENTITY.User;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    private UserRepository mRepository;
    private LiveData<List<User>> getAllUsers;
    private LiveData<List<LoginAccount>> getLoginAccount;
    private LiveData<List<User>> getAccountSearched;

    public DataViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        getAllUsers = mRepository.getGetAllUsers();
        getLoginAccount = mRepository.getGetLoginAccount();
        getAccountSearched = mRepository.getGetAccountSearched();
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
        mRepository.insertUser(user);
    }

    public void deleteUser(User user){
        mRepository.deleteUser(user);
    }
}
