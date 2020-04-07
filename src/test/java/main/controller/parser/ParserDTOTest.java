package main.controller.parser;

import main.controller.parser.dto.FolderDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    void jacksonMedium(){

    }

    @Test
    void jacksonHard(){

    }
}