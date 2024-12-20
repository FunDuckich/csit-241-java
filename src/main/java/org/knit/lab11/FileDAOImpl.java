package org.knit.lab11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {
    private Connection connection;

    public FileDAOImpl() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void save(File file) throws SQLException, IOException {
        String query = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                ps.setBytes(2, fileBytes);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<FileBin> getAllFiles() {
        List<FileBin> files = new ArrayList<>();
        String query = "SELECT id, file_name FROM files";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("file_name");
                files.add(new FileBin(id, fileName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return files;
    }

    @Override
    public FileBin getFileById(int id) throws SQLException {
        String sql = "SELECT file_name, file_binary FROM files WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    String fileName = resultSet.getString("file_name");
                    byte[] fileBinary = resultSet.getBytes("file_binary");
                    return new FileBin(id, fileName, fileBinary);
                }
            }
        }

        return null;
    }
}
