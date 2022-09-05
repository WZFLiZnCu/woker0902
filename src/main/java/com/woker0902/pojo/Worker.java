package com.woker0902.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("worker")
public class Worker {
    @TableId("wid")
    private Integer wid;
    private String wname;
    private String wsex;
    private Integer wtel;
    private Integer deptId;
    @TableField(exist = false)
    private Department department;

}
