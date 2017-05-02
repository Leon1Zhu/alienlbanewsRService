package com.alienlab.service.serviceImpl;

import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.repository.AlinewsPaperTypeRepository;
import com.alienlab.service.AlinewsPaperTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Service
public class AlinewsPaperTypeServiceImpl implements AlinewsPaperTypeService{
    @Autowired
    private AlinewsPaperTypeRepository alinewsPaperTypeRepository;
    @Override
    public List<AlinewsPaperType> getAllType() throws Exception{
        List<AlinewsPaperType> alinewsPaperTypes = alinewsPaperTypeRepository.findAll();
        if(alinewsPaperTypes==null){
            throw new  Exception("暂无报刊种类");
        }
        return alinewsPaperTypes;
    }
}
