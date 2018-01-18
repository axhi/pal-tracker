package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = timeEntries.keySet()
                .stream()
                .mapToInt(Math::toIntExact)
                .max().orElse(0) + 1;

        TimeEntry timeEntryEntity = new TimeEntry(id, timeEntry);
        timeEntries.put(id, timeEntryEntity);

        return timeEntryEntity;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry updatedEntry) {
        TimeEntry currentTimeEntry = find(id);
        if (currentTimeEntry == null) {
            return null;
        }

        TimeEntry timeEntry = new TimeEntry(id, updatedEntry);
        timeEntries.put(id, timeEntry);

        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }
}
