package ru.netology.sqldao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private final String script;

    private final NamedParameterJdbcTemplate template;


    public Repository(NamedParameterJdbcTemplate template) {
        this.template = template;
        try (InputStream is = new ClassPathResource("/myScript.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            script = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        List<String> result = template.queryForList(script, param, String.class);
        return result.isEmpty() ? Collections.singletonList("Nothing found") : result;
    }


}
