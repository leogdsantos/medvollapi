package med.voll.api.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbinfo")
    public String dbInfo() throws SQLException {
        return dataSource.getConnection().getCatalog();  // Retorna o banco usado na conexão
    }
}

