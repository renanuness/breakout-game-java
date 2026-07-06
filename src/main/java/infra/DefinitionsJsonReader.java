package infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Definitions;
import domain.exceptions.DefinitionsReadException;
import domain.interfaces.DefinitionsReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class DefinitionsJsonReader implements DefinitionsReader {
    private ObjectMapper mapper;
    private String fileName;

    public DefinitionsJsonReader(String filename) {
        this.mapper = new ObjectMapper();
        this.fileName = filename;

    }

    @Override
    public Definitions readDefinitions() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            Objects.requireNonNull(inputStream, "File not found: " + fileName);
            var contentString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            Definitions definitions = mapper.readValue(contentString, Definitions.class);
            return definitions;
        } catch (IOException e) {
            e.printStackTrace();
            throw new DefinitionsReadException(fileName);
        }
    }
}
