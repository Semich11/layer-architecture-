package ofofo.data.services;


public interface DiaryService {
    void register(String username, String password);
    void login(String username, String password);
    int count();
    int userLoginCount();
}