package main.controller;

import main.repository.entity.FileEntity;
import main.repository.entity.FolderEntity;
import main.controller.parser.ParserDTO;
import main.controller.parser.dto.FileDTO;
import main.controller.parser.dto.FolderDTO;
import main.service.FileService;
import main.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class InputController {
    private FolderService folderService;
    private FileService fileService;

    @Autowired
    public InputController(FolderService folderService, FileService fileService) {
        this.folderService = folderService;
        this.fileService = fileService;
    }

    @PostMapping("/input")
    public ResponseEntity<String> input(@RequestBody String json) {
        ParserDTO parser = new ParserDTO();
        FolderDTO root;
        try {
            root = parser.parse(json);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        insertData(root);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void insertData(FolderDTO folder) {
        folderService.save(new FolderEntity(folder.getPath()));
        int current = folderService.findByPath(folder.getPath()).get().getId();

        for (FileDTO file : folder.getFiles()) {
            FileEntity insertion = new FileEntity(file.getName(), file.getMime_type(), file.getSize(), current);
            fileService.save(insertion);
        }

        for (FolderDTO f : folder.getFolders())
            insertData(f);

    }
}
