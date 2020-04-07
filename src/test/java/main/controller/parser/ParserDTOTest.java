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
        file1.setMime_type("file/txt");
        file1.setSize(100);
        ArrayList<FileDTO> files = new ArrayList<>();
        files.add(file1);
        folder.setFiles(files);
        ParserDTO parser = new ParserDTO();
        FolderDTO parserFolder = parser.parse("{" +
                "\"name\": \"root\", " +
                "\"files\": [" +
                "{\"name\":\"file1.txt\"," +
                "\"mime_type\":\"file/txt\"," +
                "\"size\":100}]}");
        assertEquals(folder, parserFolder);

    }

    @Test
    void jacksonHard(){

    }
}