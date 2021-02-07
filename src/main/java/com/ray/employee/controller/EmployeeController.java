package com.ray.employee.controller;

//import com.ray.employee.model.Employee;
import com.ray.employee.service.EmployeeService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Package: com.ray.demo
 * @Author: Ray
 * @CreateTime: 2020/9/20 2:37
 * @E-mail: 634302021@qq.com
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

//    @RequestMapping("delete")
//    public void delete() {
//        employeeService.update();
//    }

    /**
     * 用了分布式锁
     */
    @GetMapping("/test")
    public void deduceGoods() {
        RLock rlock = redissonClient.getLock("good");
        //设置锁超时时间，防止异常造成死锁
        rlock.lock(5, TimeUnit.SECONDS);
        
        try {
            //执行业务逻辑
            int goods = Integer.parseInt(stringRedisTemplate.opsForValue().get("goods"));
            int realGoods = goods - 1;
            if (goods > 0) {
                stringRedisTemplate.opsForValue().set("goods", realGoods + "");
                System.out.println("你已经成功秒杀商品，此时还剩余：" + realGoods + "件");
            } else {
                System.out.println("商品已经售罄，欢迎下次活动");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rlock.unlock();
        }

    }

    /**
     * 没用分布式锁
     */
    @GetMapping("/test2")
    public void deduceGoods2() {
//        long goods = stringRedisTemplate.opsForValue().increment("goods",-1);
        int goods = Integer.parseInt(stringRedisTemplate.opsForValue().get("goods"));
        int realGoods = goods - 1;
        stringRedisTemplate.opsForValue().set("goods", realGoods + "");
        System.out.println("剩余：" + realGoods);
//        if (goods > 0) {
//
//            System.out.println("你已经成功秒杀商品，此时还剩余：" + goods + "件");
//        } else {
//            System.out.println("商品已经售罄，欢迎下次活动");
//        }

    }
}
