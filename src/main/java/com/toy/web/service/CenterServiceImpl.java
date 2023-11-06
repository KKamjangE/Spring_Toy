package com.toy.web.service;

import com.toy.web.dto.CenterRequest;
import com.toy.web.repository.CenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService{

    private final CenterRepository centerRepository;

    public CenterServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    @Override
    public List<CenterRequest> findAllCenters() {
        return centerRepository.findAll();
    }

    @Override
    public CenterRequest saveCenter(CenterRequest centerRequest) {
        return centerRepository.save(centerRequest);
    }

    @Override
    public void deleteCenter(String id) {
        centerRepository.deleteById(id);
    }
}
