package bit.project.server.controller;

import bit.project.server.dao.CollectionDao;
import bit.project.server.entity.Collection;
import bit.project.server.util.helper.CodeGenerator;
import bit.project.server.util.security.AccessControlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

    @CrossOrigin
    @RestController
    @RequestMapping("/reports")
    public class ReportController {

        @Autowired
        private CollectionDao collectionDao;

        @Autowired
        private AccessControlManager accessControlManager;

        @Autowired
        private CodeGenerator codeGenerator;

        private static final Sort DEFAULT_SORT = Sort.by(Sort.Direction.DESC, "tocreation");
        private final CodeGenerator.CodeGeneratorConfig codeConfig;

        public ReportController(){
            codeConfig = new CodeGenerator.CodeGeneratorConfig("customer");
            codeConfig.setColumnName("code");
            codeConfig.setLength(10);
            codeConfig.setPrefix("CU");
            codeConfig.setYearlyRenew(true);
        }
        @GetMapping("/monthly-collection/{year}")
        public LinkedHashMap<String, BigDecimal> monthlyCollection(@PathVariable int year) {
            LinkedHashMap<String,BigDecimal> data = new LinkedHashMap<>();
            List<Collection> collectionList = collectionDao.findAll(DEFAULT_SORT);
            List<BigDecimal> collectionCountList = new ArrayList<BigDecimal>(Collections.nCopies(12, BigDecimal.valueOf(0)));

            for (Collection collection : collectionList) {
                if (collection.getDate() != null && collection.getDate().getYear() == year) {
                    if (collection.getDate().getMonth().toString().equals("JANUARY")) {
                        collectionCountList.set(0,collectionCountList.get(0).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("FEBRUARY")) {
                        collectionCountList.set(1,collectionCountList.get(1).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("MARCH")) {
                        collectionCountList.set(2,collectionCountList.get(2).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("APRIL")) {
                        collectionCountList.set(3,collectionCountList.get(3).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("MAY")) {
                        collectionCountList.set(4,collectionCountList.get(4).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("JUNE")) {
                        collectionCountList.set(5,collectionCountList.get(5).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("JULY")) {
                        collectionCountList.set(6,collectionCountList.get(6).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("AUGUST")) {
                        collectionCountList.set(7,collectionCountList.get(7).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("SEPTEMBER")) {
                        collectionCountList.set(8,collectionCountList.get(8).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("OCTOBER")) {
                        collectionCountList.set(9,collectionCountList.get(9).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("NOVEMBER")) {
                        collectionCountList.set(10,collectionCountList.get(10).add(collection.getWeight()));
                    }
                    if (collection.getDate().getMonth().toString().equals("DECEMBER")) {
                        collectionCountList.set(11,collectionCountList.get(11).add(collection.getWeight()));
                    }
                }
                System.out.println(collectionCountList);
            }

            data.put("JANUARY", collectionCountList.get(0));
            data.put("FEBRUARY", collectionCountList.get(1));
            data.put("MARCH", collectionCountList.get(2));
            data.put("APRIL", collectionCountList.get(3));
            data.put("MAY", collectionCountList.get(4));
            data.put("JUNE", collectionCountList.get(5));
            data.put("JULY", collectionCountList.get(6));
            data.put("AUGUST", collectionCountList.get(7));
            data.put("SEPTEMBER", collectionCountList.get(8));
            data.put("OCTOBER", collectionCountList.get(9));
            data.put("NOVEMBER", collectionCountList.get(10));
            data.put("DECEMBER", collectionCountList.get(11));
            System.out.println(data);

            return data;


        }

    }
//
//package bit.project.server.controller;
//
//
//        import bit.project.server.UsecaseList;
//        import bit.project.server.dao.StudentDao;
//        import bit.project.server.util.security.AccessControlManager;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.*;
//
//        import javax.servlet.http.HttpServletRequest;
//        import java.time.LocalDate;
//        import java.time.format.DateTimeFormatter;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.LinkedHashMap;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/reports")
//public class ReportController {
//
//    @Autowired
//    StudentDao studentDao;
//
//    @Autowired
//    private AccessControlManager accessControlManager;
//
//    @GetMapping("/year-wise-student-count/{yearCount}")
//    public ArrayList<HashMap<String, Object>> yearWiseStudentCount(@PathVariable Integer yearCount, HttpServletRequest request){
//        accessControlManager.authorize(request, "No privilege to show this report", UsecaseList.SHOW_YEAR_WISE_STUDENT_COUNT);
//
//        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
//
//        ArrayList<LocalDate[]> years = new ArrayList<>();
//
//        LocalDate[] currentYear = new LocalDate[2];
//        currentYear[0] = LocalDate.parse(LocalDate.now().getYear()+"-01-01");
//        currentYear[1] = LocalDate.parse(LocalDate.now().getYear()+"-12-31");
//        years.add(currentYear);
//
//        for (int i=0; i<yearCount-1; i++){
//            LocalDate[] year = new LocalDate[2];
//            LocalDate[] lastYear = years.get(years.size()-1);
//            year[0] = lastYear[0].minusYears(1);
//            year[1] = lastYear[1].minusYears(1);
//            years.add(year);
//        }
//
//        for (LocalDate[] year : years){
//            String y = String.valueOf(year[0].getYear());
//            Long count = studentDao.getStudentCountByRange(year[0], year[1]);
//            HashMap<String, Object> d = new HashMap<>();
//            d.put("year", y);
//            d.put("count", count);
//            data.add(d);
//        }
//
//        return data;
//    }
//
//}
