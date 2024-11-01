package ofofo.data.repositories;

import ofofo.data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private List<Entry> entries = new ArrayList<Entry>();
    private int count;

    @Override
    public void save(Entry entry) {
        entries.add(entry);
        count++;
    }

    @Override
    public void delete(Entry entry) {

    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Entry findById(int id) {
        return null;
    }

    @Override
    public void update(Entry entry) {

    }
}
