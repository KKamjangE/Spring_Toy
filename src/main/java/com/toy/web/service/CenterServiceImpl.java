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
    public List<CenterRequest> findAllCenters(String userName) {
        return centerRepository.findAllByUserName(userName);
    }

    @Override
    public void saveCenter(CenterRequest centerRequest) {
        centerRepository.save(centerRequest);
    }

    @Override
    public CenterRequest deleteCenter(String userName, String id) {
        return centerRepository.deleteByUserNameAndId(userName, id);
    }

    @Override
    public CenterRequest findByUserNameAndId(String userName, String id) {
        return centerRepository.findByUserNameAndId(userName, id);
    }
}
