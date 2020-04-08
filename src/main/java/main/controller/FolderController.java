package main.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.controller.parser.dto.FileDTO;
import main.controller.parser.dto.FolderDTO;
import main.repository.entity.FileEntity;
import main.repository.entity.FolderEntity;
import main.service.FileService;
import main.service.FolderService;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    private FolderService folderService;
    private FileService fileService;

    @Autowired
    public FolderController(FolderService folderService, FileService fileService) {
        this.folderService = folderService;
        this.fileService = fileService;
    }

    @GetMapping("/folder-children")
    public ResponseEntity<List<FolderEntity>> getFolderChildren(@RequestParam String path) {

        Optional<FolderEntity> folder = folderService.findByPath(path);
        if (!folder.isPresent())
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        else
            return new ResponseEntity<>(folderService.findAllByParent(path + '/'), HttpStatus.OK);

    }

    @GetMapping("/folder-files")
    public ResponseEntity<List<FileEntity>> getFolderFiles(@RequestParam String path) {
        Optional<FolderEntity> folder = folderService.findByPath(path);
        return folder.map(folderEntity -> new ResponseEntity<>(fileService.getAllByFolder(folderEntity.getId()), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @GetMapping("/folder-exists")
    public JSONObject folderExists(@RequestParam String path) {
        JSONObject json = new JSONObject();
        json.append("path", path).append("exists", folderService.findByPath(path).isPresent());
        return json;
    }
}
