package com.woker0902.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woker0902.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {
    public List<Worker> getAllWorkerByPage(@Param("index")int startIndex, @Param("count")int count);
}
