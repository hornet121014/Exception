package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public FileCreator() {
    }
    public void fileCreator(String path, String[] item){
        try{
            Boolean flag = false;
            String pathfile = path+item[0]+".txt";
            File file = new File(pathfile);
            if (file.isFile()){flag = true;}
            FileWriter writer = new FileWriter(file,true);
            writer.append("<");
            writer.append(item[0]);
            writer.append(">");
            writer.append("<");
            writer.append(item[1]);
            writer.append(">");
            writer.append("<");
            writer.append(item[2]);
            writer.append(">");
            writer.append("<");
            writer.append(item[3]);
            writer.append(">");
            writer.append(" ");
            writer.append("<");
            writer.append(item[4]);
            writer.append(">");
            writer.append("<");
            writer.append(item[5]);
            writer.append(">");
            writer.append("\n");
            writer.close();
            if (flag){
                System.out.println("Файл " + pathfile + " успешно изменен.");
            } else{
                System.out.println("Файл " + pathfile + " успешно записан.");
            }
        }catch (IOException e){
            System.err.println("Ошибка записи в файл.\n");
            e.printStackTrace();
        }
    }
}
