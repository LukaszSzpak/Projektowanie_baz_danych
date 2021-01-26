package com.library.libraryDB.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.library.libraryDB.entities.Book;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class BookSerializer extends JsonSerializer<Book> {
    @Override
    public void serialize(Book book, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        long[] itemList = new long[book.getItemList().size()];
        for (int i = 0; i < book.getItemList().size(); i++)
            itemList[i] = book.getItemList().get(i).getId();

        jgen.writeStartObject();
        jgen.writeNumberField("id", book.getId());
        jgen.writeStringField("title", book.getTitle());
        jgen.writeStringField("author", book.getAuthor().getName());
        jgen.writeStringField("description", book.getDescription());
        jgen.writeBooleanField("available", book.isAvailable());

        jgen.writeArrayFieldStart("itemList");
        jgen.writeArray(itemList, 0, itemList.length);
        jgen.writeEndArray();

        jgen.writeEndObject();
    }
}
