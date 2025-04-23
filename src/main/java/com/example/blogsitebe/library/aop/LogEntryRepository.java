package com.example.blogsitebe.library.aop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry,String> {
}
