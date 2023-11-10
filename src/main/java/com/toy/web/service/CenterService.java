package com.toy.web.service;

import com.toy.web.dto.CenterRequest;

import java.util.List;

public interface CenterService {
    List<CenterRequest> findAllCenters();
    void saveCenter(CenterRequest centerRequest);
    void deleteCenter(String id);
}
