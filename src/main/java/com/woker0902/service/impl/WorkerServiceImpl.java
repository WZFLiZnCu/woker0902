package com.woker0902.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woker0902.mapper.DepartmentMapper;
import com.woker0902.mapper.WorkerMapper;
import com.woker0902.pojo.Worker;
import com.woker0902.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper wm;
    @Autowired
    private DepartmentMapper dm;


    @Override
    public IPage<Worker> getAllWorkerByPage(Integer pageno) {
        int no = pageno != null ? pageno : 1;
        IPage<Worker> iPage = new Page<>(no, 5);
        IPage<Worker> info = wm.selectPage(iPage, null);
        List<Worker> list = info.getRecords();
        for (Worker w : list) {
           w.setDepartment(dm.selectById(w.getDeptId()));
        }
        return info;
    }

    @Override
    public List<Worker> getAllWorker() {
        return wm.selectList(null);
    }

    @Override
    public List<Worker> getWorkerByDeptId(Integer deptId) {
        QueryWrapper qw =new QueryWrapper();
        qw.eq("deptId",deptId);
        return wm.selectList(qw);
    }

    @Override
    public int saveWorker(Worker worker) {
        if(wm.selectById(worker.getWid())==null){
            return wm.insert(worker);
        }else {
        return 0;
        }
    }

    @Override
    public int deleWorker(Integer wid) {
        return wm.deleteById(wid);
    }

    @Override
    public int updateWorker(Worker worker) {
        return wm.updateById(worker);
    }

    @Override
    public Worker getWorkerByid(Integer wid) {
        return wm.selectById(wid);
    }
}
