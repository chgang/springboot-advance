package com.qskx.interviewer.designpattern.responsibility;

/**
 * @ProjectName: springboot-advance
 * @ClassName: ResponsibilityTest
 * @Author: cg
 * @CreateDate: 2020-02-20 18:00
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class ResponsibilityTest {

    public static void main(String[] args) {
        LeaveRequest request = LeaveRequest.builder().leaveDays(20).name("小明").build();


        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);


    }
}
