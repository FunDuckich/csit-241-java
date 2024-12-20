package org.knit.lab11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FileService {

    private final FileDAOImpl fileDAO;

    public FileService(FileDAOImpl fileDAO) {
        this.fileDAO = fileDAO;
    }

    public void saveFilesFromDirectory(String directoryPath) throws SQLException, IOException {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Неверный путь к папке!");
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("Ошибка при получении файлов из папки!");
        }

        for (File file : files) {
            if (file.isFile() && file.length() < 10 * 1024 * 1024) {
                fileDAO.save(file);
            }
        }
    }

    public void ShowFiles() throws SQLException {
        List<FileBin> files = fileDAO.getAllFiles();
        for (FileBin file : files) {
            System.out.println(file);
        }
    }

    public void saveFileLocally(int id, String savePath) throws SQLException, IOException {
        FileBin file = fileDAO.getFileById(id);
        if (file == null) {
            throw new IllegalArgumentException("Файл с таким ID не найден.");
        } else {
            File directory = new File(savePath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = savePath + "/" + file.getFileName();
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(file.getFileBinary());
            }
        }
    }
}
