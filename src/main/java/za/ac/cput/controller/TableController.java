package za.ac.cput.controller;
/* TableController.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;
import za.ac.cput.service.TableService;
import java.util.List;

@RestController
@RequestMapping("/table/")
@Slf4j
public class TableController {

    @Autowired
    private TableService tableService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Tables create(@RequestBody Tables tables) {
        Tables newTable = TablesFactory.createTables(
                tables.getTableID(),
                tables.getTableStatus(),
                tables.getCapacity(),
                tables.getTableType());
        return tableService.create(newTable);
    }

    @RequestMapping("/read/{tableID}")
    public Tables read(@PathVariable String tableID){
        return tableService.read(tableID);
    }

    @PostMapping("/update")
    public Tables update(@RequestBody Tables tables)
    {return tableService.update(tables);}


    @DeleteMapping("/delete/{tableID}")
    public boolean delete(@PathVariable String tableID) {
        return tableService.delete(tableID);}


    @GetMapping("/findAll")
    public List<Tables> findAll() {
        return tableService.findAll();


    }


}


