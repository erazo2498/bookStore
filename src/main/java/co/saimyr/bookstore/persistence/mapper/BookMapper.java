package co.saimyr.bookstore.persistence.mapper;

import co.saimyr.bookstore.domain.dto.BookDto;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {BookMapper.class})
public interface BookMapper {
    @Mappings({
            @Mapping(source = "isbn",target = "isbn"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "author",target = "author"),
            @Mapping(source = "publisher",target = "publisher"),
            @Mapping(source = "genre",target = "genre"),

    })
    BookDto toBookDto(BookEntity bookEntity);
    List<BookDto> toBooksDto(List<BookEntity> bookEntities);

    @InheritInverseConfiguration
    BookEntity toBookEntity(BookDto bookDto);
    List<BookEntity> toBooksEntities(List<BookDto> bookDtoListDto);
}
