package com.sirma.footballMatches.service;

import java.util.List;
import java.util.Objects;

import com.sirma.footballMatches.model.dto.PlayerPairTime;
import com.sirma.footballMatches.model.dto.RecordDTO;

import com.sirma.footballMatches.model.entity.Records;

public interface RecordService {
    public void saveAllRecords(List<Records> playerRecords);
    public List<RecordDTO> getAllRecords();
    public List<PlayerPairTime> findMutualTime(List<Object[]> results);
}
