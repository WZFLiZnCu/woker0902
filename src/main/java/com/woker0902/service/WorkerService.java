package com.woker0902.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woker0902.pojo.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerService {

    public IPage<Worker> getAllWorkerByPage(Integer pageno);
    public List<Worker> getAllWorker();
    public List<Worker> getWorkerByDeptId(Integer deptId);
    public int saveWorker(Worker worker);
    public int deleWorker(Integer wid);
    public int updateWorker(Worker worker);
    public Worker getWorkerByid(Integer wid);


}
