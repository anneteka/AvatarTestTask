package main.controller.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.controller.parser.dto.FolderDTO;

import java.io.IOException;

public class ParserDTO {
    private ObjectMapper mapper;

    public ParserDTO() {
        mapper = new ObjectMapper();
    }

    public FolderDTO parse(String json) throws IOException {
        FolderDTO root = mapper.readValue(json, FolderDTO.class);
        generatePaths(root, "");
        return root;
    }

    private void generatePaths(FolderDTO folder, String currentPath) {
        folder.setPath(currentPath + "/" + folder.getName());
        for (FolderDTO f : folder.getFolders())
            generatePaths(f, folder.getPath());

    }

}
