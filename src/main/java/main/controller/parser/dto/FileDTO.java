package main.controller.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FileDTO {
    private String name;
    private String mime_type;
    private int size;
}
