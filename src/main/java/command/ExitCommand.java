package command;

import exceptions.WrongCommandFormatException;

/**
 * Class for command exit.
 */
class ExitCommand implements Command {
    private FileData data;

    /**
     * Creates the ExitCommand object with implementation from FileData class.
     * @param data FileData object
     */
    public ExitCommand(FileData data) {
        this.data = data;
    }

    /**
     * Checks if the correct number of arguments is passed to the command and executes its implementation from FileData.
     * @param args Arguments passed to the command.
     * @return 0 if command executed correctly;
     * 1 if an error occurred while executing or there is wrong amount of arguments
     */
    @Override
    public int execute(String args) {
        int execCode;
        try {
            String[] argsArray = args.split("\\s+");
            if (argsArray.length != 0) throw new WrongCommandFormatException();
            execCode = data.exit();
        } catch (WrongCommandFormatException e) {
            execCode = 1;
            System.out.println("Использование: exit");
        }
        return execCode;
    }

    /**
     * Gets string representation of the command.
     * @return string representation of the command.
     */
    @Override
    public String toString() {
        return "exit";
    }
}
