package com.min0.corona.service;

import com.min0.corona.pojo.Corona;
import com.min0.corona.repository.CoronaRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoronaService {

    private final CoronaRepository coronaRepository;

    public void save (Corona corona) {
        coronaRepository.save(corona);
    }

    public void populateDatabase() throws IOException {
//        https://raw.githubusercontent.com/bgeVam/Kosovo-Coronatracker-Data/master/data.json
        URL url = new URL("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports_us/01-03-2022.csv");
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        int responseCode = huc.getResponseCode();

        log.info(String.valueOf(huc.getResponseCode()));
        if(responseCode == 200) {
            log.info("-- Successfully connected to github --");
            String csvFile = "C:\\Users\\Minyoung\\Desktop\\java\\spring boot\\corona\\src\\main\\resources\\01-01-2021.csv";
            BufferedReader input = new BufferedReader(new InputStreamReader(huc.getInputStream()), 8192);
            CSVReader reader = null;
//            reader = new CSVReader(new FileReader(csvFile));
            reader = new CSVReader(input);
            String[] line;
            int i = 0;
//            coronaRepository.deleteAll();
            while((line = reader.readNext()) != null) {
                if(i == 0) { // to skip the first line
                    i++;
                    continue;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Corona corona = new Corona();

                corona.setConfirmed((Long.valueOf(line[5])));
                if(!Objects.equals(line[7], "")) {
                    corona.setRecovered((Double.valueOf(line[7])));
                }
                if(!line[8].equals("")) {
                    corona.setActive((Double.valueOf(line[8])));
                }
//            corona.setCombinedKey(line[11]);
                corona.setLastUpdate(LocalDateTime.parse(line[2], formatter));
                coronaRepository.save(corona);
                log.info(corona.toString());

            }


        }
    }
}
