/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datasetpreparation;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import joinery.DataFrame;

import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.datetimes.DateTimeColumnFormatter;


import tech.tablesaw.io.DataReader;
import tech.tablesaw.io.Source;
import tech.tablesaw.io.DataFrameReader;


public class NewMain {

    public static void main(String[] args) throws IOException {
        final String titanic_csv_file_location = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\DataSetPreparation\\src\\main\\java\\com\\mycompany\\datasetpreparation\\titanic.csv";
        // --------------------- joinery -----------------------------
        // load the Titanic data set provided as a csv file
        DataFrame J_titanic_DF = DataFrame.readCsv(titanic_csv_file_location);
        System.out.println(J_titanic_DF);
        /**
         * Using joinery to perform some data exploration activities such as: 
         * getting information about the data 
         * (min, max, standard deviation, etc.) 
         */
        System.out.println(J_titanic_DF.describe());
        
        /**
         * Create 2 DataFrame Objects and try to join, merge, add columns of 
         * specific data types to both DataFrames 
         */
        
        List<Integer> index = new ArrayList<>();
        IntStream.range( 0,J_titanic_DF.length()-1 ).forEach(index::add);
        DataFrame newDF = J_titanic_DF.add("new index" ,index);
        System.out.println(newDF.describe());
        
        System.out.println("================================================================================");
        // --------------------- tablesaw -----------------------------
        // load the Titanic data set provided as a csv file
        
        
        Table TS_titanic_t = Table.read().csv(new File(titanic_csv_file_location)); 
        System.out.println(TS_titanic_t);
        
        /**
         * Using tablesaw to perform some data exploration activities such as: 
         * getting information about the data 
         * (min, max, standard deviation, etc.) 
         */
        
        System.out.println(TS_titanic_t.summary());
        
        /**
         * Create 2 DataFrame Objects and try to join, merge, add columns of 
         * specific data types to both DataFrames 
         */
        
        List<LocalDate> date = new ArrayList<>();
        
        IntStream.range(1, TS_titanic_t.rowCount()).forEach((v) -> date.add(LocalDate.of(2021 , 3 , v%31 == 0? 1 : v%31)));
        
        DateColumn lastmodified = DateColumn.create("last modified date", date); 
        lastmodified.append(LocalDate.MAX);
        TS_titanic_t.addColumns(lastmodified);
        System.out.println(TS_titanic_t);
        
        
        
        
        
        
        
        
        
        
    }
    
}
