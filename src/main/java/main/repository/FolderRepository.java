package main.repository;

import main.repository.entity.FolderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends CrudRepository<FolderEntity, Integer> {
    FolderEntity save(FolderEntity folderEntity);

    Optional<FolderEntity> findById(Integer id);

    Optional<FolderEntity> findByPath(String path);

    List<FolderEntity> findAll();

    List<FolderEntity> findAllByPathIsStartingWith(String parent);
}
