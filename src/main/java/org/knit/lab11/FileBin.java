package org.knit.lab11;

public class FileBin {
    private final int id;
    private final String fileName;
    private byte[] fileBinary;

    public FileBin(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public FileBin(int id, String fileName, byte[] fileBinary) {
        this.id = id;
        this.fileName = fileName;
        this.fileBinary = fileBinary;
    }


    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFileBinary() {
        return fileBinary;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Имя файла: " + getFileName();
    }
}

