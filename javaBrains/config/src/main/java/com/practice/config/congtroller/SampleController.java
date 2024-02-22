package com.practice.config.congtroller;

import com.practice.config.configData.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class SampleController {

    @Autowired
    public Db db;

    @Value("${db.name}")
    private String data;

    @Value("${sample.list}")
    private List<String> sampleList;

    @Value("#{${db.connection}}")
    private Map<String, String> dbValues;

    @GetMapping("/demo")
    public String getData() {
        return db.getConnection() + "/\n"+ db.getName() + "/\n" + db.getSource();

    }
    @GetMapping("/demoList")
    public List<String> getDataList() {
        return sampleList;
    }

    @GetMapping("/demoObject")
    public Map<String, String> getDataObject() {
        return dbValues;
    }

}
