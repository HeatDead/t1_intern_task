package com.example.t1_intern_task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MainService {
    public String getNumOfChars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            int c = map.getOrDefault(ch, 0);
            c++;
            map.put(ch, c);
        }

        List<Map.Entry<Character, Integer>> n = map.entrySet().stream()
                .sorted(Comparator.comparingInt(x -> -x.getValue())).toList();

        StringBuilder out = new StringBuilder();
        for (Map.Entry<Character, Integer> o : n)
            out.append(String.format("\"%s\":%d, ", o.getKey(), o.getValue()));

        if (out.length() > 0)
            out.delete(out.length()-2, out.length());
        return out.toString();
    }
}
