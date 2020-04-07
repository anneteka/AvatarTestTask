package main.service;

import main.repository.FolderRepository;
import main.repository.entity.FolderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderEntity save(FolderEntity folderEntity) {
        return folderRepository.save(folderEntity);
    }

    public Optional<FolderEntity> findById(Integer id) {
        return folderRepository.findById(id);
    }

    public List<FolderEntity> findAll() {
        return folderRepository.findAll();
    }

    public Optional<FolderEntity> findByPath(String path) {
        return folderRepository.findByPath(path);
    }

    public List<FolderEntity> findAllByParent(String parent) {
        return folderRepository.findAllByPathIsStartingWith(parent);
    }
}
