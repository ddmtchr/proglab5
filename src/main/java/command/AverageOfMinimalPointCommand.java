package command;

import exceptions.WrongCommandFormatException;

/**
 * Class for command average_of_minimal_point.
 */
class AverageOfMinimalPointCommand implements Command {
    private FileData data;

    /**
     * Creates the AverageOfMinimalPointCommand object with implementation from FileData class.
     * @param data FileData object
     */
    public AverageOfMinimalPointCommand(FileData data) {
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
            execCode = data.averageOfMinimalPoint();
        } catch (WrongCommandFormatException e) {
            execCode = 1;
            System.out.println("Использование: average_of_minimal_point");
        }
        return execCode;
    }

    /**
     * Gets string representation of the command.
     * @return string representation of the command.
     */
    @Override
    public String toString() {
        return "average_of_minimal_point";
    }
}
