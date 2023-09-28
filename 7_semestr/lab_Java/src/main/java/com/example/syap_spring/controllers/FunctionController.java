package com.example.syap_spring.controllers;

import com.example.syap_spring.request_history.RequestHistory;
import com.example.syap_spring.funcs.NumberFlipper;
import com.example.syap_spring.funcs.RemoveDuplicates;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FunctionController {

    private final Map<String, List<RequestHistory>> fullHistory = new HashMap<>();
    private final Map<String, List<RequestHistory>> uniqueHistory = new HashMap<>();

    @PostMapping("/flipNumber")
    public int flipNumber(@RequestBody int numberToFlip) {
        int result = NumberFlipper.flipNumber(numberToFlip);
        updateHistory("flipNumber", numberToFlip, result);
        return result;
    }

    @GetMapping("/removeDuplicates")
    public List<Integer> removeDuplicates(@RequestParam List<Integer> numbers) {
        List<Integer> result = RemoveDuplicates.removeDuplicates(numbers);
        updateHistory("removeDuplicates", numbers, result);
        return result;
    }

    @GetMapping("/history")
    public Map<String, Map<String, List<RequestHistory>>> getHistory() {
        Map<String, Map<String, List<RequestHistory>>> result = new HashMap<>();
        result.put("flipNumber", getHistoryForFunction("flipNumber"));
        result.put("removeDuplicates", getHistoryForFunction("removeDuplicates"));
        return result;
    }

    private Map<String, List<RequestHistory>> getHistoryForFunction(String functionName) {
        Map<String, List<RequestHistory>> historyMap = new HashMap<>();
        historyMap.put("all", fullHistory.getOrDefault(functionName, new ArrayList<>()));
        historyMap.put("unique", uniqueHistory.getOrDefault(functionName, new ArrayList<>()));
        return historyMap;
    }

    private void updateHistory(String functionName, Object input, Object result) {
        if (!fullHistory.containsKey(functionName)) {
            fullHistory.put(functionName, new ArrayList<>());
        }
        if (!uniqueHistory.containsKey(functionName)) {
            uniqueHistory.put(functionName, new ArrayList<>());
        }

        RequestHistory requestHistory = new RequestHistory(input, result);
        fullHistory.get(functionName).add(requestHistory);

        // Only add to unique history if it's not already there
        if (!uniqueHistory.get(functionName).contains(requestHistory)) {
            uniqueHistory.get(functionName).add(requestHistory);
        }
    }
}