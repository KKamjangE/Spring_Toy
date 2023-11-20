package com.toy.web.service;

import com.toy.web.dto.CenterRequest;

import java.util.List;

public interface CenterService {
    List<CenterRequest> findAllCenters(String userName);
    void saveCenter(CenterRequest centerRequest);
    CenterRequest deleteCenter(String userName, int id);
    CenterRequest findByUserNameAndId(String userName, int id);
}
