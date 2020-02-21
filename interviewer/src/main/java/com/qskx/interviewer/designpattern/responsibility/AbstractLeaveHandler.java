package com.qskx.interviewer.designpattern.responsibility;

/**
 * @ProjectName: springboot-advance
 * @ClassName: AbstractLeaveHandler
 * @Author: cg
 * @CreateDate: 2020-02-20 14:32
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public abstract class AbstractLeaveHandler {
    /**
     * 直接主管审批处理的请假天数
     */
    protected static final Integer min = 1;
    /**
     * 部门经理处理的请假天数
     */
    protected static final Integer middle = 3;
    /**
     * 总经理处理的请假天数
     */
    protected static final Integer max = 30;

    protected String handlerName;

    protected AbstractLeaveHandler nextHandler;

    protected void setNextHandler(AbstractLeaveHandler handler) {
        this.nextHandler = handler;
    }

    protected abstract void handlerRequest(LeaveRequest request);

}
