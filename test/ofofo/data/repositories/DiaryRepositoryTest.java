package ofofo.data.repositories;

import ofofo.data.models.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryRepositoryTest {
    private DiaryRepositoryImpl repo;
    @BeforeEach
    public void setup() {
        repo = new DiaryRepositoryImpl();
    }

    @Test
    public void saveDiary_countIsOneTest() {
        Diary diary = new Diary();
        assertEquals(0, repo.count());
        repo.save(diary);
        assertEquals(1, repo.count());
    }

    @Test
    public void saveDiary_findDiaryByIdTest() {
        Diary diary = new Diary();
        diary.setUsername("username");
        assertEquals(0, repo.count());
        repo.save(diary);
        assertEquals(1, repo.count());
        Diary savedDiary = repo.findById("username");
        assertEquals("username", savedDiary.getUsername());
    }
}
