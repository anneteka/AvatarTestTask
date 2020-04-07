package main.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "folder")
@Getter
@Setter
@ToString
public class FolderEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    @NotNull
    private String path;

    public FolderEntity() {
    }

    public FolderEntity(@NotNull String path) {
        this.path = path;
    }

}
