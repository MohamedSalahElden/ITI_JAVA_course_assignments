package com.example.smileproject;

import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.io.Read;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class Dao {

    public static DataFrame getData(String source) throws IOException, URISyntaxException {
            DataFrame df = null;
            CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
            df = Read.csv(source, format);
            return df;
    }



}
