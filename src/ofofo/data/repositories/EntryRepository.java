package ofofo.data.repositories;

import ofofo.data.models.Entry;

public interface EntryRepository {
    void save(Entry entry);
    void delete(Entry entry);
    int count();
    Entry findById(int id);
    void update(Entry entry);
}
