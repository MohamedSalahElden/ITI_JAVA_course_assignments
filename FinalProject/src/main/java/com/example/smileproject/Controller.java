package com.example.smileproject;

import org.apache.commons.csv.CSVFormat;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.style.Styler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.BaseVector;
import smile.io.Read;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@RestController
public class Controller {

    DataFrame df = null;

    @RequestMapping("/")
    public String mainPage() throws IOException, URISyntaxException {
        //call function to get data set
        df = Dao.getData("src/main/resources/Wuzzuf_Jobs.csv");
        return  "<p> <a href=\"/show \">     show data set     </a></p>"+
                "<p> <a href=\"/strcture\">show structure</a></p>"+
                "<p> <a href=\"/summary\">show summary</a></p>"+
                "<p> <a href=\"/jobsCount\">count the jobs</a></p>"+
                "<p> <a href=\"/jobTitle\">most popular job title</a></p>"+
                "<p> <a href=\"/area\">most popular area</a></p>"+
                "<p> <a href=\"/skills\">most popular skills</a>";
    }

    @RequestMapping("/show")
    public String showData()  {
        return ViewUtils.sendDataString(df.toString());
    }

    @RequestMapping("/strcture")
    public String showStructure()  {
        return ViewUtils.sendDataString(df.structure().toString());
    }

    @RequestMapping("/summary")
    public String showSummary()  {
        return ViewUtils.sendDataString(df.summary().toString()+
                "\n====================================================================================================================\n" +
                df.schema().toString());
    }

    @RequestMapping("/jobsCount")
    public String showJobCount() throws IOException, URISyntaxException {
        Map<String , Long> temp = Analyse.getData(df , "Company");
        PieChart chart = new Draw().pi(temp , 20);
        return ViewUtils.sendChartString(chart);
    }

    @RequestMapping("/jobTitle")
    public String showTitles() throws IOException {
        Map<String , Long> temp = Analyse.getData(df , "Title");
        CategoryChart chart = new Draw().bar(temp , 10);
        return ViewUtils.sendChartString(chart);
    }

    @RequestMapping("/area")
    public String showAreas() throws IOException {
        Map<String , Long> temp = Analyse.getData(df , "Country");
        CategoryChart chart = new Draw().bar(temp , 10);
        return ViewUtils.sendChartString(chart);
    }

    @RequestMapping("/skills")
    public String showSkills()  {
        String output = "";
        Map<String, Integer> temp = Analyse.split_column(df);

        List keys = temp.keySet().stream().collect(Collectors.toList());

        for(int i=0 ; i< temp.size() ; i++){
            output += keys.get(i).toString() +":\t "+ temp.get(keys.get(i)).toString();
            output += "\n";
        }
        return ViewUtils.sendDataString(output);
    }


}