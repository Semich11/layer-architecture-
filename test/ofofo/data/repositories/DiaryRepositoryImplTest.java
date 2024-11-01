package ofofo.data.repositories;

import ofofo.data.models.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    private DiaryRepositoryImpl repo;

    @BeforeEach
    public void setup() {
        repo = new DiaryRepositoryImpl();
    }

    @Test
    public void saveDiary_countIsOneTest() {
        Diary diary = new Diary("username", "password");
        assertEquals(0, repo.count());
        repo.save(diary);
        assertEquals(1, repo.count());
    }

    @Test
    public void saveDiary_findDiaryByIdTest() {
        Diary diary = new Diary("username", "password");
        assertEquals(0, repo.count());
        repo.save(diary);
        assertEquals(1, repo.count());
        Diary savedDiary = repo.findById("username");
        assertEquals("username", savedDiary.getUsername());
    }

    @Test
    public void diaryIsEmptyTest() {
        assertTrue(repo.isEmpty());
        assertEquals(0, repo.count());
    }

    @Test
    public void addOneDiary_deleteOneDiaryDiaryIsEmptyTest() {
        Diary diary = new Diary("username", "password");
        repo.save(diary);
        assertEquals(1, repo.count());
        Diary savedDiary = repo.findById("username");
        repo.delete(savedDiary);
        assertTrue(repo.isEmpty());

    }

    @Test
    public void addTwoDiaryDeleteOneDiary_diaryIsNotEmptyTest() {
        Diary diary = new Diary("username", "password");
        repo.save(diary);
        Diary secondDiary = new Diary("username2", "password");
        repo.save(diary);
        assertEquals(2, repo.count());
        assertFalse(repo.isEmpty());
        repo.delete(secondDiary);
        assertFalse(repo.isEmpty());
        assertEquals(1, repo.count());

    }
}
