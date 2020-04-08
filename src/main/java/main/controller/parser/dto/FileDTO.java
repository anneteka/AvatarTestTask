package main.controller.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@Getter
@Setter
public class FileDTO {
    private String name;
    private String mimeType;
    private int size;
}
