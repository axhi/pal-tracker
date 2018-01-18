package io.pivotal.pal.tracker.timesheets;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(Long id);
    TimeEntry update(Long id, TimeEntry updatedEntry);
    List<TimeEntry> list();
    void delete(Long id);
}
