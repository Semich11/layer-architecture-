package ofofo.data.repositories;

import ofofo.data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
//    private static DiaryRepositoryImpl instance;
    private List<Diary> diaries = new ArrayList<>();
    private  int numberOfEntries;

    @Override
    public void save(Diary diary) {
        diaries.add(diary);
        numberOfEntries++;
    }

    @Override
    public int count() {
        return numberOfEntries;
    }


    public Diary findById(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }
        return null;
    }
}
