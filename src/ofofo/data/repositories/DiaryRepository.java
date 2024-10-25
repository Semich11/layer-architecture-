package ofofo.data.repositories;

import ofofo.data.models.Diary;

public interface DiaryRepository {
    void save(Diary diary);

    int count();
}
