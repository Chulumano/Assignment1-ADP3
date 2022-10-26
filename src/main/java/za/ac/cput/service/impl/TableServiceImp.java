package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tables;
import za.ac.cput.repository.TablesRepository;
import za.ac.cput.service.TableService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableServiceImp implements TableService {

    private static TableService service;

    @Autowired
    private TablesRepository tablesRepository;



    @Override
    public Tables create(Tables tables) {
        return this.tablesRepository.save(tables);

    }

    @Override
    public Tables read(String tableID) {
        return this.tablesRepository.findById(tableID)
                .orElse(null);
    }


    @Override
    public Tables update(Tables tables) {
        if (this.tablesRepository.existsById(tables.getTableID()))
            return this.tablesRepository.save(tables);
        return tables;
    }

    @Override
    public boolean delete(String tableID) {
        this.tablesRepository.deleteById(tableID);
        if (this.tablesRepository.existsById(tableID)) {
            System.out.println("Table: " + tableID + " is not Deleted");
            return false;
        } else {
            System.out.println("Table has been deleted");
            return true;
        }
    }

    @Override
    public List<Tables> findAll() {
        return this.tablesRepository.findAll().stream().collect(Collectors.toList());
    }
}

