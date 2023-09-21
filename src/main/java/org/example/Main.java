package org.example;

import org.example.services.JpaCriteriaService;
import org.example.services.MemberInfo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JpaCriteriaService criteriaExample = new JpaCriteriaService();
        List<MemberInfo> results = criteriaExample.findMembersWithoutEntranceRights();

        for (MemberInfo result : results) {
            System.out.println(result);
        }
        criteriaExample.close();
    }
}
