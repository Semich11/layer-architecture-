package ofofo.data.services;

import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepositoryImpl;

public class DiaryServiceImpl implements DiaryService {
    private DiaryRepositoryImpl diaryRepository = new DiaryRepositoryImpl();
    private int numberOfUsers;
    private int numberOfLoginUsers;


    @Override
    public void register(String username, String password) {
        Diary diary = diaryRepository.findById(username);
        if (diary == null) {
            diaryRepository.save(new Diary(username, password));
            numberOfUsers++;
        }
        else throw new IllegalArgumentException("username already exists");
    }

    @Override
    public void login(String username, String password) {
        Diary diary = diaryRepository.findById(username);
        if (diary == null) throw new IllegalArgumentException("username or password is incorrect");
        if (diary.getPassword().equals(password)) numberOfLoginUsers++;
        else throw new IllegalArgumentException("username or password is incorrect");
    }

    @Override
    public int count() {
        return numberOfUsers;
    }

    public int userLoginCount() {
        return numberOfLoginUsers;
    }
}
