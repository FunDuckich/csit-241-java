package org.knit.lab11;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FileDAO {
    void save(File file) throws SQLException, IOException;

    List<FileBin> getAllFiles() throws SQLException;

    FileBin getFileById(int id) throws SQLException;
}
