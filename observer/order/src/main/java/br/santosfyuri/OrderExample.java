package br.santosfyuri;

import br.santosfyuri.service.OrderJob;
import br.santosfyuri.service.OrderXML;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class OrderExample {

    public static void main(String[] args) throws Exception  {
        OrderXML orderXML = new OrderXML();
        List<Order> newOrders = orderXML.getFromXML("order.xml");

        Notifier<Order> notifier = new OrderNotifier();
        Listener invoicingListener = new InvoicingListener(notifier);
        Listener transportListener = new TransportListener(notifier);

        JobDataMap jobDataMap = new JobDataMap();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("newOrders", newOrders);
        jobDataMap.put("notifier", notifier);

        JobDetail job = newJob(OrderJob.class)
                .setJobData(jobDataMap)
                .withIdentity("orderJob", "OrderGroup")
                .build();

        CronTrigger trigger = newTrigger()
                .withIdentity("triggerOrder", "groupOrder")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(220000);

        scheduler.shutdown(true);
    }
}
