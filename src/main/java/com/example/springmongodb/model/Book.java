package com.example.springmongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection="Book")
public class Book {
    @Id
    @ApiModelProperty(notes=" Book ID to be stored in MongoDB")
    private int id;
    @ApiModelProperty(notes=" BookName to be stored in MongoDB")
    private String bookname;
    @ApiModelProperty(notes=" Book Author Name to be stored in MongoDB")
    private String authorname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }



    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    
    
}
