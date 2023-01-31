package alfred.command;

import alfred.storage.Storage;
import alfred.task.TaskList;
import alfred.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder command = new StringBuilder("Here are your pending tasks: \n");
        if (tasks.isEmpty()) {
            ui.displayCommand("Woohoo! You have no pending tasks\n");
            return;
        }
        String itemList = tasks.getList();
        ui.displayCommand(command.append(itemList).toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
