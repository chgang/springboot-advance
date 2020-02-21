package com.qskx.interviewer.designpattern.responsibility;

/**
 * @ProjectName: springboot-advance
 * @ClassName: DirectLeaderLeaveHandler
 * @Author: cg
 * @CreateDate: 2020-02-20 17:56
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() <= this.min){
            System.out.println("直接主管:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝！");
        }

    }
}
