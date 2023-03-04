package command;

import io.InputReceiver;

import java.util.HashMap;

/**
 * Class to check the command exists and execute it.
 */
public class CommandExecutor {
    private HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Creates the CommandExecutor with given InputReceiver.
     * @param ir InputReceiver to receive user or file input
     */
    public CommandExecutor(InputReceiver ir) {
        FileData data = new FileData(ir);
        Command[] commandArray = new Command[] {
                new HelpCommand(data),
                new InfoCommand(data),
                new ShowCommand(data),
                new AddCommand(data),
                new UpdateCommand(data),
                new RemoveByIdCommand(data),
                new ClearCommand(data),
                new SaveCommand(data),
                new ExecuteScriptCommand(data), // so tasty
                new ExitCommand(data),
                new InsertAtCommand(data),
                new AddIfMinCommand(data),
                new RemoveGreaterCommand(data),
                new AverageOfMinimalPointCommand(data),
                new MinByIdCommand(data),
                new PrintFieldAscendingMinimalPointCommand(data)
        };
        for (Command command : commandArray) {
            register(command.toString(), command);
        }
    }

    /**
     * Adds command to the hashmap.
     * @param key Name of the command
     * @param command Command object
     */
    private void register(String key, Command command) {
        commandMap.put(key, command);
    }

    /**
     * Checks if the command is entered correctly and executes it
     * @param commandName Name of the command
     * @param args Arguments passed to the command
     * @return 0 if command executed correctly; 1 if an error occurred while executing;
     * 2 if script was executed and recursion found
     */
    public int execute(String commandName, String args) {
        int execCode;
        Command command = commandMap.get(commandName);
        if (command == null) {
            execCode = 1;
            System.out.println("Команды " + commandName + " не существует, повторите ввод (help - справка по командам)");
        }
        else {
            execCode = command.execute(args);
        }
        return execCode;
    }
}
