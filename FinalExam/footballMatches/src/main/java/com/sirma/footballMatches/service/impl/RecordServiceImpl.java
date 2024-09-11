package com.sirma.footballMatches.service.impl;

import com.sirma.footballMatches.model.dto.PlayerPairTime;
import com.sirma.footballMatches.model.dto.RecordDTO;
import com.sirma.footballMatches.model.entity.Records;
import com.sirma.footballMatches.repository.RecordRepository;
import com.sirma.footballMatches.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public void saveAllRecords(List<Records> playerRecords) {
        recordRepository.saveAll(playerRecords);
    }

    @Override
    public List<RecordDTO> getAllRecords() {
        return recordRepository.findAll().stream().map(RecordServiceImpl::map).collect(Collectors.toList());
    }


    @Override
    public List<PlayerPairTime> findMutualTime(List<Object[]> results) {
        return null;
    }

    private static RecordDTO map(Records records) {
        return new RecordDTO(
                records.getId(),
                records.getPlayer().getId(),
                records.getMatch().getId(),
                records.getFromMinutes(),
                records.getToMinutes());
    }


}
