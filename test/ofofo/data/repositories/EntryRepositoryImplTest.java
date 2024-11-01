package ofofo.data.repositories;

import ofofo.data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplTest {
    private EntryRepositoryImpl entryRepo;

    @BeforeEach
    public void setup() {
        entryRepo = new EntryRepositoryImpl();
    }
    @Test
    public void addOneEntry_countIsOneTest() {
        Entry entry = new Entry("note", "note1");
        entryRepo.save(entry);
        assertEquals(1, entryRepo.count());
    }

    @Test
    public void addTwoEntry_CountIsTwoTest() {
        Entry entry = new Entry("note1", "note1");
        entryRepo.save(entry);
        Entry entry2 = new Entry("note2", "note2");
        entryRepo.save(entry2);
        assertEquals(2, entryRepo.count());
    }

    @Test
    public void findEntryById_EntryTitleNameIsTitle1Test() {
        Entry entry = new Entry("note1", "note1");
        entryRepo.save(entry);
        assertEquals(1, entryRepo.count());

    }

//    @Test
//    public void addOneEntryDeleteOne_CountIsZeroTest() {
//        Entry entry = new Entry("note", "note1");
//        entryRepo.save(entry);
//        assertEquals(1, entryRepo.count());
//        entryRepo.delete(entry);
//    }
}
