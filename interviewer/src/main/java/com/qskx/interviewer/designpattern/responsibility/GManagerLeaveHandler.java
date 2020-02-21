package com.qskx.interviewer.designpattern.responsibility;

/**
 * @ProjectName: springboot-advance
 * @ClassName: GManagerLeaveHandler
 * @Author: cg
 * @CreateDate: 2020-02-20 17:59
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class GManagerLeaveHandler extends AbstractLeaveHandler {

    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() > this.middle && request.getLeaveDays() <= this.max){
            System.out.println("总经理:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝！");
        }
    }
}
