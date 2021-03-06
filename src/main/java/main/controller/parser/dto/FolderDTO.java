package main.controller.parser.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode()
public class FolderDTO {
    private String name;
    private ArrayList<FolderDTO> folders;
    private ArrayList<FileDTO> files;
    private String path = "";

    public FolderDTO() {
        folders = new ArrayList<>();
        files = new ArrayList<>();
    }

}
