package com.example.demo.thread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadTestController {

    private static int counter = 0;

    @GetMapping("/test")
    public String test() throws InterruptedException {
        int currentCount;

        synchronized (ThreadTestController.class) {
            currentCount = ++counter;
        }

        long threadId = Thread.currentThread().getId();
        System.out.println("▶️ 요청 #" + currentCount + " 처리 중 - Thread ID: " + threadId);

        // 60초 대기
        Thread.sleep(60_000);

        System.out.println("✅ 요청 #" + currentCount + " 완료 - Thread ID: " + threadId);
        return "요청 #" + currentCount + " 처리 완료 (Thread ID: " + threadId + ")";
    }
}
