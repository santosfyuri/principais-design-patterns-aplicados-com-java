package br.santosfyuri.service;

import br.santosfyuri.Notifier;
import br.santosfyuri.Order;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public class OrderJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        List<Order> newOrders = (List<Order>) jobDataMap.get("newOrders");
        Notifier<Order> notifier = (Notifier<Order>) jobDataMap.get("notifier");
        notifier.setOrders(newOrders);
    }
}
