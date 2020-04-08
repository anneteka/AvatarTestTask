package main.controller.parser;

import main.controller.parser.dto.FileDTO;
import main.controller.parser.dto.FolderDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserDTOTest {

    @Test
    void jacksonSimple() throws IOException {
        FolderDTO folder = new FolderDTO();
        folder.setPath("/root");
        folder.setName("root");

        ParserDTO parser = new ParserDTO();
        FolderDTO parserFolder = parser.parse("{\"name\": \"root\"}");

        assertEquals(folder, parserFolder);
    }

    @Test
    void jacksonMedium() throws IOException {
        FolderDTO folder = new FolderDTO();
        folder.setPath("/root");
        folder.setName("root");
        FileDTO file1 = new FileDTO();
        file1.setName("file1.txt");
        file1.setMimeType("file/txt");
        file1.setSize(100);
        ArrayList<FileDTO> files = new ArrayList<>();
        files.add(file1);
        folder.setFiles(files);
        ParserDTO parser = new ParserDTO();
        FolderDTO parserFolder = parser.parse("{" +
                "\"name\": \"root\", " +
                "\"files\": [" +
                "{\"name\":\"file1.txt\"," +
                "\"mimeType\":\"file/txt\"," +
                "\"size\":100}]}");
        assertEquals(folder, parserFolder);

    }

    @Test
    void jacksonHard() throws IOException {
        FolderDTO folder = new FolderDTO();
        folder.setPath("/root");
        folder.setName("root");
        FileDTO file1 = new FileDTO();
        file1.setName("file1.txt");
        file1.setMimeType("file/txt");
        file1.setSize(100);
        FileDTO file2 = new FileDTO();
        file2.setName("file2.png");
        file2.setMimeType("image/png");
        file2.setSize(1000);
        ArrayList<FileDTO> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);

        FolderDTO folder2 = new FolderDTO();
        folder2.setPath("/root/folder2");
        folder2.setName("folder2");
        FileDTO file3 = new FileDTO();
        file3.setName("file3.png");
        file3.setMimeType("image/png");
        file3.setSize(1050);
        ArrayList<FileDTO> files2 = new ArrayList<>();
        files2.add(file3);
        folder2.setFiles(files2);

        ArrayList<FolderDTO> folders = new ArrayList<>();
        folders.add(folder2);

        folder.setFolders(folders);
        folder.setFiles(files);
        ParserDTO parser = new ParserDTO();
        FolderDTO parserFolder = parser.parse(
                "{" +
                "\"name\": \"root\", " +

                "\"files\": [" +
                "{\"name\":\"file1.txt\"," +
                "\"mimeType\":\"file/txt\"," +
                "\"size\":100}," +
                "{\"name\":\"file2.png\"," +
                "\"mimeType\":\"image/png\"," +
                "\"size\":1000}" +
                "]," +
                "\"folders\": [" +
                "{\"name\":\"folder2\"," +
                "\"files\": [" +
                "{\"name\":\"file3.png\"," +
                "\"mimeType\":\"image/png\"," +
                "\"size\":1050}]" +
                "}]" +
                "}");
        assertEquals(folder, parserFolder);
    }
}