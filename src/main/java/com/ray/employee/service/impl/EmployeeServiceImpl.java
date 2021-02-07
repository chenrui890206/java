package com.ray.employee.service.impl;


//import com.ray.employee.model.Employee;
import com.ray.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Package: com.ray.demo.service.impl
 * @Author: Ray
 * @CreateTime: 2020/10/27 17:06
 * @E-mail: 634302021@qq.com
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

    @Override
    public void update() {
		String sql = "update employee set salary=salary-1 where id=1";
		try {
			jdbcTemplate.update(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
