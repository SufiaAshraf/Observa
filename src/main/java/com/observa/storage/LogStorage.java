package com.observa.storage;

import com.observa.model.LogMessage;

import java.util.List;

public interface LogStorage {
    void store(LogMessage log);
    List<LogMessage> getAll();
    List<LogMessage> getAllByService(String Service);
    List<LogMessage> getAllByLevel(String level);
    List<LogMessage> getFiltered(String Service, String level);
}
