package main.repository;

import main.repository.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends CrudRepository<FileEntity, Integer> {
    List<FileEntity> getAllByFolder(int folder);

    FileEntity save(FileEntity fileEntity);

    Optional<FileEntity> findById(Integer id);

    List<FileEntity> findAll();

    List<FileEntity> findAllByFolder(int folder);
}
