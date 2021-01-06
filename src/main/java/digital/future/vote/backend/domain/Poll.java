package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;
import io.micronaut.data.jdbc.annotation.JoinTable;
import io.micronaut.data.model.DataType;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@MappedEntity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Poll {
    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String title;

    String description;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
    LocalDateTime timeStart;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
    LocalDateTime timeEnd;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ssZ")
    OffsetDateTime created;

    @DateUpdated
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ssZ")
    OffsetDateTime updated;

    @TypeDef(type = DataType.STRING) //TODO Use type JSON or JSONB for Postgres
    List<PollQuestion> questions;
}
