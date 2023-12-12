package Service;

public class Launcher {
    public Launcher() {
    }

    public void launcher(String line, String path) {
        InputString inStr = new InputString();
        String[] lineElements = inStr.getItems(line, " ");
        try {
            if (inStr.fullFio(lineElements) & inStr.lenCountItem(inStr.countElements(lineElements)) & inStr.isDate(lineElements[3]) & inStr.parseLong(lineElements[4]) & inStr.gender(lineElements[5])) {
                FileCreator creator = new FileCreator();
                creator.fileCreator(path, lineElements);
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.err.println("Пожалуйста проверьте вводимые данные и повторите ввод заново.");
        }
    }
}
