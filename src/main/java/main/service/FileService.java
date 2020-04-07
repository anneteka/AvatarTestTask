package main.service;

import main.repository.FileRepository;
import main.repository.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<FileEntity> findAll() {
        return fileRepository.findAll();
    }

    public List<FileEntity> getAllByFolder(int folder) {
        return fileRepository.getAllByFolder(folder);
    }

    public FileEntity save(FileEntity fileEntity) {
        return fileRepository.save(fileEntity);
    }


    public Optional<FileEntity> findById(Integer id) {
        return fileRepository.findById(id);
    }

}
