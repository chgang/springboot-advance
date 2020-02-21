package com.qskx.interviewer.designpattern.responsibility;

import lombok.Builder;
import lombok.Data;

/**
 * @ProjectName: springboot-advance
 * @ClassName: LeaveRequest
 * @Author: cg
 * @CreateDate: 2020-02-20 14:09
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@Data
@Builder
public class LeaveRequest {
    /**
     * 请假天数
     */
    private Integer leaveDays;
    /**
     * 姓名
     */
    private String name;
}
