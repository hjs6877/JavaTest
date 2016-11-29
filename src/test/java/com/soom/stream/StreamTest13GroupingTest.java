package com.soom.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-11-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class StreamTest13GroupingTest {
    private List<RemoveLog> removeLogList;

    @Before
    public void beforeClass(){
        removeLogList = Arrays.asList(
                new RemoveLog("1111","Kevin-old", "19800403", "本人", "マイナンバー", "", "2014-02-01 09:29:12.111"),
                new RemoveLog("2222","Kevin-new", "19800403", "本人", "マイナンバー", "", "2016-05-01 10:40:22.222"),
                new RemoveLog("3333","Kevin-wife", "19851210", "被扶養者", "マイナンバー", "", "2016-05-01 10:40:23.222"),
                new RemoveLog("4444","Kevin-son", "20050221", "被扶養者", "マイナンバー", "", "2016-05-01 10:40:24.222"),
                new RemoveLog("2222","Kevin-new", "19800403", "本人", "確認書類", "", "2016-05-01 10:40:22.111"),
                new RemoveLog("3333","Kevin-wife", "19851210", "被扶養者", "確認書類", "", "2016-05-01 10:40:23.111"),
                new RemoveLog("4444","Kevin-son", "20050221", "被扶養者", "確認書類", "", "2016-05-01 10:40:24.111")
        );
    }

    @Test
    public void sortTest(){
        List<RemoveLog> resultList = removeLogList.stream().sorted(comparing(RemoveLog::getRemoveDate).reversed()).collect(toList());
        for(RemoveLog removeLog : resultList){
            System.out.println(removeLog.getRemoveDate());
        }
    }

    @Test
    public void singleGroupingTest(){
        Map map = removeLogList.stream().collect(groupingBy(RemoveLog::getRelation));
        List<RemoveLog> emp = (List<RemoveLog>)map.get("本人");
        List<RemoveLog> sus = (List<RemoveLog>)map.get("被扶養者");


        for(RemoveLog removeLog : emp){
            System.out.println(removeLog.getMymubmerId() + ":" + removeLog.getRemoveTarget() + ":" + removeLog.getRemoveDate());
        }
        System.out.println("=================== 피부양자 =======================");
        Collections.sort(sus, new Comparator<RemoveLog>() {
            @Override
            public int compare(RemoveLog o1, RemoveLog o2) {
                return o2.getBirthDate().compareTo(o1.getBirthDate());
            }
        });

        List<RemoveLog> resultList = Stream.concat(emp.stream(), sus.stream()).collect(toList());
        for(RemoveLog removeLog : sus){
            System.out.println(removeLog.getMymubmerId() + ":" + removeLog.getBirthDate() + " : " + removeLog.getRemoveTarget() + ":" + removeLog.getRemoveDate());
        }

        System.out.println("================ 최종 ================");
        for(RemoveLog removeLog : resultList){
            System.out.println(removeLog.getMymubmerId() + ":" + removeLog.getBirthDate() + " : " + removeLog.getRemoveTarget() + ":" + removeLog.getRemoveDate());
        }

    }

}
