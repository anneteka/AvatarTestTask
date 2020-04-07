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
@Table(name = "file")
@Getter
@Setter
@ToString
public class FileEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String mime_type;

    @NotNull
    private int size;

    @NotNull
    @JsonIgnore
    private int folder;

    public FileEntity(@NotNull String name, @NotNull String mime_type, @NotNull int size, @NotNull int folder) {
        this.name = name;
        this.mime_type = mime_type;
        this.size = size;
        this.folder = folder;
    }

    public FileEntity() {
    }
}
