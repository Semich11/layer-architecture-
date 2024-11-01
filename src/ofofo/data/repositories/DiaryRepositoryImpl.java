package ofofo.data.repositories;

import ofofo.data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<Diary>();


    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(Diary diary) {


    }

    @Override
    public void deleteAll() {
        diaries.clear();

    }

    @Override
    public void deleteById(String id) {
        for(int index = 0; index < diaries.size(); index++) {
            if(diaries.get(index).getUserName().equals(id)) {
                diaries.remove(diaries.get(index));
            }
        }
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public Diary findById(String id) {
        return null;
    }

    @Override
    public void save(Diary diary) {
        if(diary.getUserName()  == null || diary.getPassword() == null) throw new IllegalArgumentException("Diary is null");
        diaries.add(diary);
    }
}

