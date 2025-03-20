public class InputValidator {
    public static boolean isValidCoordinate(String input, int gridSize) {
        if (input.length() < 2 || input.length() > 3) {
            return false;
        }
        char colChar = input.charAt(0);
        boolean isValidCol = (colChar >= 'A' && colChar < 'A' + gridSize);
        String rowStr = input.substring(1);
        try {
            int row = Integer.parseInt(rowStr);
            boolean isValidRow = (row >= 0 && row < gridSize);
            return isValidCol && isValidRow;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
