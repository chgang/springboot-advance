package com.qskx.interviewer.designpattern.responsibility;

/**
 * @ProjectName: springboot-advance
 * @ClassName: DeptManagerLeaveHandler
 * @Author: cg
 * @CreateDate: 2020-02-20 17:57
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {
    public DeptManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() >this.min && request.getLeaveDays() <= this.middle){
            System.out.println("部门经理:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝！");
        }
    }
}
