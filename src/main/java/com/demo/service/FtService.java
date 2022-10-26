package com.demo.service;

import com.demo.dto.FtDTO;

public interface FtService {
    int save(FtDTO ftDTO);

    int delete(String id);

}
