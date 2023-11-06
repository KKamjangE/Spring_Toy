package com.toy.web.service;

import com.toy.web.dto.CenterRequest;

import java.util.List;

public interface CenterService {
    List<CenterRequest> findAllCenters();
    CenterRequest saveCenter(CenterRequest centerRequest);
    void deleteCenter(String id);
}
