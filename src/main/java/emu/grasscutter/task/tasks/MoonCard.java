package emu.grasscutter.task.tasks;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.task.Task;
import emu.grasscutter.task.TaskHandler;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Task(taskName = "MoonCard", taskCronExpression = "0 0 0 * * ?", triggerName = "MoonCardTrigger")
// taskCronExpression: Fixed time period: 0:0:0 every day (twenty-four hour system)
public class MoonCard extends TaskHandler {
    @Override
    public synchronized void execute(JobExecutionContext context) throws JobExecutionException {
        Grasscutter.getGameServer().getPlayers().forEach((uid, player) -> {
            if (player.isOnline()) {
                if (player.inMoonCard()) {
                    player.getTodayMoonCard();
                }
            }
        });
    }
}
